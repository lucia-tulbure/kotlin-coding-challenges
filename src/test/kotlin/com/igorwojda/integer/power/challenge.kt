package com.igorwojda.integer.power

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun powerIterativeSolution(base: Int, exponent: Int): Int {
    var power = 1;
    for (i in 1..exponent) {
        power *= base
    }
    return power
}

private fun power(base: Int, exponent: Int): Int {
    return List(exponent) { base }.reduce(Int::times)
}

private class Test {
    @Test
    fun `power 2^1 returns 2`() {
        power(2, 1) shouldBeEqualTo 2
    }

    @Test
    fun `power 2^2 returns 2`() {
        power(2, 2) shouldBeEqualTo 4
    }

    @Test
    fun `power 2^3 returns 8`() {
        power(2, 3) shouldBeEqualTo 8
    }

    @Test
    fun `power 3^4 returns 81`() {
        power(3, 4) shouldBeEqualTo 81
    }
}
