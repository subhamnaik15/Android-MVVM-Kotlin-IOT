package com.megathon.smarthome.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


class SigninViewmodel(private var apiRepo: LoginRepo) : ViewModel() {
    var loginDetailLiveData: LiveData<LoginResponseModel>? = null

    fun getLoginDetails(email: String, pass: String) : LiveData<LoginResponseModel>{
        loginDetailLiveData = apiRepo.getLoginDetails(email,pass)
        return loginDetailLiveData as LiveData<LoginResponseModel>
    }
}

