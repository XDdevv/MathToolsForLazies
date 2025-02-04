package com.abc.mathtoolsfordumbs.data.repository

import android.app.Application
import com.abc.mathtoolsfordumbs.R
import com.abc.mathtoolsfordumbs.domain.model.app.Option
import com.abc.mathtoolsfordumbs.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val application: Application
): HomeRepository {
    override fun getOptionList(): Flow<List<Option>> = flow {
        emit(
            listOf(
                Option(
                    "Tub raqamlarni aniqlash",
                    R.id.primeNumberFragment
                ),
            )
        )
    }

}