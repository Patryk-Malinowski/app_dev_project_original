package com.example.finalproject.services;

import com.example.finalproject.entities.Household;
import com.example.finalproject.repositories.HouseholdRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class HouseholdServiceImpl implements HouseholdService {
    HouseholdRepository householdRepository;

    @Override
    public Household findByEircode(String eircode) {
        return householdRepository.findByEircode(eircode);
    }

    @Override
    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    @Override
    public Household getHouseholdByEircode(String eircode) {
        return householdRepository.findByEircode(eircode);
    }

    @Override
    public void deleteHouseholdByEircode(String eircode) {
        householdRepository.deleteById(eircode);
    }

    @Override
    public Household addHousehold(Household household) {
        householdRepository.save(household);
        return household;
    }

    @Override
    public void deleteHouseholdById(String id) {
        householdRepository.deleteById(id);
    }

    @Override
    public Household createHousehold(Household household) {
        return householdRepository.save(household);
    }

    @Override
    public List<Household> findAllHouseholdsWithNoPets() {
        return householdRepository.findAllHouseholdsWithNoPets();
    }
}
