package com.example.finalproject.controllers.rest;

import com.example.finalproject.entities.Household;
import com.example.finalproject.entities.Pet;
import com.example.finalproject.records.NewHousehold;
import com.example.finalproject.services.HouseholdService;
import com.example.finalproject.services.PetService;
import com.example.finalproject.services.exceptions.BadDataException;
import com.example.finalproject.services.exceptions.NotFoundException;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/myapi/households")
public class HouseholdWebService {
    private HouseholdService householdService;

    @GetMapping("/")
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @GetMapping("")
    public List<Household> getAllHouseholdsWithNoPets() {
        return householdService.findAllHouseholdsWithNoPets();
    }

    @GetMapping("/{eircode}")
    public Household getHouseholdByEircode(@PathVariable("eircode") String eircode) throws NotFoundException {
        return householdService.findByEircode(eircode);
    }

    @DeleteMapping("/{eircode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHouseholdByEircode(@PathVariable("eircode") String eircode) throws NotFoundException {
        householdService.deleteHouseholdByEircode(eircode);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Household addHousehold(@RequestBody @Valid NewHousehold newHousehold) throws BadDataException {

        List<Pet> pets = new ArrayList<>();

        Household household = new Household(newHousehold.ericode(), newHousehold.numberOfOccupants(),
                newHousehold.maxNumberOfOccupants(), newHousehold.ownerOccupied(), pets);

        return householdService.addHousehold(household);

    }

}
