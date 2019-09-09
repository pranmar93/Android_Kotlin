package com.example.testapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import java.io.File


class MainActivity : AppCompatActivity() {

    private val requestCodeWriteExternalStoragePermission = 1

    private var functionCalling: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check whether this app has write external storage permission or not.
        val writeExternalStoragePermission = checkSelfPermission(this@MainActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE)

        // If do not grant write external storage permission.
        if (writeExternalStoragePermission != PackageManager.PERMISSION_GRANTED) {
            // Request user to grant write external storage permission.
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), requestCodeWriteExternalStoragePermission)
        }

        functionCalling = findViewById<View>(R.id.button1) as Button

        functionCalling!!.setOnClickListener { functionCallingExample() }
    }

    private fun functionCallingExample() {
        val folderName = File("/storage/emulated/0/TestApp")

        if (!folderName.exists()) {
            folderName.mkdirs()
        }

        fileWrite(folderName.toString())
        // function body
        Toast.makeText(this@MainActivity, "File written Successfully", Toast.LENGTH_SHORT).show()

    }
}
