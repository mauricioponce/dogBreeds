package com.eme.dogbreed.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.eme.dogbreed.data.IDogRepository;
import com.eme.dogbreed.model.Dog;

import java.util.List;

public class DogViewModel extends ViewModel {

    private IDogRepository repository;

    private LiveData<List<Dog>> dogos;

    public DogViewModel(IDogRepository repository) {
        this.repository = repository;
        this.dogos = Transformations.map(this.repository.getDogs(), input -> input);
    }

    public LiveData<List<Dog>> getDogs() {
        return this.dogos;
    }
}
