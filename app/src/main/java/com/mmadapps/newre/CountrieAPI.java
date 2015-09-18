package com.mmadapps.newre;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by gangadhar.g on 9/18/2015.
 */
public interface CountrieAPI {
    @GET("/v1/{queryname}/{queryvalue}")
    public void GetCountries(@Path("queryname") String queryparams,@Path("queryvalue")String queryvalue, Callback<List<Country>> response);
}
