package com.example.firstkotlinworkflow.validateAField

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstkotlinworkflow.R
import com.example.firstkotlinworkflow.addTwoNumbers.MainLayoutRunner
import com.example.firstkotlinworkflow.addTwoNumbers.MainLayoutWorkFlow
import com.squareup.workflow1.SimpleLoggingWorkflowInterceptor
import com.squareup.workflow1.ui.ViewRegistry
import com.squareup.workflow1.ui.WorkflowRunner
import com.squareup.workflow1.ui.WorkflowUiExperimentalApi
import com.squareup.workflow1.ui.setContentWorkflow

@OptIn(WorkflowUiExperimentalApi::class)
private val viewRegistry = ViewRegistry(
    ValidateFieldLayoutRunner
)
@WorkflowUiExperimentalApi
class ValidateFieldActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validate_field)


        setContentWorkflow(viewRegistry) {
            WorkflowRunner.Config(ValidateFieldWorkFlow,  Unit, interceptors = listOf(
                SimpleLoggingWorkflowInterceptor()
            ))

        }
    }
}