package com.example.finalproject.services;

import com.example.finalproject.entities.Household;


import java.util.List;

public interface HouseholdService {
    // Find household by eircode but get pets eagerly
    Household findByEircode(String eircode);
    // Find list of households with no pets
    List<Household> findAllHouseholdsWithNoPets();
    List<Household> getAllHouseholds();
    Household getHouseholdByEircode(String eircode);
    void deleteHouseholdByEircode(String eircode);
    Household addHousehold(Household household);
    Household createHousehold(Household household);
    void deleteHouseholdById(String id);
}
