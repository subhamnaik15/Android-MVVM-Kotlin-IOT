package com.megathon.smarthome.ui.login

import com.google.gson.annotations.SerializedName

class LoginResponseModel {

    @SerializedName("errorStatus")
    var errorStatus: String? = null
    @SerializedName("errorCode")
    var errorCode: String? = null
}
