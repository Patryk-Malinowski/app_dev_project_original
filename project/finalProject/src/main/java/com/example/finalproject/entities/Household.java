package com.example.finalproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "household")
@AllArgsConstructor
@NoArgsConstructor
public class Household {
    @Id
    private String eircode;
    private int numberOfOccupants;
    private int maxNumberOfOccupants;
    private boolean ownerOccupied;

    // Mapped by the household property in Pet
    // If the household is edited, make edits as appropriate in pets
    // LAZY -> When fetching a household, do not fetch the list of pets. This is efficient.
    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude // can't include a lazily fetched item in the toString
    private List<Pet> listOfPets;
}
