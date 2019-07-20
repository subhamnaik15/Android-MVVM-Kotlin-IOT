package com.megathon.smarthome.ui.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponseModel {

    @SerializedName("_id")
    @Expose
    private val id: String? = null
    @SerializedName("username")
    @Expose
    private val username: String? = null
    @SerializedName("password")
    @Expose
    private val password: String? = null

    @SerializedName("Error")
    @Expose
    private val error: String? = null

}
