package com.abc.mathtoolsfordumbs.data.repository

import android.app.Application
import androidx.core.os.bundleOf
import com.abc.mathtoolsfordumbs.R
import com.abc.mathtoolsfordumbs.domain.model.app.Option
import com.abc.mathtoolsfordumbs.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val application: Application
) : HomeRepository {
    override fun getOptionList(): Flow<List<Option>> = flow {
        emit(
            listOf(
                Option(
                    "Tub raqamlarni aniqlash",
                    R.id.primeNumberFragment
                ),
                Option(
                    "EKUBni topish",
                    R.id.ekubEkukFinderFragment,
                    bundleOf("title" to "EKUB")
                ),
                Option(
                    "EKUKni topish",
                    R.id.ekubEkukFinderFragment,
                    bundleOf("title" to "EKUK")
                ),
                Option(
                    "Ko'paytuvchilarga ajratish",
                    R.id.factorizationNumberFragment
                )
            )
        )
    }

}