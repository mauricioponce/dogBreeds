package com.eme.dogbreed.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.eme.dogbreed.data.IDogRepository;

import org.jetbrains.annotations.NotNull;

public class DogViewModelFactory extends ViewModelProvider.NewInstanceFactory{

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
