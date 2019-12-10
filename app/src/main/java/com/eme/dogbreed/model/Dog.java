package com.eme.dogbreed.model;

public class Dog {

    private String breedName;

    private String subBreedName;

    public Dog(String breedName, String subBreedName) {
        this.breedName = breedName;
        this.subBreedName = subBreedName;
    }

    public String getBreedName() {
        return breedName;
    }

    public String getSubBreedName() {
        return subBreedName;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breedName='" + breedName + '\'' +
                ", subBreedName='" + subBreedName + '\'' +
                '}';
    }
}
