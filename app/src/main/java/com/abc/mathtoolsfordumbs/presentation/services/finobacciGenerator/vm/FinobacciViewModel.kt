package com.abc.mathtoolsfordumbs.presentation.services.finobacciGenerator.vm

import androidx.lifecycle.ViewModel
import com.abc.mathtoolsfordumbs.domain.use_case.FinobacciUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FinobacciViewModel @Inject constructor(
    private val finobacciUseCase: FinobacciUseCase
) : ViewModel() {

    fun generateFinobacciSquence(number: Int): List<Int> {
        return finobacciUseCase(number)
    }
}