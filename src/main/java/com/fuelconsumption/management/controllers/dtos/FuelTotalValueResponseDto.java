package com.fuelconsumption.management.controllers.dtos;

import java.util.Objects;

/**
 * @author david.martini
 */
public class FuelTotalValueResponseDto {
    private Double amount;
    private Double volume;

    public FuelTotalValueResponseDto() {
        this.amount = 0.0;
        this.volume = 0.0;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getVolume() {
        return volume;
    }


    public void addAmount(Double amount) {
        Objects.requireNonNull(amount);
        this.amount = this.amount + amount;
    }

    public void addVolume(Double volume) {
        Objects.requireNonNull(volume);
        this.volume = this.volume + volume;
    }
}
