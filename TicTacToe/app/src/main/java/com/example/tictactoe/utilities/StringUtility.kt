package com.example.tictactoe.utilities

object StringUtility {

    fun stringFromNumbers(vararg numbers: Int): String {
        val sNumbers = StringBuilder()
        for (number in numbers)
            sNumbers.append(number)
        return sNumbers.toString()
    }

    fun isNullOrEmpty(value: String?): Boolean {
        return value == null || value.isEmpty()
    }
}