package com.example.finalproject.controllers.rest;

import com.example.finalproject.entities.Household;
import com.example.finalproject.entities.Pet;
import com.example.finalproject.records.NewPet;
import com.example.finalproject.services.HouseholdService;
import com.example.finalproject.services.PetService;
import com.example.finalproject.services.exceptions.BadDataException;
import com.example.finalproject.services.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/myapi/pets")
public class PetWebService {
    private PetService petService;
    private HouseholdService householdService;

    @GetMapping("/")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable("id") int id) throws NotFoundException {
        return petService.getPetById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePetById(@PathVariable("id") int id) throws NotFoundException {
        petService.deletePetById(id);
    }

    @PostMapping({"/"})
    @ResponseStatus(HttpStatus.CREATED)
    public Pet addPet(@RequestBody @Valid NewPet newPet) throws BadDataException {

        Household household = null;

        if (newPet.householdPostcode() != null && !newPet.householdPostcode().isEmpty()) {
            household = householdService.findByEircode(newPet.householdPostcode());
        }

        Pet pet = new Pet(newPet.name(), newPet.animalType(), newPet.breed(),
                newPet.age(), household);

        return petService.addPet(pet);
    }

    @PatchMapping("/{id}/{name}")
    public void changePetName(@PathVariable int id, @PathVariable String name) throws BadDataException, NotFoundException {
        petService.updatePetName(id, name);
    }


}
