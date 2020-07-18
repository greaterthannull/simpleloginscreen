package com.example.simpleloginscreen.services

class LoginService {

    fun authenticateUser(username:String, password: String): LoginResult {
        if(username.isEmpty() || password.isEmpty()) {
            return LoginResult(false, "Both fields are required")
        }
        if(password == "incorrect") {
            return LoginResult(false, "Incorrect username or password")
        }

        return LoginResult(true, null)
    }

}
class LoginResult(var success: Boolean, var errorMessage : String?)