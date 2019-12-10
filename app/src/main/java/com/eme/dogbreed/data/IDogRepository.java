package com.eme.dogbreed.data;

import androidx.lifecycle.LiveData;

import com.eme.dogbreed.model.Dog;

public interface IDogRepository {

    LiveData<Dog> getDogs();

}
