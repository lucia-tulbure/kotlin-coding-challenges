package com.igorwojda.integer.printnumber.basic

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun printNumberByCreatingAnotherList(n: Int): List<Int> {
    val mutableList = mutableListOf<Int>()
    for (nr in n downTo 1) {
        mutableList.add(nr)
    }
    return mutableList
}

private fun printNumber(n: Int): List<Int> {
    return (n downTo 1).toList()
}

class RecursivePrintNumber {
    @Test
    fun `printNumber 0 return listOf()`() {
        printNumber(0) shouldBeEqualTo listOf()
    }

    @Test
    fun `printNumber 1 return listOf(1)`() {
        printNumber(1) shouldBeEqualTo listOf(1)
    }

    @Test
    fun `printNumber 3 return listOf(3, 2, 1)`() {
        printNumber(3) shouldBeEqualTo listOf(3, 2, 1)
    }

    @Test
    fun `printNumber 5 return listOf(5, 4, 3, 2, 1)`() {
        printNumber(5) shouldBeEqualTo listOf(5, 4, 3, 2, 1)
    }
}
