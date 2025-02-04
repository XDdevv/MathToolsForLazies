package com.abc.mathtoolsfordumbs.domain.repository

import com.abc.mathtoolsfordumbs.domain.model.app.Option
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getOptionList(): Flow<List<Option>>
}