package com.example.firstkotlinworkflow.validateForm

import androidx.annotation.StringRes
import com.example.firstkotlinworkflow.R
import com.example.firstkotlinworkflow.validateAField.emailPattern
import com.squareup.workflow1.Snapshot
import com.squareup.workflow1.StatefulWorkflow
import com.squareup.workflow1.action

object ValidateFormWorkFlow : StatefulWorkflow<Unit, ValidateFormWorkFlow.FormState, Nothing, ValidateFormScreen>() {

    data class FormState(
        val firstName : String,
        @StringRes val firstNameErrorMessageId : Int,
        val lastName : String,
        @StringRes val lastNameErrorMessageId : Int,
        val age : String,
        @StringRes val ageErrorMessageId : Int,
        val email : String,
        @StringRes val emailErrorMessageId : Int,
        val isFormValid : Boolean
    )

    override fun initialState(props: Unit, snapshot: Snapshot?): FormState {
        return FormState("", VALID_FIELD_ID, "", VALID_FIELD_ID, "", VALID_FIELD_ID, "", VALID_FIELD_ID, false)
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
            onFirstNameChanged = {context.actionSink.send(onFirstNameChanged(it))},
            onLastNameChanged = {context.actionSink.send(onLastNameChanged(it))},
            onEmailChanged = {context.actionSink.send(onEmailChanged(it))},
            onAgeChanged = {context.actionSink.send(onAgeChanged(it))},
            onSubmitTapped = {context.actionSink.send(onSubmitTapped())}
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

    //TODO [oa_5-01-2020] This code is wrong. If only the last field is valida, then the entire form would be seen as valid. find a way to fix this.
    //Add a valid state for every field?
    private fun onSubmitTapped() = action {

        state = if(state.firstName.isNotBlank()){
            state.copy(firstNameErrorMessageId =  VALID_FIELD_ID, isFormValid = true)
        }else{
            state.copy(firstNameErrorMessageId = R.string.validate_form_invalid_first_name, isFormValid = false)
        }

        state = if(state.lastName.isNotBlank()){
            state.copy(lastNameErrorMessageId = VALID_FIELD_ID, isFormValid = true)
        }else{
            state.copy(lastNameErrorMessageId = R.string.validate_form_invalid_last_name, isFormValid = false)
        }

        state = if(state.age.isNotBlank() && state.age.toInt() >= MIN_AGE){
            state.copy(ageErrorMessageId = VALID_FIELD_ID, isFormValid = true)
        }else{
            state.copy(ageErrorMessageId = R.string.validate_form_invalid_age, isFormValid = false)
        }

        state = if(state.email.isValidateEmail()){
            state.copy(emailErrorMessageId = VALID_FIELD_ID, isFormValid = true)
        }else{
            state.copy(emailErrorMessageId = R.string.validate_field_invalid_email, isFormValid = false)
        }

//        if(state.isFormValid){
//            //Set an output
//        }
    }


    override fun snapshotState(state: FormState): Snapshot? {
        //How to you persit state.
        return null
    }

    private fun String.isValidateEmail() : Boolean {
        return matches(emailPattern.toRegex())
    }
}
