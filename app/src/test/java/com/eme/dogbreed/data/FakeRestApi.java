package com.eme.dogbreed.data;

import com.eme.dogbreed.remote.IDogRestApi;
import com.eme.dogbreed.remote.pojo.ResponseWrapper;

import java.io.IOException;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FakeRestApi implements IDogRestApi {
    @Override
    public Call<ResponseWrapper> getBreedList() {
        return new Call<ResponseWrapper>() {
            @Override
            public Response<ResponseWrapper> execute() throws IOException {
                return null;
            }

            @Override
            public void enqueue(Callback<ResponseWrapper> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<ResponseWrapper> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };
    }
}
