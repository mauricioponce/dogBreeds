package com.eme.dogbreed.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.eme.dogbreed.data.IDogRepository;
import com.eme.dogbreed.model.Dog;

import java.util.List;

public class DogViewModel extends ViewModel {

    private IDogRepository repository;

    private LiveData<List<Dog>> dogos;

    private LiveData<List<String>> images;

    private MutableLiveData<Dog> selected = new MutableLiveData<>();

    public DogViewModel(IDogRepository repository) {
        this.repository = repository;
        this.dogos = Transformations.map(this.repository.getDogs(), input -> input);
        this.images = Transformations.switchMap(selected, dog -> this.repository.getImages(dog));
    }

    public LiveData<List<Dog>> getDogs() {
        return this.dogos;
    }

    public void setSelected(Dog selected) {
        this.selected.setValue(selected);
    }

    public LiveData<List<String>> getImages() {
        return images;
    }

    // Just for testing
    public LiveData getSelected() {
        return selected;
    }
}
