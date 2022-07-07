package com.fuelconsumption.management.repositories;

import com.fuelconsumption.management.models.FuelConsumptionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author david.martini
 */
public interface FuelConsumptionRepository extends JpaRepository<FuelConsumptionModel, UUID> {
}
