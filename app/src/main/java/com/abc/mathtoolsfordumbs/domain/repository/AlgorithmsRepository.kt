package com.abc.mathtoolsfordumbs.domain.repository

interface AlgorithmsRepository {
    fun isPrime(number: Int): Boolean
    fun gcdMultiple(numbers: List<Int>): Int
    fun lcmMultiple(numbers: List<Int>): Int
    fun factorization(number: Int): List<Int>
    fun findDivisors(number: Int): List<Int>
    fun factorialCalculator(number: Int): Long
    fun fibonacciGenerator(number: Int): List<Int>
}