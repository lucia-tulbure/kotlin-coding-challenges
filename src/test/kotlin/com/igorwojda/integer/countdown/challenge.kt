package com.igorwojda.integer.countdown

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun countDownByCreatingOtherList(n: Int): List<Int> {
    val myList = mutableListOf<Int>()
    for (nr in n downTo 0) {
        myList.add(nr)
    }
    return myList
}

private fun countDown(n: Int): List<Int> {
    return (n downTo 0).toList()
}

private class Test {
    @Test
    fun `count down 0`() {
        countDown(0) shouldBeEqualTo listOf(0)
    }

    @Test
    fun `count down 1`() {
        countDown(1) shouldBeEqualTo listOf(1, 0)
    }

    @Test
    fun `count down 5`() {
        countDown(5) shouldBeEqualTo listOf(5, 4, 3, 2, 1, 0)
    }
}
