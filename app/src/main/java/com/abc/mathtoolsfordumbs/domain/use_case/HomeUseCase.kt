package com.abc.mathtoolsfordumbs.domain.use_case

import com.abc.mathtoolsfordumbs.domain.model.app.Option
import com.abc.mathtoolsfordumbs.domain.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {

    operator fun invoke(): Flow<Result<List<Option>>> {
        return homeRepository.getOptionList()
            .map { Result.success(it) }
            .catch {
                emit(Result.failure(it))
            }.flowOn(Dispatchers.IO)
    }

}