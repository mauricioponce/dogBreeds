package com.eme.dogbreed.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.eme.dogbreed.data.IDogRepository;
import com.eme.dogbreed.model.Dog;

import java.util.List;

public class DogViewModel extends ViewModel {

    private IDogRepository repository;

    public DogViewModel(IDogRepository repository) {
        this.repository = repository;
    }

    public LiveData<List<Dog>> getDogs() {
        return this.repository.getDogs();
    }
}
