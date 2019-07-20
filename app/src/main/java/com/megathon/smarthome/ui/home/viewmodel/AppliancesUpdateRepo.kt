package com.megathon.smarthome.ui.home.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.megathon.smarthome.network.RetrofitClient
import com.megathon.smarthome.ui.home.model.AppliancesUpdateModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppliancesUpdateRepo {
    fun getAppliancesUpdate(userId: String, houseId: String, roomId: String, applianceId : String, status : Boolean): MutableLiveData<AppliancesUpdateModel> {
        val appliancesUpdateLiveData = MutableLiveData<AppliancesUpdateModel>()

        val call = RetrofitClient.apiClientInstance.service.updateAppliance(userId, houseId,roomId,applianceId,status)
        call.enqueue(object : Callback<AppliancesUpdateModel> {
            override fun onResponse(call: Call<AppliancesUpdateModel>, response: Response<AppliancesUpdateModel>) {
                if (response.isSuccessful) {
                    val appliancesResponse = response.body()!!
                    appliancesUpdateLiveData.value = appliancesResponse
                }
            }
            override fun onFailure(call: Call<AppliancesUpdateModel>, t: Throwable) {
                Log.i("responce", t.message)
            }
        })
        return appliancesUpdateLiveData
    }
}