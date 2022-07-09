package com.fuelconsumption.management.controllers.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author david.martini
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FuelTypeResponseDto {
    private final String month;
    private FuelTotalValueResponseDto gasoline;
    private FuelTotalValueResponseDto alcohol;
    private FuelTotalValueResponseDto diesel;


    public FuelTypeResponseDto(final String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    public FuelTotalValueResponseDto getGasoline() {
        return gasoline;
    }

    public FuelTotalValueResponseDto getAlcohol() {
        return alcohol;
    }

    public FuelTotalValueResponseDto getDiesel() {
        return diesel;
    }

    public void createGasoline() {
        gasoline = new FuelTotalValueResponseDto();
    }

    public void createAlcohol() {
        alcohol = new FuelTotalValueResponseDto();
    }

    public void createDiesel() {
        diesel = new FuelTotalValueResponseDto();
    }

}
