package com.example.tictactoe.views

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.tictactoe.R
import kotlin.system.exitProcess


class GameEndDialog: DialogFragment() {

    private var rootView: View? = null
    private var activity: GameActivity? = null
    private var winnerName: String? = null


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        rootView = initViews()
        val alertDialog: AlertDialog? = AlertDialog.Builder(this.context!!).setView(rootView).setTitle("Game Ended").setPositiveButton(R.string.done) { _, _ -> onNewGame()}.create()
        alertDialog?.setCanceledOnTouchOutside(false)
        alertDialog?.setCancelable(false)
        return alertDialog!!
    }

    private fun initViews(): View? {
        val rootView = LayoutInflater.from(context).inflate(R.layout.game_end_dialog, null, false)
        (rootView.findViewById<TextView>(R.id.tv_winner)).text = winnerName
        return rootView
    }

    private fun onNewGame() {
        dismiss()
        val alertDialog: AlertDialog? = AlertDialog.Builder(this.context!!)
            .setTitle("Wanna Play")
            .setPositiveButton("Yes") { _, _ -> activity?.promptForPlayers()}
            .setNegativeButton("No") { _, _ -> appExit()}
            .create()
        alertDialog?.setCanceledOnTouchOutside(false)
        alertDialog?.setCancelable(false)
        alertDialog?.show()
//        activity?.promptForPlayers()
    }

    private fun appExit() {
        super.getActivity()?.moveTaskToBack(true)
        android.os.Process.killProcess(android.os.Process.myPid())
        exitProcess(1)
    }

    companion object {
        fun newInstance(activity: GameActivity, winnerName: String): GameEndDialog {
            val dialog: GameEndDialog? = GameEndDialog()
            dialog?.activity = activity
            dialog?.winnerName = winnerName
            return dialog!!
        }
    }
}