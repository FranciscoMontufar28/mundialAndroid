package com.francisco.mundialapp.api;


import com.francisco.mundialapp.data.Login;
import com.francisco.mundialapp.data.Response;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.POST;


public interface UserInterface {

    @POST("/rest/login")
    Call<Response> login(@Body Login login);



}
