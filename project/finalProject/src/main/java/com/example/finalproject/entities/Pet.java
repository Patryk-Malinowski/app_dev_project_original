package com.example.finalproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "pets")
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String animalType; // animal_type
    private String breed;
    private int age;


    @ManyToOne
    @JoinColumn(name="household_eircode") //The @JoinColumn annotation specifies the column that will
    // hold the foreign key in the database, establishing a link between two entities.
    Household household;

    public Pet(String name, String animalType, String breed, int age, Household household) {
        this.name = name;
        this.animalType = animalType;
        this.breed = breed;
        this.age = age;
        this.household = household;
    }

}
