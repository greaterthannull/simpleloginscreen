package com.example.simpleloginscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleloginscreen.services.LoginService

class LoginViewModel : ViewModel() {

    var username: String = ""
    var password: String = ""
    private val _errorMessage: MutableLiveData<String> = MutableLiveData()

    var loginService: LoginService

    val errorMessage: LiveData<String>
    get() = _errorMessage

    init{
        loginService = LoginService()
    }

    fun setErrorMessage(error : String?) {
        _errorMessage.value = error
    }

    fun attemptLogin() {
        val loginResult = loginService.authenticateUser(username, password)
        if(loginResult.success){
            //Put user to next screen
            setErrorMessage(null)
        } else {
            setErrorMessage(loginResult.errorMessage)
        }
    }
}