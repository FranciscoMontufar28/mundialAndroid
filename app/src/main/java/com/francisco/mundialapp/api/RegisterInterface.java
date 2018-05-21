package com.francisco.mundialapp.api;

import com.francisco.mundialapp.data.Response;
import com.francisco.mundialapp.data.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface RegisterInterface {

    @POST("/rest/addUser")
    Call<Response> addUser(@Body User user);
}
