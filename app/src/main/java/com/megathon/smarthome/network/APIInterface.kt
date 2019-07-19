package com.megathon.smarthome.network

import com.megathon.smarthome.ui.login.SignInResponseModel
import com.megathon.smarthome.ui.login.SigninModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIInterface {

//    @FormUrlEncoded
//    @POST("login")
//    Call<SignInResponseModel> signIn(@Field("email") String email, @Field("type") String type, @Field("pass") String pass);

    @POST("login")
    abstract fun signIn(@Body signinModel: SigninModel): Call<SignInResponseModel>


    interface Header {
        companion object {
            val AUTHORIZATION = "Authorization"
            val TIMEZONE = "Timezone"
        }

    }

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