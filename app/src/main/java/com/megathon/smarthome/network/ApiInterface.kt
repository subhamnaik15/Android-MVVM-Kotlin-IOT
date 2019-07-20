package com.megathon.smarthome.network

import com.megathon.smarthome.ui.login.LoginResponseModel
import com.megathon.smarthome.ui.login.LoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

//    @FormUrlEncoded
//    @POST("login")
//    Call<LoginResponseModel> signIn(@Field("email") String email, @Field("type") String type, @Field("pass") String pass);

    @POST("login")
    fun signIn(@Body signinModel: LoginRequest): Call<LoginResponseModel>


//    interface Header {
//        companion object {
//            val AUTHORIZATION = "Authorization"
//            val TIMEZONE = "Timezone"
//        }
//
//    }

//    @Multipart
//    @POST("patients/register")
//    Call<Response> register(@Part MultipartBody.Part file, @PartMap() Map<String, RequestBody> partMap);


//    @GET("configurations")
//    Call<Configuration> downloadConfiguration();

//    @FormUrlEncoded
//    @POST("patients/get-otp")
//    Call<Response> requestOTP(@Field("uid") String mobileNo);

//    @POST
//    Call<Response> saveMedicineTrackerInfo(@Url String url, @Body SaveMedicineReadingRequestModel medicine);

}