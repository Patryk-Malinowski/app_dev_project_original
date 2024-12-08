package com.example.finalproject.repositories;

import com.example.finalproject.entities.Household;
import com.example.finalproject.entities.Pet;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseholdRepository extends JpaRepository<Household, String> {

    // Find household by eircode without pets? Exists with findById

    // Find household by eircode but get pets eagerly
    @EntityGraph(attributePaths = {"pets"})
    Household findByEircode(@Param("eircode") String eircode);

    // Find list of households with no pets
    @Query("SELECT h FROM Household h WHERE SIZE(h.listOfPets) = 0")
    List<Household> findAllHouseholdsWithNoPets();

}
