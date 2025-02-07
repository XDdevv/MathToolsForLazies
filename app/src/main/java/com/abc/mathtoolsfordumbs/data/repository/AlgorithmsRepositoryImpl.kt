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

    override fun gcdMultiple(numbers: List<Int>): Int {
        return numbers.reduce { acc, num -> gcd(acc, num) }
    }

    override fun lcmMultiple(numbers: List<Int>): Int {
        return numbers.reduce { acc, num -> lcm(acc, num) }
    }

    override fun factorization(number: Int): List<Int> {
        return primeFactorization(number)
    }

    override fun findDivisors(number: Int): List<Int> {
        return findingDivisors(number)
    }

    override fun factorialCalculator(number: Int): Long {
        return factorial(number)
    }

    override fun fibonacciGenerator(number: Int): List<Int> {
        return fibonacci(number)
    }

    fun fibonacci(n: Int): List<Int> {
        val sequence = mutableListOf(0, 1)
        for (i in 2 until n) {
            sequence.add(sequence[i - 1] + sequence[i - 2])
        }
        return sequence
    }

    fun factorial(n: Int): Long {
        return if (n == 0) 1 else n * factorial(n - 1)
    }

    fun findingDivisors(n: Int): List<Int> {
        val divisors = mutableListOf<Int>()
        for (i in 1..n) {
            if (n % i == 0) {
                divisors.add(i)
            }
        }
        return divisors
    }


    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    fun lcm(a: Int, b: Int): Int {
        return (a / gcd(a, b)) * b
    }

    fun primeFactorization(n: Int): List<Int> {
        var num = n
        val factors = mutableListOf<Int>()

        while (num % 2 == 0) {
            factors.add(2)
            num /= 2
        }

        var i = 3
        while (i * i <= num) {
            while (num % i == 0) {
                factors.add(i)
                num /= i
            }
            i += 2
        }

        if (num > 2) {
            factors.add(num)
        }

        return factors
    }
}
