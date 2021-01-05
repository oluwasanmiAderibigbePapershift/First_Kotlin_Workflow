@file:OptIn(WorkflowUiExperimentalApi::class)

package com.example.firstkotlinworkflow.validateForm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.squareup.workflow1.ui.*


class ValidateFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val components = Components(this)
        val model : ValidateFormViewModel by viewModels()

        setContentView(
            WorkflowLayout(this).apply { start(model.renderings, components.viewRegistry) }
        )
    }
}
