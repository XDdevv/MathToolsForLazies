package com.abc.mathtoolsfordumbs.presentation.services.ekubEkuk.vm

import androidx.lifecycle.ViewModel
import com.abc.mathtoolsfordumbs.domain.use_case.EkubEkukUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EkubEkukViewModel @Inject constructor(
    private val ekubEkukUseCase: EkubEkukUseCase
) : ViewModel() {

    fun getEkub(numbers: List<Int>): Int {
        return ekubEkukUseCase.calculateEkub(numbers)
    }

    fun getEkuk(numbers: List<Int>): Int {
        return ekubEkukUseCase.calculateEkuk(numbers)
    }
}