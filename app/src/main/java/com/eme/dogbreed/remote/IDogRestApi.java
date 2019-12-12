package com.eme.dogbreed.remote;

import com.eme.dogbreed.remote.pojo.ResponseWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IDogRestApi {

    @GET("breeds/list/all")
    Call<ResponseWrapper> getBreedList();

    @GET("breed/{breed}/images")
    Call<ResponseWrapper.ResponseWrapperList> getBreedImages(@Path("breed") String breed);

    @GET("breed/{breed}/{subbreed}/images")
    Call<ResponseWrapper.ResponseWrapperList> getBreedImages(@Path("breed") String breed, @Path("subbreed") String subreed);
}
