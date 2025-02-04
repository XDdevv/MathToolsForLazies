package com.abc.mathtoolsfordumbs.presentation.home.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abc.mathtoolsfordumbs.domain.model.app.Option
import com.abc.mathtoolsfordumbs.domain.use_case.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.abc.mathtoolsfordumbs.utils.Resource
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase
) : ViewModel() {

    private val _optionsState = MutableStateFlow<Resource<List<Option>>>(Resource.Loading())
    val optionsState = _optionsState.asStateFlow()

    init {
        getOptions()
    }

    fun getOptions() {
        viewModelScope.launch {
            homeUseCase()
                .collect { data ->
                    if (data.isSuccess) {
                        _optionsState.value = Resource.Success(data.getOrNull())
                    } else {
                        _optionsState.value = Resource.Error(data.exceptionOrNull()?.message)
                    }
                }
        }
    }
}