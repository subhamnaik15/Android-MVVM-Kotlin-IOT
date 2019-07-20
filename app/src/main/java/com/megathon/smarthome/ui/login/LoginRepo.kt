package com.megathon.smarthome.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.megathon.smarthome.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepo {
     fun getLoginDetails(email: String, password: String): MutableLiveData<LoginResponseModel> {
        val loginResponseLiveData = MutableLiveData<LoginResponseModel>()

        val call = RetrofitClient.apiClientInstance.service.signIn(email, password)
        call.enqueue(object : Callback<LoginResponseModel> {
            override fun onResponse(call: Call<LoginResponseModel>, response: Response<LoginResponseModel>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()!!
                    loginResponseLiveData.value = loginResponse
                }
            }
            override fun onFailure(call: Call<LoginResponseModel>, t: Throwable) {
                Log.i("responce", t.message)
             }
        })
        return loginResponseLiveData
    }
}