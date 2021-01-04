package com.example.firstkotlinworkflow.validateAField

import com.squareup.workflow1.Snapshot
import com.squareup.workflow1.StatefulWorkflow
import com.squareup.workflow1.action

const val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

object ValidateFieldWorkFlow : StatefulWorkflow<Unit, ValidateFieldWorkFlow.FormState, Nothing, ValidateFieldScreen >() {

    data class FormState(
        val email : String,
        val errorMessage : String
    )


    override fun initialState(props: Unit, snapshot: Snapshot?): FormState {
        return FormState("", "")
    }

    override fun render(
        props: Unit,
        state: FormState,
        context: RenderContext
    ): ValidateFieldScreen {
        return ValidateFieldScreen(
            state.email,
            state.errorMessage,
            onEmailChanged = {
                context.actionSink.send(onEmailChanged(it))
            },
            onValidateTapped = {
                context.actionSink.send(onValidateTapped())

            }
        )
    }

    override fun snapshotState(state: FormState): Snapshot? {
        return null
    }

    private fun onEmailChanged(email : String) = action {
        state = state.copy(email = email)
    }

    private fun onValidateTapped() = action {
        state = if(state.email.isValidateEmail()){
            state.copy(errorMessage = "")
        }else{
            state.copy(errorMessage =  "Email not valid")
        }
    }

    private fun String.isValidateEmail() : Boolean {
       return matches(emailPattern.toRegex())
    }
}