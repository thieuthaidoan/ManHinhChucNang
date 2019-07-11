package com.example.api.respose;

import com.example.api.respose.results.LoginResult;
import com.example.api.respose.results.SignupResult;
import com.example.manhinhchucnang.Login;
import com.example.manhinhchucnang.Signup;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


    public interface APIServices {

        @POST("login")
        Call<ResponseBody> login(
                @Body Login login
        );
        @POST("register")
        Call<SignupResult> SignUp(
                @Body Signup signUp
        );

//
//        @GET("users/info")
//        Call<UserProfilesResults> getUserProfiles(
//                @Header("token") String token
//        );
//
//        @POST("users/update")
//        Call<UserProfileResponse> getUserProfiles(
//                @Header("token") String token,
//                @Body UserProfiles userProfiles
//        );
//        @Multipart
//        @POST("image/")
//        Call<GetUploadResults> uploadImage(
//                @Header("token") String token,
//                @Part MultipartBody.Part file
//        );
}
