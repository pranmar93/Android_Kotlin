package com.example.tictactoe.models

import com.example.tictactoe.utilities.StringUtility

class Cell(var player: Player?) {

    val isEmpty: Boolean
        get() = player == null || StringUtility.isNullOrEmpty(player!!.value)
}