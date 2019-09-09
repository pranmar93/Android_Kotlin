package com.example.tictactoe.views

import android.os.Bundle
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.tictactoe.R
import com.example.tictactoe.models.Player
import com.example.tictactoe.utilities.StringUtility.isNullOrEmpty
import com.example.tictactoe.viewmodels.GameViewModel
import com.example.tictactoe.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private var gameViewModel: GameViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        promptForPlayers()
    }

    fun promptForPlayers() {
        val dialog: GameBeginDialog? = GameBeginDialog.newInstance(this)
        dialog?.isCancelable = false
        dialog?.show(supportFragmentManager, GAME_BEGIN_DIALOG_TAG)
    }

    fun onPlayersSet(player1: String, player2: String) {
        initDataBinding(player1, player2)
    }

    private fun initDataBinding(player1: String, player2: String) {
        val activityGameBinding: ActivityGameBinding = DataBindingUtil.setContentView(this, R.layout.activity_game)
        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        gameViewModel!!.init(player1, player2)
        activityGameBinding.gameViewModel = gameViewModel
        setUpOnGameEndListener()
    }

    private fun setUpOnGameEndListener() {
        gameViewModel!!.getWinner().observe(this, Observer<Player?> { winner -> onGameWinnerChanged(winner) })
    }

    @VisibleForTesting
    fun onGameWinnerChanged(winner: Player?) {
        val winnerName = if (winner == null || isNullOrEmpty(winner.name)) NO_WINNER else winner.name
        val dialog = GameEndDialog.newInstance(this, winnerName)
        dialog.isCancelable = false
        dialog.show(supportFragmentManager, GAME_END_DIALOG_TAG)
    }

    companion object {
        private const val GAME_BEGIN_DIALOG_TAG = "game_dialog_tag"
        private const val GAME_END_DIALOG_TAG = "game_end_dialog_tag"
        private const val NO_WINNER = "No one"
    }
}