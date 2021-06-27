package com.example.resourcesrelationnelles;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserClient {
    @GET("authentication")
    Call<UserDto> getUser(@Header("Authorization")String authHeader);

}
