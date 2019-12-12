package com.eme.dogbreed.util;

import com.eme.dogbreed.model.Dog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Transformer {

    public static List<Dog> transformFromResponse(Map<String, List<String>> breedsList) {
        List<Dog> dogos = new ArrayList<>();

        if(breedsList == null) {
            return dogos;
        }

        breedsList.keySet().forEach(breed -> {
            List<String> subBreeds = breedsList.get(breed);
            if (subBreeds.isEmpty()) {
                dogos.add(new Dog(breed, ""));
            } else {
                subBreeds.forEach(subBreed -> dogos.add(new Dog(breed, subBreed)));
            }
        });

        return dogos;
    }
}
