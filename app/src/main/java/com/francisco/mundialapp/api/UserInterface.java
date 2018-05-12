package com.francisco.mundialapp.api;

import industries.marin.prueba2.data.Response;
import industries.marin.prueba2.data.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by RicardoM on 28/04/2018.
 */

public interface UserInterface {

    @POST("/login/login")
    Call<Response> createNewUser(@Body User user);

}
