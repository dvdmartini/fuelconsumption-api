package com.fuelconsumption.management.models;

import com.fuelconsumption.management.enums.FuelTypeEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author david.martini
 */
@Entity
@Table(name = "TB_FUEL_CONSUMPTION")
public class FuelConsumptionModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private FuelTypeEnum fuelType;

    @Column(nullable = false, scale = 2)
    private Double volume;

    @Column(nullable = false, scale = 2)
    private Double value;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy", iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
