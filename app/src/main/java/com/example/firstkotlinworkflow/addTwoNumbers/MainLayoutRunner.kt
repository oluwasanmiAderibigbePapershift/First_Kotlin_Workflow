package com.example.firstkotlinworkflow.addTwoNumbers

import com.example.firstkotlinworkflow.databinding.ActivityMainBinding
import com.squareup.workflow1.ui.*
import com.squareup.workflow1.ui.LayoutRunner.Companion.bind

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