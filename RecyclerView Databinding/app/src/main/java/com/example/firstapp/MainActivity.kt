package com.example.firstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setting the view of the .xml file with which data binding is to be done
        val mainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // setting the layout manager for the Recycler view
        mainBinding.recyclerView.layoutManager = LinearLayoutManager(this)

        // for the size of the recycler view to be fixed
        mainBinding.recyclerView.setHasFixedSize(true)

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
        mainBinding.recyclerView.adapter = adapter
    }

}
