package com.example.rv_without_binding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.User
import com.example.firstapp.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setting the layout manager for the Recycler view
        recyclerView.layoutManager = LinearLayoutManager(this)

        // for the size of the recycler view to be fixed
        recyclerView.setHasFixedSize(true)

        // creating a demo list
        val users = ArrayList<User>()
        users.add(User("Belal Khan", "Ranchi Jharkhand"))
        users.add(User("Ramiz Khan", "Ranchi Jharkhand"))
        users.add(User("Faiz Khan", "Ranchi Jharkhand"))
        users.add(User("Yashar Khan", "Ranchi Jharkhand"))
        users.add(User("Belal Khan1", "Ranchi Jharkhand1"))
        users.add(User("Ramiz Khan1", "Ranchi Jharkhand1"))
        users.add(User("Faiz Khan1", "Ranchi Jharkhand1"))
        users.add(User("Yashar Khan1", "Ranchi Jharkhand1"))
        users.add(User("Belal Khan2", "Ranchi Jharkhand2"))
        users.add(User("Ramiz Khan2", "Ranchi Jharkhand2"))
        users.add(User("Faiz Khan2", "Ranchi Jharkhand2"))
        users.add(User("Yashar Khan2", "Ranchi Jharkhand2"))
        users.add(User("Belal Khan3", "Ranchi Jharkhand3"))
        users.add(User("Ramiz Khan3", "Ranchi Jharkhand3"))
        users.add(User("Faiz Khan3", "Ranchi Jharkhand3"))
        users.add(User("Yashar Khan3", "Ranchi Jharkhand3"))

        // initializing the adapter
        val adapter = UserAdapter(users)

        //setting the adapter
        recyclerView.adapter = adapter
    }

}
