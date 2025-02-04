package com.abc.mathtoolsfordumbs.data.repository

import android.app.Application
import com.abc.mathtoolsfordumbs.domain.repository.AlgorithmsRepository
import javax.inject.Inject

class AlgorithmsRepositoryImpl @Inject constructor(
    private val application: Application
) : AlgorithmsRepository {
    override fun isPrime(n: Int): Boolean {
        if (n < 2) return false
        if (n == 2 || n == 3) return true
        if (n % 2 == 0 || n % 3 == 0) return false

        var i = 5
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) return false
            i += 6
        }
        return true
    }

}