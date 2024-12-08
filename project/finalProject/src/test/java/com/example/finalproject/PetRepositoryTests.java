package com.example.finalproject;

import com.example.finalproject.entities.Pet;
import com.example.finalproject.repositories.PetRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Without this it will ignore any @Order annotations
public class PetRepositoryTests {
    @Autowired
    PetRepository petRepository;

    @Test
    @Order(1)
    void contextLoads() {
        Assertions.assertNotNull(petRepository);
    }

    @Test
    @Order(2)
    void countPets() {
        Assertions.assertEquals(10, petRepository.count());
    }

    @Test
    @Order(3)
    void findPetById() {
        Pet pet = petRepository.findPetById(1);

        Assertions.assertEquals("Buddy", pet.getName());
    }

    @Test
    @Order(4)
    @Transactional    void deletePetById() {
        petRepository.deletePetById(1);
        Assertions.assertEquals(9, petRepository.count());
    }

    @Test
    @Order(5)
    @Transactional
    void savePet() {
        Pet pet = new Pet();
        pet.setName("Buddy");
        pet.setAge(4);
        pet.setBreed("Breed");
        pet.setAnimalType("Type");
        petRepository.save(pet);
        Assertions.assertEquals(pet, petRepository.findPetById(pet.getId()));
    }




}
