package com.example.firstkotlinworkflow

import com.squareup.workflow1.Snapshot
import com.squareup.workflow1.StatefulWorkflow
import com.squareup.workflow1.action

object MainLayoutWorkFlow : StatefulWorkflow<Unit, MainLayoutWorkFlow.State, Nothing, MainScreen >() {
    data class State(
            val firstNumber : Int,
            val secondNumber : Int,
            val sum : Int )

    override fun initialState(props: Unit, snapshot: Snapshot?): State {
        return State(0, 0, 0)
    }

    override fun render(props: Unit, state: State, context: RenderContext): MainScreen {
       return MainScreen(
               firstNumber = state.firstNumber,
               secondNumber = state.secondNumber,
               sum =  state.sum,
               onFirstNumberChanged = { context.actionSink.send(onFirstNumberChanged(it)) },
               onSecondNumberChanged = {context.actionSink.send(onSecondNumberChanged(it))},
               onTapped = {context.actionSink.send(onSum())}
       )
    }

    override fun snapshotState(state: State): Snapshot? {
       return null
    }

    private fun onFirstNumberChanged(firstNumber: Int) = action {
        state = state.withFirstNumber(firstNumber)
    }

    private fun onSecondNumberChanged(secondNumber: Int) = action {
        state = state.withSecondNumber(secondNumber)
    }

    private fun onSum() = action {
        val sum = this.state.secondNumber + this.state.firstNumber
        state = state.copy(sum = sum)
    }

    private fun State.withFirstNumber(firstNumber: Int) = copy(firstNumber = firstNumber)
    private fun State.withSecondNumber(secondNumber : Int) = copy(secondNumber = secondNumber)
}