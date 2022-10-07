package com.example.randomuserapp.presentation.login.components

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.randomuserapp.domain.use_cases.validation.ValidateEmailUseCase
import com.example.randomuserapp.domain.use_cases.validation.ValidatePasswordUseCase
import com.example.randomuserapp.presentation.login.LoginViewModel
import com.example.randomuserapp.presentation.ui.theme.RandomUserAppTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runners.MethodSorters

@ExperimentalComposeUiApi

@HiltAndroidTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class LoginScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var validateEmail: ValidateEmailUseCase
    private lateinit var validatePassword: ValidatePasswordUseCase
    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setup() {
        hiltRule.inject()
        validateEmail = ValidateEmailUseCase()
        validatePassword = ValidatePasswordUseCase()
        loginViewModel = LoginViewModel(validateEmail, validatePassword)
        composeTestRule.setContent {
            RandomUserAppTheme {
                LoginScreen(navToUsers = { }, viewModel = loginViewModel)
            }
        }
    }

    @Test
    fun testLoginTitleIsDisplayed() {
        val titleNode = composeTestRule.onNode(hasTestTag("Title_Login"), useUnmergedTree = true)
            titleNode.assertIsDisplayed()
    }

    @Test
    fun testEmailInput() {
        val emailNode = composeTestRule.onNodeWithText("Email")
        emailNode.performTextInput("")
        emailNode.assertTextEquals("Email", "")
    }

    @Test
    fun testPasswordInput() {
        val passwordNode = composeTestRule.onNodeWithText("Password")
        passwordNode.performTextInput("")
        passwordNode.assertTextEquals("Password", "")
    }

    @Test
    fun testLoginButton() {
        val buttonNode = composeTestRule.onNode(hasTestTag("LoginButton"), useUnmergedTree = true)
        buttonNode.assertIsDisplayed()
        buttonNode.performClick()
    }
}