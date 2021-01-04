package com.example.firstkotlinworkflow.validateAField

class ValidateFieldScreen(
    val email : String,
    val errorMessage : String = "",

    val onValidateTapped : () -> Unit,
    val onEmailChanged : (String) -> Unit
)