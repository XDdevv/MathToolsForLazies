package com.abc.mathtoolsfordumbs.domain.use_case

import com.abc.mathtoolsfordumbs.domain.repository.AlgorithmsRepository
import javax.inject.Inject

class FindDivisorsUseCase @Inject constructor(
    private val algorithmsRepository: AlgorithmsRepository
){

    operator fun invoke(number: Int) = algorithmsRepository.findDivisors(number)
}
