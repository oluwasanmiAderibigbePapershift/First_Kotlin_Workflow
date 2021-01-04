package com.example.firstkotlinworkflow.validateAField

class ValidateFieldScreen(
    val email : String,
    val errorMessage : Int = VALID_EMAIL_ID,

    val onValidateTapped : () -> Unit,
    val onEmailChanged : (String) -> Unit
)