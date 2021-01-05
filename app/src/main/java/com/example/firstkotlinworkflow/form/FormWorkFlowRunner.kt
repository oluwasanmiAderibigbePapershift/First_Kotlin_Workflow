package com.example.firstkotlinworkflow.form

import com.example.firstkotlinworkflow.databinding.ActivityFormViewBinding
import com.papershift.design.button.FormButtonState
import com.squareup.workflow1.ui.LayoutRunner
import com.squareup.workflow1.ui.ViewEnvironment
import com.squareup.workflow1.ui.ViewFactory
import com.squareup.workflow1.ui.WorkflowUiExperimentalApi

@OptIn(WorkflowUiExperimentalApi::class)
class FormWorkFlowRunner(private val binding: ActivityFormViewBinding) :
    LayoutRunner<FormButtonState> {


    override fun showRendering(rendering: FormButtonState, viewEnvironment: ViewEnvironment) {
        binding.formButtonWorkFlow.setupWithState(rendering)
    }

    companion object : ViewFactory<FormButtonState> by LayoutRunner.Companion.bind(
        ActivityFormViewBinding::inflate,
        ::FormWorkFlowRunner
    )
}