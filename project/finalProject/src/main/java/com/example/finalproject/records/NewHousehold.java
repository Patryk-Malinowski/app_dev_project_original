package com.example.finalproject.records;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NewHousehold(
        @NotEmpty @NotNull
        String ericode,

        @NotEmpty @NotNull
        int numberOfOccupants,

        @NotEmpty @NotNull
        int maxNumberOfOccupants,

        @NotEmpty @NotNull
        boolean ownerOccupied
        )
{
}
