package com.example.finalproject.records;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NewPet(
        @NotEmpty @NotNull
        String name,

        @NotEmpty @NotNull
        String animalType,

        @NotEmpty @NotNull
        String breed,

        @Min(value = 0, message = "Age must be greater than or equal to 0")
        @Max(value = 30, message = "Age must be less than or equal to 30")
        int age,

        String householdPostcode
)
{
}
