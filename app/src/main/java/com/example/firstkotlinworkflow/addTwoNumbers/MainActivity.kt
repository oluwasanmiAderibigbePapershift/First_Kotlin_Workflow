package com.example.firstkotlinworkflow.addTwoNumbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstkotlinworkflow.R
import com.squareup.workflow1.ui.ViewRegistry
import com.squareup.workflow1.ui.WorkflowRunner
import com.squareup.workflow1.ui.WorkflowUiExperimentalApi
import com.squareup.workflow1.ui.setContentWorkflow

@OptIn(WorkflowUiExperimentalApi::class)
private val viewRegistry = ViewRegistry(
        MainLayoutRunner
)
@OptIn(WorkflowUiExperimentalApi::class)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setContentWorkflow(viewRegistry) {
            WorkflowRunner.Config(MainLayoutWorkFlow,  Unit)
        }
    }
}