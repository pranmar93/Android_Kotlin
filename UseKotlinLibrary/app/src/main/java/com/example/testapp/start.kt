package com.example.testapp

import android.util.Log
import com.example.ddflibrary.FileOperation
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException


fun fileWrite(path: String): Boolean{
    val logTAG = MainActivity::class.java.simpleName

    try {
        val wrFolder = "$path/Output"
        val filename1 = "$path/Input/ABC.txt"

        val r = FileOperation.ReadFile
        val data: String? = r.fileRead(filename1)
        return r.fileWrite(wrFolder, "DEF.txt", data!!)

    } catch (ex: FileNotFoundException) {
        Log.d(logTAG, ex.message.toString())
    } catch (ex: IOException) {
        Log.d(logTAG, ex.message.toString())
    } catch (ex: Exception) {
        Log.d(logTAG, ex.message.toString())
    }

    return false
}