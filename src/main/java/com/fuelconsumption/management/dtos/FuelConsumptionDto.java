package com.fuelconsumption.management.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fuelconsumption.management.enums.FuelTypeEnum;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author david.martini
 */
public class FuelConsumptionDto {

    @NotNull(message = "Required FuelType")
    private FuelTypeEnum fuelType;

    @NotNull(message = "Require Volume")
    private Double volume;

    @NotNull(message = "Require Value")
    private Double value;

    @NotNull(message = "Require Date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "pt-BR", timezone = "America/Sao_Paulo")
    private LocalDate date;

    public FuelTypeEnum getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelTypeEnum fuelType) {
        this.fuelType = fuelType;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
