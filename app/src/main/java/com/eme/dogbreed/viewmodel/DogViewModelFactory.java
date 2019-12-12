package com.eme.dogbreed.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.eme.dogbreed.data.IDogRepository;

import org.jetbrains.annotations.NotNull;

public class DogViewModelFactory {

    private final IDogRepository repository;

    public DogViewModelFactory(@NonNull IDogRepository repository) {
        super();
        this.repository = repository;
    }

    @NotNull
    public ViewModel create(@NonNull Class modelClass) {
        return new DogViewModel(this.repository);
    }
}
