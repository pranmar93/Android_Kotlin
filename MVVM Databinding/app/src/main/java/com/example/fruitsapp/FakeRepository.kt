package com.example.fruitsapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*


object FakeRepository {

    // demo data list for app
    private val fruitNames: List<String> = listOf(
        "Apple", "Banana", "Orange", "Kiwi", "Grapes", "Fig",
        "Pear", "Strawberry", "Gooseberry", "Raspberry"
    )

    //  mutable live data variable
    private val _currentRandomFruitName = MutableLiveData<String>()

    // expose only the live data, so that it remains immutable
    val currentRandomFruitName: LiveData<String>
        get() = _currentRandomFruitName

    init {
        _currentRandomFruitName.value = fruitNames.first()
    }

    //returns a random fruit string from the list
    fun getRandomFruitName(): String {
        val random = Random()
        return fruitNames[random.nextInt(fruitNames.size)]
    }

    fun changeCurrentRandomFruitName() {
        _currentRandomFruitName.value = getRandomFruitName()
    }
}