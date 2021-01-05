package com.example.firstkotlinworkflow.validateForm

import com.example.firstkotlinworkflow.databinding.ActivityValidateFormBinding
import com.squareup.workflow1.ui.*
import com.squareup.workflow1.ui.LayoutRunner.Companion.bind

@OptIn(WorkflowUiExperimentalApi::class)
class ValidateFormLayoutRunner(private val binding: ActivityValidateFormBinding) : LayoutRunner<ValidateFormScreen> {
    override fun showRendering(rendering: ValidateFormScreen, viewEnvironment: ViewEnvironment) {

        binding.tlFirstName.editText?.updateText(rendering.firstName)
        binding.tlFirstName.editText?.setTextChangedListener { rendering.onFirstNameChanged(it.toString()) }
        binding.tlFirstName.error = if (rendering.firstNameError != VALID_FIELD_RESOURCE_ID) binding.root.context.getString(rendering.firstNameError) else ""

        binding.tlLastName.editText?.updateText(rendering.lastName)
        binding.tlLastName.editText?.setTextChangedListener { rendering.onLastNameChanged(it.toString())}
        binding.tlLastName.error = if (rendering.lastNameError != VALID_FIELD_RESOURCE_ID) binding.root.context.getString(rendering.lastNameError) else ""

        binding.tlAge.editText?.updateText(rendering.age)
        binding.tlAge.editText?.setTextChangedListener { rendering.onAgeChanged(it.toString())}
        binding.tlAge.error = if (rendering.ageError!= VALID_FIELD_RESOURCE_ID) binding.root.context.getString(rendering.ageError) else ""

        binding.tlEmail.editText?.updateText(rendering.email)
        binding.tlEmail.editText?.setTextChangedListener { rendering.onEmailChanged(it.toString()) }
        binding.tlEmail.error = if (rendering.emailError != VALID_FIELD_RESOURCE_ID) binding.root.context.getString(rendering.emailError) else ""

        binding.txtFormValidState.text = rendering.isFormValid.toString()

        binding.button2.setOnClickListener {
            rendering.onSubmitTapped()
        }
    }

    companion object : ViewFactory<ValidateFormScreen> by bind(
        ActivityValidateFormBinding::inflate, ::ValidateFormLayoutRunner
    )

}

