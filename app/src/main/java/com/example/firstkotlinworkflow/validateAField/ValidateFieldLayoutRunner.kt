package com.example.firstkotlinworkflow.validateAField

import com.example.firstkotlinworkflow.databinding.ActivityValidateFieldBinding
import com.squareup.workflow1.ui.*
import com.squareup.workflow1.ui.LayoutRunner.Companion.bind

@OptIn(WorkflowUiExperimentalApi::class)
class ValidateFieldLayoutRunner(private val binding: ActivityValidateFieldBinding) : LayoutRunner<ValidateFieldScreen> {
    override fun showRendering(rendering: ValidateFieldScreen, viewEnvironment: ViewEnvironment) {
        binding.tlEmail.editText?.updateText(rendering.email)
        binding.tlEmail.editText?.setTextChangedListener { rendering.onEmailChanged(it.toString())}
        binding.tlEmail.error = if (rendering.errorMessage != -1) binding.root.context.getString(rendering.errorMessage) else ""

        binding.btnValidate.setOnClickListener {
            rendering.onValidateTapped()
        }


    }

    companion object : ViewFactory<ValidateFieldScreen> by bind(
        ActivityValidateFieldBinding::inflate, ::ValidateFieldLayoutRunner
    )
}