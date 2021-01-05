@file:OptIn(WorkflowUiExperimentalApi::class)

package com.example.firstkotlinworkflow.validateForm

import com.squareup.workflow1.ui.WorkflowUiExperimentalApi
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstkotlinworkflow.R
import com.squareup.workflow1.ui.ViewRegistry
import com.squareup.workflow1.ui.WorkflowRunner
import com.squareup.workflow1.ui.setContentWorkflow


@OptIn(WorkflowUiExperimentalApi::class)
private val viewRegistry = ViewRegistry(
    ValidateFormLayoutRunner
)

class ValidateFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validate_form)

        setContentWorkflow(viewRegistry){
            WorkflowRunner.Config(ValidateFormWorkFlow, Unit)
        }
    }
}