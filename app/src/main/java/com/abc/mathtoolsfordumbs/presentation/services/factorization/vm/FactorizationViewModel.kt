package com.abc.mathtoolsfordumbs.presentation.services.factorization.vm

import androidx.lifecycle.ViewModel
import com.abc.mathtoolsfordumbs.domain.use_case.FactorizationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FactorizationViewModel @Inject constructor(
    private val factorizationUseCase: FactorizationUseCase
) : ViewModel() {

    fun factorizeNumber(number: Int): List<Int> {
        return factorizationUseCase(number)
    }
}