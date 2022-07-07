package com.fuelconsumption.management.services;

import com.fuelconsumption.management.models.FuelConsumptionModel;
import com.fuelconsumption.management.repositories.FuelConsumptionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Month;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author david.martini
 */

@Service
public class FuelConsumptionService {

    final FuelConsumptionRepository fuelConsumptionRepository;

    public FuelConsumptionService(FuelConsumptionRepository fuelConsumptionRepository) {
        this.fuelConsumptionRepository = fuelConsumptionRepository;
    }

    @Transactional
    public FuelConsumptionModel save(FuelConsumptionModel fuelConsumptionModel) {
        return fuelConsumptionRepository.save(fuelConsumptionModel);
    }

    public Map<Month, Map<String, Map<Double, Double>>> findAllByFuelType() {
        return fuelConsumptionRepository.findAll().stream()
                .collect(Collectors.groupingBy(consumption -> consumption.getDate().getMonth(),
                        Collectors.groupingBy(fuelType -> fuelType.getFuelType().getDescribe(),
                                Collectors.toMap(FuelConsumptionModel::getVolume,FuelConsumptionModel::getValue)
                        )));
    }
}
