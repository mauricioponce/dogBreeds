package com.eme.dogbreed.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.eme.dogbreed.model.Dog;
import com.eme.dogbreed.remote.IDogRestApi;
import com.eme.dogbreed.remote.pojo.ResponseWrapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class DogRepository implements IDogRepository {

    private static IDogRepository INSTANCE;

    private IDogRestApi dogRestApi;

    private DogRepository(IDogRestApi dogRestApi) {
        this.dogRestApi = dogRestApi;
    }

    public static IDogRepository getInstance(IDogRestApi dogRestApi){
        synchronized (DogRepository.class) {
            if (DogRepository.INSTANCE == null) {
                DogRepository.INSTANCE = new DogRepository(dogRestApi);
            }
            return DogRepository.INSTANCE;
        }
    }

    @Override
    public LiveData<List<Dog>> getDogs() {
        dogRestApi.getBreedList().enqueue(new Callback<ResponseWrapper>() {
            @Override
            public void onResponse(@NonNull Call<ResponseWrapper> call, @NonNull Response<ResponseWrapper> response) {
                Timber.d("onResponse() called with: response = [" + response + "]");

                Timber.d("body %s", response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ResponseWrapper> call, @NonNull Throwable t) {
                Timber.w("onFailure() not implemented with: call = [" + call + "], t = [" + t + "]");
            }
        });
        return null;
    }
}
