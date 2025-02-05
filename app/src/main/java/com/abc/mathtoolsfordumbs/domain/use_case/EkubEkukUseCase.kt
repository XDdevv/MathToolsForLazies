package com.abc.mathtoolsfordumbs.domain.use_case

import com.abc.mathtoolsfordumbs.domain.repository.AlgorithmsRepository
import javax.inject.Inject

class EkubEkukUseCase @Inject constructor(
    private val algorithmsRepository: AlgorithmsRepository
) {

    fun calculateEkub(numbers: List<Int>): Int {
        return algorithmsRepository.gcdMultiple(numbers)
    }

    fun calculateEkuk(numbers: List<Int>): Int {
        return algorithmsRepository.lcmMultiple(numbers)
    }
}