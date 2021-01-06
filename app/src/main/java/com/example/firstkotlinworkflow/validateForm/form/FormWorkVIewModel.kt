package com.example.firstkotlinworkflow.validateForm.form

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstkotlinworkflow.validateForm.ValidateFormWorkFlow
import com.squareup.workflow1.ui.WorkflowUiExperimentalApi
import com.squareup.workflow1.ui.renderWorkflowIn
import kotlinx.coroutines.flow.StateFlow

@OptIn(WorkflowUiExperimentalApi::class)
class FormWorkVIewModel(savedState: SavedStateHandle) : ViewModel() {

    val renderings: StateFlow<Any> by lazy {
        renderWorkflowIn(
            workflow = FormWorkFlow,
            prop = Unit,
            scope = viewModelScope,
            savedStateHandle = savedState
        )
    }
}

