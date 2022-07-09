package com.fuelconsumption.management.controllers.dtos;

import java.util.List;

/**
 * @author david.martini
 */
public class FuelConsumptionResponseDto {

    private final List<FuelTypeResponseDto> consumption;

    public FuelConsumptionResponseDto(List<FuelTypeResponseDto> consumption) {
        this.consumption = consumption;
    }

    public List<FuelTypeResponseDto> getConsumption() {
        return consumption;
    }
}
