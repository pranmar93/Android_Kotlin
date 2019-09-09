package com.example.tictactoe.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.tictactoe.utilities.StringUtility.isNullOrEmpty

class Game(playerOne: String, playerTwo: String) {

    private var player1: Player? = null
    private var player2: Player? = null

    var currentPlayer = player1
    var cells: Array<Array<Cell?>>? = null

    var winner = MutableLiveData<Player>()

    private val isBoardFull: Boolean
        get() {
            for (row in cells!!)
                for (cell in row)
                    if (cell == null || cell.isEmpty)
                        return false
            return true
        }

    init {
        cells =  Array(BOARD_SIZE) { arrayOfNulls<Cell?>(BOARD_SIZE) }
        player1 = Player(playerOne, "x")
        player2 = Player(playerTwo, "o")
        currentPlayer = player1
    }

    fun hasGameEnded(): Boolean {
        if (hasThreeSameHorizontalCells() || hasThreeSameVerticalCells() || hasThreeSameDiagonalCells()) {
            winner.value = currentPlayer
            return true
        }

        if (isBoardFull) {
            winner.value = null
            return true
        }

        return false
    }

    private fun hasThreeSameHorizontalCells(): Boolean {
        try {
            for (i in 0 until BOARD_SIZE)
                if (areEqual(cells!![i][0], cells!![i][1], cells!![i][2]))
                    return true

            return false
        } catch (e: NullPointerException) {
            Log.e(TAG, e.message!!)
            return false
        }

    }

    private fun hasThreeSameVerticalCells(): Boolean {
        try {
            for (i in 0 until BOARD_SIZE)
                if (areEqual(cells!![0][i], cells!![1][i], cells!![2][i]))
                    return true
            return false
        } catch (e: NullPointerException) {
            Log.e(TAG, e.message!!)
            return false
        }

    }

    private fun hasThreeSameDiagonalCells(): Boolean {
        return try {
            areEqual(cells!![0][0], cells!![1][1], cells!![2][2]) || areEqual(
                cells!![0][2],
                cells!![1][1],
                cells!![2][0]
            )
        } catch (e: NullPointerException) {
            Log.e(TAG, e.message!!)
            false
        }
    }

    private fun areEqual(vararg cells: Cell?): Boolean {
        if (cells.isEmpty())
            return false

        for (cell in cells)
            if (cell == null || isNullOrEmpty(cell.player!!.value))
                return false

        val comparisonBase = cells[0]
        for (i in 1 until cells.size)
            if (comparisonBase?.player!!.value != cells[i]?.player!!.value)
                return false

        return true
    }

    fun switchPlayer() {
        currentPlayer = if (currentPlayer === player1) player2 else player1
    }

    fun reset() {
        player1 = null
        player2 = null
        currentPlayer = null
        cells = null
    }

    companion object {
        private val TAG = Game::class.java.simpleName
        private const val BOARD_SIZE = 3
    }
}