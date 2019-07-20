package com.megathon.smarthome.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.megathon.smarthome.ui.home.model.AppliancesUpdateModel

class HomeViewModel(private var apiRepo: AppliancesUpdateRepo) : ViewModel() {
    var appliancesUpdateLiveData: LiveData<AppliancesUpdateModel>? = null

    fun getAppliancesUpdate(userId: String, houseId: String, roomId: String, applianceId : String, status : Boolean) : LiveData<AppliancesUpdateModel> {
        appliancesUpdateLiveData = apiRepo.getAppliancesUpdate(userId,houseId,roomId,applianceId,status)
        return appliancesUpdateLiveData as LiveData<AppliancesUpdateModel>
    }
}