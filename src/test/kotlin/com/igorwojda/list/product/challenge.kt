package com.igorwojda.list.product

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun productRecursive(list: List<Int>): Int {
    return if (list.size == 1) {
        list.first()
    } else {
        list.first() * product(list.drop(1))
    }
}

private fun productWithFoldOperation(list: List<Int>): Int {
    return list.fold(1) { product, element -> product * element }
}

private fun productWithReduceOperation(list: List<Int>): Int {
    return list.reduce { product, element -> product * element }
}

private fun product(list: List<Int>): Int {
    return list.reduce(Int::times)
}

private class Test {
    @Test
    fun `product 0 returns 0`() {
        product(listOf(0)) shouldBeEqualTo 0
    }

    @Test
    fun `product 1, 2, 3 returns 6`() {
        product(listOf(1, 2, 3)) shouldBeEqualTo 6
    }

    @Test
    fun `product 4, 2, 10 returns 80`() {
        product(listOf(2, 4, 10)) shouldBeEqualTo 80
    }
}
