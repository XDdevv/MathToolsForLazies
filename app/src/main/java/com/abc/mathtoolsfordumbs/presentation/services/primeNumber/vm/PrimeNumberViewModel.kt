package com.abc.mathtoolsfordumbs.presentation.services.primeNumber.vm

import androidx.lifecycle.ViewModel
import com.abc.mathtoolsfordumbs.domain.use_case.PrimeNumberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PrimeNumberViewModel @Inject constructor(
    private val primeNumberUseCase: PrimeNumberUseCase
) : ViewModel() {

    fun checkPrimeNumber(number: Int): Boolean {
        return primeNumberUseCase(number)
    }
}