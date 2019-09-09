package com.example.firstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val mainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainBinding.recyclerView.layoutManager = LinearLayoutManager(this)

        mainBinding.recyclerView.setHasFixedSize(true)

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

        val adapter = UserAdapter(users)

        mainBinding.recyclerView.adapter = adapter
    }

}
