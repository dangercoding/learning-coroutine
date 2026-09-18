package com.learning.coroutine_learning.baseCoroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun basicCoroutine(){

    println("Before")

    CoroutineScope(Dispatchers.IO).launch {

        println("Inside coroutine")

        delay(2000)

        println("After delay")
    }

    println("After")

}