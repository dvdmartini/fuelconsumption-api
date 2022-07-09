package com.fuelconsumption.management.services;

import com.fuelconsumption.management.controllers.dtos.FuelConsumptionResponseDto;
import com.fuelconsumption.management.controllers.dtos.FuelTypeResponseDto;
import com.fuelconsumption.management.enums.FuelTypeEnum;
import com.fuelconsumption.management.models.FuelConsumptionModel;
import com.fuelconsumption.management.repositories.FuelConsumptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional()
    public FuelConsumptionModel save(FuelConsumptionModel fuelConsumptionModel) {
        return fuelConsumptionRepository.save(fuelConsumptionModel);
    }

    @Transactional(readOnly = true)
    public FuelConsumptionResponseDto findAllByFuelType() {
        return new FuelConsumptionResponseDto(fuelConsumptionRepository.findAll().stream()
                .collect(Collectors.groupingBy(consumption -> consumption.getDate().getMonth()))
                .entrySet().stream().map((k) -> {
                    FuelTypeResponseDto o = new FuelTypeResponseDto(k.getKey().toString());
                    k.getValue().forEach(p -> {
                        if (p.getFuelType() == FuelTypeEnum.GASOLINE) {
                            if (p.getVolume() > 0 && p.getValue() > 0 && o.getGasoline() == null) {
                                o.createGasoline();
                            }
                            o.getGasoline().addAmount(p.getValue());
                            o.getGasoline().addVolume(p.getVolume());
                        } else if (p.getFuelType() == FuelTypeEnum.ALCOHOL) {
                            if (p.getVolume() > 0 && p.getValue() > 0 && o.getAlcohol() == null) {
                                o.createAlcohol();
                            }
                            o.getAlcohol().addAmount(p.getValue());
                            o.getAlcohol().addVolume(p.getVolume());

                        } else if (p.getFuelType() == FuelTypeEnum.DIESEL) {
                            if (p.getVolume() > 0 && p.getValue() > 0 && o.getDiesel() == null) {
                                o.createDiesel();
                            }
                            o.getDiesel().addAmount(p.getValue());
                            o.getDiesel().addVolume(p.getVolume());
                        }
                    });
                    return o;
                }).collect(Collectors.toList()));
    }

}
