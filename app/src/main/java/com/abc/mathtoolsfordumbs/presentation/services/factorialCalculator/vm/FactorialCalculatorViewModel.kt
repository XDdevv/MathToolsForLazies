package com.abc.mathtoolsfordumbs.presentation.services.factorialCalculator.vm

import androidx.lifecycle.ViewModel
import com.abc.mathtoolsfordumbs.domain.use_case.FactorialCalculatorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FactorialCalculatorViewModel @Inject constructor(
    private val factorialCalculatorUseCase: FactorialCalculatorUseCase
) : ViewModel() {

    fun calculateFactorial(number: Int): Long {
        return factorialCalculatorUseCase(number)
    }
}