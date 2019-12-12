package com.eme.dogbreed.remote;

import com.eme.dogbreed.remote.pojo.ResponseWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IDogRestApi {

    @GET("/breeds/list/all")
    Call<ResponseWrapper> getBreedList();
}
