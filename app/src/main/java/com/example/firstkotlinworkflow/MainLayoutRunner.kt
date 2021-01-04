package com.example.firstkotlinworkflow

import com.example.firstkotlinworkflow.databinding.ActivityMainBinding
import com.squareup.workflow1.ui.LayoutRunner
import com.squareup.workflow1.ui.LayoutRunner.Companion.bind
import com.squareup.workflow1.ui.ViewEnvironment
import com.squareup.workflow1.ui.ViewFactory
import com.squareup.workflow1.ui.WorkflowUiExperimentalApi
import com.squareup.workflow1.ui.setTextChangedListener
import com.squareup.workflow1.ui.updateText

@OptIn(WorkflowUiExperimentalApi::class)
class MainLayoutRunner(private val mainBinding: ActivityMainBinding) : LayoutRunner<MainScreen>{
    override fun showRendering(rendering: MainScreen, viewEnvironment: ViewEnvironment) {
        mainBinding.tlNum1.editText?.updateText(rendering.firstNumber.toString())
        mainBinding.tlNum1.editText?.setTextChangedListener {
            rendering.onFirstNumberChanged(it.toString().toInt())
        }

        mainBinding.tlNum2.editText?.updateText(rendering.secondNumber.toString())
        mainBinding.tlNum2.editText?.setTextChangedListener {
            rendering.onSecondNumberChanged(it.toString().toInt())
        }

        mainBinding.button.setOnClickListener {
            rendering.onTapped()
        }

        mainBinding.txtSum.text = rendering.sum.toString()
    }

    companion object : ViewFactory<MainScreen>by bind(
            ActivityMainBinding::inflate, ::MainLayoutRunner
    )
}