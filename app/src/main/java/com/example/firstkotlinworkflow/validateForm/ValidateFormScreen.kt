package com.example.firstkotlinworkflow.validateForm

class ValidateFormScreen(
    val firstName : String,
    val firstNameError : Int,

    val lastName : String,
    val lastNameError : Int,

    val age : String,
    val ageError : Int,

    val email : String,
    val emailError : Int,

    val isFormValid : Boolean = false,

    val onFirstNameChanged : (String) -> Unit,
    val onLastNameChanged : (String) -> Unit,
    val onAgeChanged : (String) -> Unit,
    val onEmailChanged : (String) -> Unit,
    val onSubmitTapped : () -> Unit
)