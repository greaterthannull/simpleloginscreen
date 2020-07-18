package com.example.simpleloginscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simpleloginscreen.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var viewmodel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        viewmodel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.viewmodel = this.viewmodel

        viewmodel.errorMessage.observe(this, Observer { error ->
            binding.loginErrormessage.apply {
                text = error
                visibility = if(error==null) View.INVISIBLE else View.VISIBLE
            }})
    }

}