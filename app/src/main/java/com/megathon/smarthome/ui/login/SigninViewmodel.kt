package com.megathon.smarthome.ui.login

import androidx.lifecycle.ViewModel
import okhttp3.Headers
import retrofit2.Call


class SigninViewmodel : ViewModel() {

    fun signin(email: String, type: String, pass: String) {
        //        setLoading(true);
        val signinModel = SigninModel()
        signinModel.email = email
        signinModel.password = pass
        signinModel.type = type
        /*        Call<SignInResponseModel> call = RetrofitClient.getAPIInterface().signIn(signinModel);
        request = new RetrofitRequest<>(call, new ResponseListener<SignInResponseModel>() {
            @Override
            public void onResponse(SignInResponseModel response, Headers headers) {
                setLoading(false);
                signinListener.onSucess();
            }

            @Override
            public void onError(int status, String errors) {
                setLoading(false);
                signinListener.onError(errors);
            }

            @Override
            public void onFailure(Throwable throwable) {
                setLoading(false);
                setRetry(true);
                signinListener.onError("Failure");
            }
        });
        request.enqueue();*/
    }

    /* @Override
    public void retry() {
        super.retry();
        request.retry();
    }

    @Override
    public void clear() {
        if (request != null)
            request.cancel();
    }
*/
}

