package com.example.tictactoe.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.databinding.ObservableArrayMap

import com.example.tictactoe.models.Cell
import com.example.tictactoe.models.Game
import com.example.tictactoe.models.Player
import com.example.tictactoe.utilities.StringUtility.stringFromNumbers

class GameViewModel: ViewModel() {

    private var game: Game? = null
    var cells: ObservableArrayMap<String, String>? = null

    fun init(player1: String, player2: String) {
        game = Game(player1, player2)
        cells = ObservableArrayMap()
    }

    fun onClickedCellAt(row: Int, column: Int) {
        if (game?.cells?.get(row)?.get(column) == null) {
            game?.cells?.get(row)?.set(column, Cell(game!!.currentPlayer))
            cells?.put(stringFromNumbers(row, column), game?.currentPlayer?.value)
            if (game?.hasGameEnded()!!)
                game!!.reset()
            else
                game!!.switchPlayer()
        }
    }

        fun getWinner(): LiveData<Player> {
            return game?.winner!!
        }
}