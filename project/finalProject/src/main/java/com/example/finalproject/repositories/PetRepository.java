package com.example.finalproject.repositories;

import com.example.finalproject.entities.Pet;
import com.example.finalproject.records.NameTypeBreed;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PetRepository extends JpaRepository<Pet, Long> {

    @Transactional
    @Modifying
    int deletePetById(long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Pet p WHERE LOWER(p.name) = LOWER(:name)")
    int deletePetByName(@Param("name") String name);

    List<Pet> findPetByAnimalType(String type);

    @Query("SELECT p.breed FROM Pet p WHERE p.breed=:breed ORDER BY p.age DESC")
    List<Pet> findPetsByBreed(@Param("breed") String breed);

    @Query("SELECT new com.example.finalproject.records.NameTypeBreed(p.name, p.animalType, p.breed) FROM Pet p")
    List<NameTypeBreed> getAllNameTypeBreed();

    @Query("SELECT AVG(p.age) FROM Pet p")
    int getPetAverageAge();

    @Query("SELECT MAX(p.age) FROM Pet p")
    int getPetOldestAge();

    @Query("SELECT MIN(p.age) FROM Pet p")
    int getPetYoungestAge();

    Pet findPetById(long id);
}
