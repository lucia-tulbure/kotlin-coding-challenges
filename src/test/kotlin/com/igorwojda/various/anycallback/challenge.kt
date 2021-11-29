package com.igorwojda.various.anycallback

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun anyCallbackA(list: List<Int>, callback: (Int) -> Boolean): Boolean {
    return list.filter(callback).count() > 0
}

private fun anyCallback(list: List<Int>, callback: (Int) -> Boolean): Boolean {
    if (list.size == 1) {
        return callback(list.first())
    }
    if (callback(list.first())) {
        return true
    }

    return anyCallback(list.drop(1), callback)
}

private class Test {
    @Test
    fun `any callback returns true`() {
        val callback: ((Int) -> Boolean) = { it > 3 }
        anyCallback(listOf(1, 2, 3, 4), callback) shouldBeEqualTo true
    }

    @Test
    fun `any callback returns false`() {
        val callback: ((Int) -> Boolean) = { it > 3 }
        anyCallback(listOf(1, 2, 3), callback) shouldBeEqualTo false
    }
}
