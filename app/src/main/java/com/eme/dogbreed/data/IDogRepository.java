package com.eme.dogbreed.data;

import androidx.lifecycle.LiveData;

import com.eme.dogbreed.model.Dog;

import java.util.List;

public interface IDogRepository {

    LiveData<List<Dog>> getDogs();

    LiveData<List<String>> getImages(Dog dog);
}
