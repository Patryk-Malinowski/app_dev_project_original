package com.example.finalproject.controllers;

import com.example.finalproject.entities.Household;
import com.example.finalproject.entities.Pet;
import com.example.finalproject.services.HouseholdService;
import com.example.finalproject.services.PetService;
import com.example.finalproject.services.exceptions.BadDataException;
import com.example.finalproject.services.exceptions.NotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class GraphQLAPI {
    private PetService petService;
    private HouseholdService householdService;

    @QueryMapping
    List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @QueryMapping
    List<Pet> getAllPetsByAnimaltype(String animaltype) {
        return petService.getPetsByType(animaltype);
    }

    @QueryMapping
    Household getHouseholdByEircode(String eircode) {
        return householdService.getHouseholdByEircode(eircode);
    }

    @QueryMapping
    Pet getPetById(int id) {
        return petService.getPetById(id);
    }

    @QueryMapping
    int getOldestPetAge() {
        return petService.getOldestPetAge();
    }

    @MutationMapping
    @Secured({"ADMIN", "USER"})
    Household createHousehold(@Argument @Valid Household household) {
        return householdService.createHousehold(household);
    }

    @MutationMapping
    @Secured("ADMIN")
    void deleteHouseholdById(@Argument String id) {
        householdService.deleteHouseholdById(id);
    }

    @MutationMapping
    @Secured("ADMIN")
    void deletePetById(@Argument int id) {
        petService.deletePetById(id);
    }
}