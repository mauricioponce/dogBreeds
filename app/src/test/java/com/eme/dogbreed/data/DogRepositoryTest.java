package com.eme.dogbreed.data;

import androidx.lifecycle.LiveData;

import com.eme.dogbreed.model.Dog;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;


public class DogRepositoryTest {

    IDogRepository repository;
    FakeRestApi spyService;

    @Before
    public void setUp() throws Exception {
        spyService = spy(new FakeRestApi());

        repository = DogRepository.getInstance(spyService);
    }

    @Test
    public void getDogs_happyCase() {
        // Given

        // When
        LiveData<List<Dog>> dogs = repository.getDogs();

        // Then
        verify(spyService, times(1)).getBreedList();
    }

    @Test
    public void getImages_emptySubBreed() {
        // Given
        Dog dog = new Dog("breeName", "");

        // When
        LiveData<List<String>> images = repository.getImages(dog);

        // Then
        verify(spyService, times(1)).getBreedImages(anyString());
    }

    @Test
    public void getImages_withSubBreed() {
        // Given
        Dog mock = new Dog("breeName", "subBreedName");

        // When
        repository.getImages(mock);

        // Then
        verify(spyService, times(1)).getBreedImages(anyString(), anyString());
    }
}