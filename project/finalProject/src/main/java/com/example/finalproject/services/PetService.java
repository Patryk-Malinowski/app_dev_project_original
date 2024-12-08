package com.example.finalproject.services;

import com.example.finalproject.entities.Pet;
import com.example.finalproject.records.NameTypeBreed;
import com.example.finalproject.services.exceptions.BadDataException;
import com.example.finalproject.services.exceptions.NotFoundException;

import java.util.List;

public interface PetService {
    Pet addPet(Pet pet) throws BadDataException;
    List<Pet> getAllPets();
    Pet getPetById(long id) throws NotFoundException;
    void updatePetName(long id, String petName) throws BadDataException, NotFoundException;
    void updatePetType(long id, String petType) throws BadDataException, NotFoundException;
    void updatePetBreed(long id, String petBreed) throws BadDataException, NotFoundException;
    void updatePetAge(long id, int petAge) throws BadDataException, NotFoundException;
    void deletePetById(long id) throws NotFoundException;
    void deletePetByName(String petName) throws NotFoundException;
    List<Pet> getPetsByType(String type);
    List<Pet> getPetsByBreed(String breed);
    List<NameTypeBreed> getAllPetNamesAndBreed();
    long getPetCount();
    int getAvgPetAge();
    int getOldestPetAge();
    int getYoungestPetAge();
}
