package com.example.firstkotlinworkflow.validateForm

import androidx.appcompat.app.AppCompatActivity
import com.squareup.workflow1.ui.ViewRegistry
import com.squareup.workflow1.ui.WorkflowUiExperimentalApi

//Fake dagger
@OptIn(WorkflowUiExperimentalApi::class)
class Components(context : AppCompatActivity) {

    val viewRegistry = ViewRegistry(
        ValidateFormLayoutRunner
    )

}