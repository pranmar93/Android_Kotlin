package com.example.fruitsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.fruitsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting ViewModel instance
        val mainViewModel = ViewModelProviders.of(this)
            .get(MainViewModel::class.java)

        // Setting the view of the .xml file with which data binding is to be done
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).apply {
            this.lifecycleOwner = this@MainActivity
            // same variable name "viewModel" as in the .xml file
            this.viewModel = mainViewModel
        }

        // Attaching an observer to the edit text field, so that whenever is changes, a Toast is shown.
        mainViewModel.editTextContent.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}
