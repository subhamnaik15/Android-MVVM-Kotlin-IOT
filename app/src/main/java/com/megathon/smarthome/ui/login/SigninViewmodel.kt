package com.megathon.smarthome.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


class SigninViewmodel(private var apiRepo: LoginRepo) : ViewModel() {
    var loginDetailLiveData: LiveData<LoginResponseModel>? = null

    fun getLoginDetails(email: String, type: String, pass: String) : LiveData<LoginResponseModel>{
        val signinModel = LoginRequest()
        signinModel.email = email
        signinModel.password = pass
        signinModel.type = type
        loginDetailLiveData = apiRepo.getLoginDetails(signinModel)
        return loginDetailLiveData as LiveData<LoginResponseModel>
    }
}

