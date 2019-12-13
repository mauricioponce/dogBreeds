package com.eme.dogbreed.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;

import com.eme.dogbreed.data.IDogRepository;
import com.eme.dogbreed.model.Dog;
import com.jraska.livedata.TestObserver;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class DogViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private DogViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        IDogRepository fakeRepository = new FakeRepository();

        viewModel = (DogViewModel) new DogViewModelFactory(fakeRepository).create(DogViewModel.class);
    }


    @Test
    public void getDogs_happyCase() {
        // Given
        List<Dog> expectedList = FakeRepository.getDefaultBreeds();

        // When
        LiveData<List<Dog>> dogs = viewModel.getDogs();

        // Then
        try {
            TestObserver.test(dogs)
                    .awaitValue()
                    .assertHasValue()
                    .assertValue(expectedList);

        } catch (InterruptedException iexc) {
            assertThat(iexc).isNull(); // Forced failure
        }
    }

    @Test
    public void setSelected_happyCase() {
        // Given
        Dog dog = new Dog("breedName", "subBreedName");

        // When
        viewModel.setSelected(dog);

        // Then
        try {
            TestObserver.test(viewModel.getSelected())
                    .awaitValue()
                    .assertHasValue()
                    .assertValue(dog);
        } catch (InterruptedException iexc) {
            assertThat(iexc).isNull(); // Forced failure
        }
    }

    @Test
    public void getImages_happyCase() {
        // Given
        Dog dog = new Dog("breedName", "subBreedName");
        viewModel.setSelected(dog);

        // When
        LiveData<List<String>> images = viewModel.getImages();

        // Then
        try {
            TestObserver.test(images)
                    .awaitValue()
                    .assertHasValue();

        } catch (InterruptedException iexc) {
            assertThat(iexc).isNull(); // Forced failure
        }
    }
}