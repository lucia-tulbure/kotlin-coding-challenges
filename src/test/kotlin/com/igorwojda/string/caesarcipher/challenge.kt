package com.igorwojda.string.caesarcipher

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun encodeCaesarCipher(str: String, shift: Int): String {

    val aLetterAsci = 'a'.toInt()
    val zLetterAsci = 'z'.toInt()
    val alphabetLength = zLetterAsci - aLetterAsci + 1
    val reducedShift = shift % alphabetLength
    return str.map {
        val encryptedLetterAscii = (it + reducedShift).toInt()
        if (encryptedLetterAscii <= zLetterAsci) {

            encryptedLetterAscii
        } else {
            //if shifted char is bigger than 'z' than start encryption from 'a' again
            aLetterAsci + (encryptedLetterAscii - zLetterAsci) - 1
        }.toChar()
    }.joinToString("")
}

private class Test {
    @Test
    fun `"abc" with shift 1 return "bcd"`() {
        encodeCaesarCipher("abc", 1) shouldBeEqualTo "bcd"
    }

    @Test
    fun `"abcdefghijklmnopqrstuvwxyz" shift 1 returns "bcdefghijklmnopqrstuvwxyza"`() {
        encodeCaesarCipher(
            "abcdefghijklmnopqrstuvwxyz",
            1
        ) shouldBeEqualTo "bcdefghijklmnopqrstuvwxyza"
    }

    @Test
    fun `"abcdefghijklmnopqrstuvwxyz" shift 7 returns "hijklmnopqrstuvwxyzabcdefg"`() {
        encodeCaesarCipher(
            "abcdefghijklmnopqrstuvwxyz",
            7
        ) shouldBeEqualTo "hijklmnopqrstuvwxyzabcdefg"
    }

    @Test
    fun `"abcdefghijklmnopqrstuvwxyz" shift 50 returns "yzabcdefghijklmnopqrstuvwx"`() {
        encodeCaesarCipher(
            "abcdefghijklmnopqrstuvwxyz",
            50
        ) shouldBeEqualTo "yzabcdefghijklmnopqrstuvwx"
    }
}
