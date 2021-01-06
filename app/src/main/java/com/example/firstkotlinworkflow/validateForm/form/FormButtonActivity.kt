package com.example.firstkotlinworkflow.validateForm.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.firstkotlinworkflow.R
import com.example.firstkotlinworkflow.validateForm.Components
import com.example.firstkotlinworkflow.validateForm.ValidateFormViewModel
import com.squareup.workflow1.ui.WorkflowLayout
import com.squareup.workflow1.ui.WorkflowUiExperimentalApi
@OptIn(WorkflowUiExperimentalApi::class)
class FormButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val components = Components(this)
        val model : FormWorkVIewModel by viewModels()

        setContentView(
            WorkflowLayout(this).apply { start(model.renderings, components.viewRegistry) }
        )
    }
}