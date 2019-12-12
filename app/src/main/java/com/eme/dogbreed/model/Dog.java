package com.eme.dogbreed.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(breedName, dog.breedName) &&
                Objects.equals(subBreedName, dog.subBreedName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breedName, subBreedName);
    }
}
