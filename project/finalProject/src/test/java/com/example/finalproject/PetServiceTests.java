package com.example.finalproject;

import com.example.finalproject.entities.Pet;
import com.example.finalproject.services.PetService;
import com.example.finalproject.services.exceptions.NotFoundException;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Without this it will ignore any @Order annotations
public class PetServiceTests {
    @Autowired
    PetService petService;

    @Test
    @Order(1)
    void contextLoads() {
        Assertions.assertNotNull(petService);
    }

    @Test
    @Order(2)
    void getAllPets() {
        Assertions.assertNotNull(petService.getAllPets());
    }

    @Test
    @Order(3)
    void getPetById() {
        Assertions.assertNotNull(petService.getPetById(1));
    }

    @Test
    @Order(4)
    @Transactional
    void deletePetById() {
        petService.deletePetById(1);
        Assertions.assertThrows(NotFoundException.class, () -> {
            petService.getPetById(1);
        });
    }

    @Test
    @Order(5)
    @Transactional
    void updatePet() {
        petService.updatePetName(2 , "NewName");
        Assertions.assertEquals("NewName", petService.getPetById(2).getName());
    }


    @Test
    @Order(6)
    void getPetCount() {
        Assertions.assertEquals(10, petService.getPetCount());
    }

    @Test
    @Order(7)
    void getOldestPet() {
        Assertions.assertEquals(5, petService.getOldestPetAge());
    }


}
