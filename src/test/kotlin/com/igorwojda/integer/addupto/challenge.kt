package com.igorwojda.integer.addupto

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test
// solution 1
private fun addUpToIterativeSolution(n: Int): Int {
    var sum = 0
    for (i in 1..n)
        sum += i
    return sum
}

// solution 2
private fun addUpTo(n: Int): Int {
   return n*(n+1)/2
}

//solution 3
private fun addUpToAggregateOperations(n: Int): Int {
   return (1..n).toList().sum()
}

private class Test {
    @Test
    fun `add up to 1`() {
        addUpTo(1) shouldBeEqualTo 1
    }

    @Test
    fun `add up to 3`() {
        addUpTo(3) shouldBeEqualTo 6
    }

    @Test
    fun `add up to 10`() {
        addUpTo(10) shouldBeEqualTo 55
    }
}
