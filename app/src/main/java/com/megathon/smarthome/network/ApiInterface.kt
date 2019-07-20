package com.megathon.smarthome.network

import com.megathon.smarthome.ui.home.model.AppliancesUpdateModel
import com.megathon.smarthome.ui.login.LoginResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @GET("login")
    fun signIn(@Header ("username") username: String, @Header ("password") password: String): Call<LoginResponseModel>

     @POST("updateAppliance")
    fun updateAppliance(@Header ("userId") userId: String, @Header ("houseId") houseId: String,
                        @Header ("roomId") roomId: String, @Header ("applianceId") applianceId: String,
                        @Header ("status") status: Boolean
     ): Call<AppliancesUpdateModel>
}