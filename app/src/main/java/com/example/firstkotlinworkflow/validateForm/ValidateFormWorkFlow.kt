package com.example.firstkotlinworkflow.validateForm

import androidx.annotation.StringRes
import com.example.firstkotlinworkflow.R
import com.example.firstkotlinworkflow.validateAField.emailPattern
import com.squareup.workflow1.Snapshot
import com.squareup.workflow1.StatefulWorkflow
import com.squareup.workflow1.action

object ValidateFormWorkFlow : StatefulWorkflow<Unit, ValidateFormWorkFlow.FormState, Nothing, ValidateFormScreen>() {

    data class FormState(
            val firstName: String,
            @StringRes val firstNameErrorMessageId: Int,
            val isFirstNameValid: Boolean,
            val lastName: String,
            @StringRes val lastNameErrorMessageId: Int,
            val isLastNameValid: Boolean,
            val age: String,
            @StringRes val ageErrorMessageId: Int,
            val isAgeValid: Boolean,
            val email: String,
            @StringRes val emailErrorMessageId: Int,
            val isEmailValid: Boolean,
            val isFormValid: Boolean
    )

    override fun initialState(props: Unit, snapshot: Snapshot?): FormState {
        return FormState(firstName = "",
                firstNameErrorMessageId = VALID_FIELD_RESOURCE_ID,
                isFirstNameValid = false,
                lastName = "",
                lastNameErrorMessageId = VALID_FIELD_RESOURCE_ID,
                isLastNameValid = false, age = "",
                ageErrorMessageId = VALID_FIELD_RESOURCE_ID,
                isAgeValid = false, email = "",
                emailErrorMessageId = VALID_FIELD_RESOURCE_ID,
                isEmailValid = false,
                isFormValid = false)
    }

    override fun render(props: Unit, state: FormState, context: RenderContext): ValidateFormScreen {

        return ValidateFormScreen(
                state.firstName,
                state.firstNameErrorMessageId,
                state.lastName,
                state.lastNameErrorMessageId,
                state.age,
                state.ageErrorMessageId,
                state.email,
                state.emailErrorMessageId,
                state.isFormValid,
                onFirstNameChanged = { context.actionSink.send(onFirstNameChanged(it)) },
                onLastNameChanged = { context.actionSink.send(onLastNameChanged(it)) },
                onEmailChanged = { context.actionSink.send(onEmailChanged(it)) },
                onAgeChanged = { context.actionSink.send(onAgeChanged(it)) },
                onSubmitTapped = { context.actionSink.send(onSubmitTapped()) }
        )
    }

    private fun onFirstNameChanged(firstName: String) = action {
        state = state.copy(firstName = firstName)
    }

    private fun onAgeChanged(age: String) = action {
        state = state.copy(age = age)
    }

    private fun onEmailChanged(email: String) = action {
        state = state.copy(email = email)
    }

    private fun onLastNameChanged(lastName: String) = action {
        state = state.copy(lastName = lastName)
    }

    private fun onSubmitTapped() = action {

        state = if (state.firstName.isNotBlank()) {
            state.copy(firstNameErrorMessageId = VALID_FIELD_RESOURCE_ID, isFirstNameValid = true)
        } else {
            state.copy(firstNameErrorMessageId = R.string.validate_form_invalid_first_name, isFirstNameValid = false)
        }

        state = if (state.lastName.isNotBlank()) {
            state.copy(lastNameErrorMessageId = VALID_FIELD_RESOURCE_ID, isLastNameValid = true)
        } else {
            state.copy(lastNameErrorMessageId = R.string.validate_form_invalid_last_name, isLastNameValid = false)
        }

        state = if (state.age.isNotBlank() && state.age.toInt() >= MIN_AGE) {
            state.copy(ageErrorMessageId = VALID_FIELD_RESOURCE_ID, isAgeValid = true)
        } else {
            state.copy(ageErrorMessageId = R.string.validate_form_invalid_age, isAgeValid = false)
        }

        state = if (state.email.isValidateEmail()) {
            state.copy(emailErrorMessageId = VALID_FIELD_RESOURCE_ID, isEmailValid = true)
        } else {
            state.copy(emailErrorMessageId = R.string.validate_field_invalid_email, isEmailValid = false)
        }

       with(state){
           if(isFirstNameValid.and(isLastNameValid).and(isAgeValid).and(isEmailValid)){
               state = state.copy(isFormValid = true)
           }
       }
    }


    override fun snapshotState(state: FormState): Snapshot? {
        //How to you persit state.
        return null
    }

    private fun String.isValidateEmail(): Boolean {
        return matches(emailPattern.toRegex())
    }
}
