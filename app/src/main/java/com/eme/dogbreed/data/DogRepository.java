package com.eme.dogbreed.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eme.dogbreed.model.Dog;
import com.eme.dogbreed.remote.IDogRestApi;
import com.eme.dogbreed.remote.pojo.ResponseWrapper;
import com.eme.dogbreed.util.Transformer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class DogRepository implements IDogRepository {

    private static IDogRepository INSTANCE;

    private IDogRestApi dogRestApi;

    private MutableLiveData<List<Dog>> dogs = new MutableLiveData<>();

    private MutableLiveData<List<String>> images = new MutableLiveData<>();

    private DogRepository(IDogRestApi dogRestApi) {
        this.dogRestApi = dogRestApi;
    }

    public static IDogRepository getInstance(IDogRestApi dogRestApi) {
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
                if (response.isSuccessful()) {
                    List<Dog> dogList = Transformer.transformFromResponse(response.body().getMessage());

                    dogs.setValue(dogList);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseWrapper> call, @NonNull Throwable t) {
                Timber.w("onFailure() not implemented with: call = [" + call + "], t = [" + t + "]");
            }
        });
        return dogs;
    }

    public LiveData<List<String>> getImages(Dog dog) {
        Callback<ResponseWrapper.ResponseWrapperList> callback = new Callback<ResponseWrapper.ResponseWrapperList>() {
            @Override
            public void onResponse(Call<ResponseWrapper.ResponseWrapperList> call, Response<ResponseWrapper.ResponseWrapperList> response) {
                List<String> urls = response.body().getMessage();

                images.setValue(urls);
            }

            @Override
            public void onFailure(Call<ResponseWrapper.ResponseWrapperList> call, Throwable t) {
                Timber.d("onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }
        };

        if(dog.getSubBreedName().isEmpty()) {
            dogRestApi.getBreedImages(dog.getBreedName()).enqueue(callback);
        } else {
            dogRestApi.getBreedImages(dog.getBreedName(), dog.getSubBreedName()).enqueue(callback);
        }
        return images;
    }
}
