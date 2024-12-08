package com.example.finalproject.services;

import com.example.finalproject.entities.Pet;
import com.example.finalproject.records.NameTypeBreed;
import com.example.finalproject.repositories.PetRepository;
import com.example.finalproject.services.exceptions.BadDataException;
import com.example.finalproject.services.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class PetServiceImpl implements PetService{
    private PetRepository petRepository;

    @Override
    public Pet addPet(Pet pet) throws BadDataException {
        if (pet.getName().isBlank()) {
            throw new BadDataException("Name is blank");
        }
        else if (pet.getAnimalType().isBlank()) {
            throw new BadDataException("Animal type is blank");
        }
        else if (pet.getAge() < 0) {
            throw new BadDataException("Age is negative");
        }
        else if (pet.getBreed().isBlank()) {
            throw new BadDataException("Breed is blank");
        }

        petRepository.save(pet);
        return pet;
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(long id) throws NotFoundException {
        return petRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Pet not found, ID: " + id)
        );
    }

    @Override
    public void updatePetName(long id, String petName) throws BadDataException, NotFoundException {
        if (petName.isBlank()) {
            throw new BadDataException("Breed is blank");
        }

        Pet pet = petRepository.findPetById(id);
        if (pet == null) {
            throw new NotFoundException("Pet not found, ID: " + id);
        }

        pet.setName(petName);
    }

    @Override
    public void updatePetType(long id, String petType) throws BadDataException, NotFoundException {
        if (petType.isBlank()) {
            throw new BadDataException("Breed is blank");
        }

        Pet pet = petRepository.findPetById(id);
        if (pet == null) {
            throw new NotFoundException("Pet not found, ID: " + id);
        }

        pet.setAnimalType(petType);
    }

    @Override
    public void updatePetBreed(long id, String petBreed) throws BadDataException, NotFoundException {
        if (petBreed.isBlank()) {
            throw new BadDataException("Breed is blank");
        }

        Pet pet = petRepository.findPetById(id);
        if (pet == null) {
            throw new NotFoundException("Pet not found, ID: " + id);
        }

        pet.setBreed(petBreed);
    }

    @Override
    public void updatePetAge(long id, int petAge) throws BadDataException, NotFoundException {
        if (petAge < 0) {
            throw new BadDataException("Age is negative");
        }

        Pet pet = petRepository.findPetById(id);
        if (pet == null) {
            throw new NotFoundException("Pet not found, ID: " + id);
        }

        pet.setAge(petAge);
    }


    @Transactional
    @Override
    public void deletePetById(long id) throws NotFoundException {
        int rowAffected = petRepository.deletePetById(id);
        if (rowAffected != 1) {
            throw new NotFoundException("Pet not found, ID: " + id);
        }
    }

    @Transactional
    @Override
    public void deletePetByName(String petName) throws NotFoundException {
        int rowAffected = petRepository.deletePetByName(petName);
        if (rowAffected != 1) {
            throw new NotFoundException("Pet not found, Name: " + petName);
        }
    }

    @Override
    public List<Pet> getPetsByType(String type) {
        return petRepository.findPetByAnimalType(type);
    }

    @Override
    public List<Pet> getPetsByBreed(String breed) {
        return petRepository.findPetsByBreed(breed);
    }

    @Override
    public List<NameTypeBreed> getAllPetNamesAndBreed() {
        return petRepository.getAllNameTypeBreed();
    }

    @Override
    public long getPetCount() {
        return petRepository.count();
    }

    @Override
    public int getAvgPetAge() {
        return petRepository.getPetAverageAge();
    }

    @Override
    public int getOldestPetAge() {
        return petRepository.getPetOldestAge();
    }

    @Override
    public int getYoungestPetAge() {
        return petRepository.getPetYoungestAge();
    }


}
