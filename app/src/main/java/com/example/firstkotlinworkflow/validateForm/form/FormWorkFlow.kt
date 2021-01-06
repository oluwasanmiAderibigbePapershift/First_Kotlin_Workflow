package com.example.firstkotlinworkflow.validateForm.form

import com.papershift.design.button.FormButtonState
import com.squareup.workflow1.Snapshot
import com.squareup.workflow1.StatefulWorkflow
import com.squareup.workflow1.action

object FormWorkFlow : StatefulWorkflow<Unit,FormWorkFlow.FormWorkFLowState , Nothing, FormButtonState>() {

    data class FormWorkFLowState(val title : String, val style : FormButtonState.ButtonStyle)

    override fun initialState(props: Unit, snapshot: Snapshot?): FormWorkFLowState {
        return FormWorkFLowState(
            title = "Save",
            style = FormButtonState.ButtonStyle.FILLED,
        )
    }

    override fun render(
        props: Unit,
        state: FormWorkFLowState,
        context: RenderContext
    ): FormButtonState {
       return FormButtonState(
           title = state.title,
           style = state.style,
           onClick = {context.actionSink.send(onFormButtonClicked())}
       )
    }

    override fun snapshotState(state: FormWorkFLowState): Snapshot? {
        return null
    }

    private fun onFormButtonClicked() = action {
        state = when(state.style){
            FormButtonState.ButtonStyle.FILLED -> {
                state.copy(style = FormButtonState.ButtonStyle.OUTLINED)
            }
            FormButtonState.ButtonStyle.OUTLINED -> {
                state.copy(style = FormButtonState.ButtonStyle.FILLED)
            }
        }
    }
}