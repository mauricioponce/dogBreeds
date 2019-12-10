package com.eme.dogbreed.data;

import androidx.lifecycle.LiveData;

import com.eme.dogbreed.model.Dog;

public class DogRepository implements IDogRepository {

    private static IDogRepository INSTANCE;

    private DogRepository() {

    }

    public static IDogRepository getInstance(){
        synchronized (DogRepository.class) {
            if (DogRepository.INSTANCE == null) {
                DogRepository.INSTANCE = new DogRepository();
            }
            return DogRepository.INSTANCE;
        }
    }

    @Override
    public LiveData<Dog> getDogs() {
        return null;
    }
}
