package com.igorwojda.string.reverse

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun reverse(str: String): String {
    var reversed = ""
    (str.length - 1 downTo 0).forEach {
        reversed += str[it]
    }
    return reversed
}

private class Test {
    @Test
    fun `Reverse of "abcd" is "dcba"`() {
        reverse("abcd") shouldBeEqualTo "dcba"
    }

    @Test
    fun `Reverse of "aabbccdd" is "ccbbaadd"`() {
        reverse("aabbccdd") shouldBeEqualTo "ddccbbaa"
    }
}
