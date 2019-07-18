package com.example.api.api;

import com.example.api.api.results.GetCategoryResults;
import com.example.api.api.results.LoginResult;
import com.example.api.api.results.SignupResult;
import com.example.model.Login;
import com.example.model.Signup;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


    public interface APIServices {


        @POST("register")
        Call<SignupResult> SignUp(
                @Body Signup signUp
        );
        @GET("info")
        Call<ResponseBody> getInfo(@Header("Authorization") String authToken);


        @POST("login")
        Call<LoginResult> LogIn(
                @Body Login logIn
        );

        @GET("category")
        Call<GetCategoryResults> getCategories(
                @Header("token") String token
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
