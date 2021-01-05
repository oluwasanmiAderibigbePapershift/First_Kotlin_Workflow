package com.example.firstkotlinworkflow.validateForm

typealias StringResourceId = Int

class ValidateFormScreen(
    val firstName : String,
    val firstNameError : StringResourceId,

    val lastName : String,
    val lastNameError : StringResourceId,

    val age : String,
    val ageError : StringResourceId,

    val email : String,
    val emailError : StringResourceId,

    val isFormValid : Boolean = false,

    val onFirstNameChanged : (String) -> Unit,
    val onLastNameChanged : (String) -> Unit,
    val onAgeChanged : (String) -> Unit,
    val onEmailChanged : (String) -> Unit,
    val onSubmitTapped : () -> Unit
)