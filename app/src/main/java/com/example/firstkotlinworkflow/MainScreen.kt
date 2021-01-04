package com.example.firstkotlinworkflow

data class MainScreen(
    val firstNumber: Int,
    val secondNumber : Int,
    val sum : Int,
    val onTapped : () -> Unit,

    val onFirstNumberChanged : (Int) -> Unit,
    val onSecondNumberChanged : (Int) -> Unit
)
