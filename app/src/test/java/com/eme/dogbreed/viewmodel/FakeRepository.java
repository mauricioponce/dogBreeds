package com.eme.dogbreed.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eme.dogbreed.data.IDogRepository;
import com.eme.dogbreed.model.Dog;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FakeRepository implements IDogRepository {

    public static List<Dog> getDefaultBreeds() {
        List<Dog> dogs = new ArrayList<>(3);
        dogs.add(new Dog("buhund", "staffordshire"));
        dogs.add(new Dog("affenpinscher", ""));
        dogs.add(new Dog("corgi", "cardigan"));
        return dogs;
    }


    @Override
    public LiveData<List<Dog>> getDogs() {
        MutableLiveData<List<Dog>> listMutableLiveData = new MutableLiveData<>();
        listMutableLiveData.setValue(getDefaultBreeds());
        return listMutableLiveData;
    }
}
