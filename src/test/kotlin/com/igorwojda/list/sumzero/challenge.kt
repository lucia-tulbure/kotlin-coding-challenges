package com.igorwojda.list.sumzero

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun sumZero(list: List<Int>): Pair<Int, Int>? {
    if (list.isEmpty()) {
        return null
    }
    var pointerFromBeginning = 0
    var pointerFromEnd = list.size - 1
    var sumPair: Int
    while (pointerFromBeginning != pointerFromEnd) {
        sumPair = list[pointerFromBeginning] + list[pointerFromEnd]
        when {
            sumPair == 0 -> return Pair(list[pointerFromBeginning], list[pointerFromEnd])
            sumPair < 0 -> pointerFromBeginning++
            sumPair > 0 -> pointerFromEnd--
        }
    }
    return null
}

private class Test {
    @Test
    fun `sumZero empty list return null`() {
        sumZero(listOf()) shouldBeEqualTo null
    }

    @Test
    fun `sumZero 1, 2 return null`() {
        sumZero(listOf(1, 2)) shouldBeEqualTo null
    }

    @Test
    fun `sumZero 1, 2, 4, 7 return null`() {
        sumZero(listOf(1, 2, 4, 7)) shouldBeEqualTo null
    }

    @Test
    fun `sumZero -4, -3, -2, 1, 2, 3, 5 return Pair(-3, 3)`() {
        sumZero(listOf(-4, -3, -2, 1, 2, 3, 5)) shouldBeEqualTo Pair(-3, 3)
    }

    @Test
    fun `sumZero -4, -3, -2, 1, 2, 5 return Pair(-2, 2)`() {
        sumZero(listOf(-4, -3, -2, 1, 2, 5)) shouldBeEqualTo Pair(-2, 2)
    }
}
