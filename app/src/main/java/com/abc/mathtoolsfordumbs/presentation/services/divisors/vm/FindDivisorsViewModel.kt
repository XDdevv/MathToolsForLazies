package com.abc.mathtoolsfordumbs.presentation.services.divisors.vm

import androidx.lifecycle.ViewModel
import com.abc.mathtoolsfordumbs.domain.use_case.FindDivisorsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FindDivisorsViewModel @Inject constructor(
    private val findDivisorsUseCase: FindDivisorsUseCase
) : ViewModel() {

    fun findDivisors(n: Int): String {
        return findDivisorsUseCase.invoke(n).toString()
    }
}