package com.eme.dogbreed.util;

import com.eme.dogbreed.model.Dog;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;


public class TransformerTest {

    @Test
    public void transformFromResponse_happyCase() {
        // Given
        Map<String, List<String>> breedsList = new HashMap<>();
        breedsList.put("affenpinscher", Collections.emptyList());
        breedsList.put("bulldog", Arrays.asList(new String[] {"boston", "english", "french"}));
        breedsList.put("buhund", Arrays.asList(new String[] {"norwegian"}));


        // When
        List<Dog> dogs = Transformer.transformFromResponse(breedsList);

        // Then
        assertThat(dogs).isNotNull();
        assertThat(dogs).isNotEmpty();
        assertThat(dogs).hasSize(5);
    }

    @Test
    public void transformFromResponse_nullList() {
        // Given
        HashMap<String, List<String>> breedsList = null;

        // When
        List<Dog> dogs = Transformer.transformFromResponse(breedsList);

        // Then
        assertThat(dogs).isNotNull();
        assertThat(dogs).isEmpty();
    }
}