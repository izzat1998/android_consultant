package com.example.mebel_system_consultant;

import com.example.mebel_system_consultant.api_serializer.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserClient {
    @POST("post")
    Call<UserInfo> createAccaount(@Body UserInfo user);
    String BASE_URL="http://192.168.0.111:8000/api/customer/";
    @GET("post/")
    Call<List<UserInfo>> GetNames();

}
