package com.example.mockkdelayissue

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Assert.*

import org.junit.Test

class ViewModelTestTest {

    @Test
    fun initialize() {

        val dispatcher = TestCoroutineDispatcher()

        val mockk: InterfaceTest = mockk()

        val viewModel = ViewModelTest(mockk, dispatcher)

        viewModel.initializeFailed()

        // ERROR - failed to verify
        coVerify {

            mockk.method()
        }
    }

    @Test
    fun initializeSuccess() {

        val dispatcher = TestCoroutineDispatcher()

        val mockk: InterfaceTest = mockk()

        val viewModel = ViewModelTest(mockk, dispatcher)

        viewModel.initializeSuccess()

        // SUCCESS - verified
        coVerify {

            mockk.method()
        }
    }
}