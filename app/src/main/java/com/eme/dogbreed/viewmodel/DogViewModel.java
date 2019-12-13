package com.eme.dogbreed.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.eme.dogbreed.data.IDogRepository;
import com.eme.dogbreed.model.Dog;

import java.util.List;

import timber.log.Timber;

/**
 * Shared view model used in main listing fragment and images fragment
 */
public class DogViewModel extends ViewModel {

    private LiveData<List<Dog>> dogos;

    private LiveData<List<String>> images;

    private MutableLiveData<Dog> selected = new MutableLiveData<>();

    public DogViewModel(IDogRepository repository) {
        this.dogos = Transformations.map(repository.getDogs(), input -> input);
        this.images = Transformations.switchMap(this.selected, repository::getImages);
    }

    public LiveData<List<Dog>> getDogs() {
        return this.dogos;
    }

    public void setSelected(Dog selected) {
        this.selected.setValue(selected);
    }

    public LiveData<List<String>> getImages() {
        Timber.d("getImages() called");
        return this.images;
    }

    // Just for testing
    public LiveData<Dog> getSelected() {
        return this.selected;
    }
}
