package com.megathon.smarthome.network

import androidx.lifecycle.MutableLiveData
import com.megathon.smarthome.ui.login.LoginRequest
import com.megathon.smarthome.ui.login.LoginResponseModel

interface ApiRepo {

    fun getLoginDetails(loginRequest: LoginRequest ): MutableLiveData<LoginResponseModel>

}