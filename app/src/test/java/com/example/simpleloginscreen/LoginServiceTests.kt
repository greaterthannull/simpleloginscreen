package com.example.simpleloginscreen

import com.example.simpleloginscreen.services.LoginService
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LoginServiceTests {

    @Test
    fun assert_no_fields_message() {
        val loginService = LoginService()

        val result = loginService.authenticateUser("", "")
        assert(result.errorMessage == "Both fields are required")
        assert(!result.success)
    }

    @Test
    fun asset_incorrect_password_message() {
        val loginService = LoginService()

        val result = loginService.authenticateUser("GTN", "incorrect")
        assert(result.errorMessage == "Incorrect username or password")
        assert(!result.success)
    }

    @Test
    fun asset_correct_password_message() {
        val loginService = LoginService()

        val result = loginService.authenticateUser("GTN", "correct")
        assert(result.errorMessage == null)
        assert(result.success)
    }
}