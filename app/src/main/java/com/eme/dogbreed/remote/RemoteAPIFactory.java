package com.eme.dogbreed.remote;

import com.eme.dogbreed.util.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteAPIFactory {

    public static IDogRestApi create() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(IDogRestApi.class);
    }
}
