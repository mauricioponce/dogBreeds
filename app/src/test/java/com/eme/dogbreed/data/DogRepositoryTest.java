package com.eme.dogbreed.data;

import androidx.lifecycle.LiveData;

import com.eme.dogbreed.model.Dog;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DogRepositoryTest {

    IDogRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = new DogRepository();
    }

    @Test
    public void getDogs() {
        // Given

        // When
        LiveData<Dog> dogs = repository.getDogs();

        // Then
        assert dogs == null;
    }
}