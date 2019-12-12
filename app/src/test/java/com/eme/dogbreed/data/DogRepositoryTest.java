package com.eme.dogbreed.data;

import androidx.lifecycle.LiveData;

import com.eme.dogbreed.model.Dog;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DogRepositoryTest {

    IDogRepository repository;
    FakeRestApi restApi;

    @Before
    public void setUp() throws Exception {
        restApi = spy(FakeRestApi.class);
        repository = DogRepository.getInstance(restApi);
    }

    @Test
    public void getDogs_happyCase() {
        // Given

        // When
        LiveData<List<Dog>> dogs = repository.getDogs();

        // Then
        verify(restApi, times(1)).getBreedList();
    }
}