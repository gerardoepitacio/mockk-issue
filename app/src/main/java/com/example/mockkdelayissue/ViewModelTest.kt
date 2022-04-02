package com.example.mockkdelayissue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


interface InterfaceTest {

    fun method()
}

class ViewModelTest(
    private val interfaceTest: InterfaceTest,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
    ): ViewModel() {

    companion object {

        const val DELAY_TIME = 1000L
    }

    fun initializeFailed() {

        this.viewModelScope.launch(this.dispatcher) {

            delay(DELAY_TIME)

            interfaceTest.method()
        }
    }

    fun initializeSuccess() {

        this.viewModelScope.launch(this.dispatcher) {

            interfaceTest.method()
        }
    }

}