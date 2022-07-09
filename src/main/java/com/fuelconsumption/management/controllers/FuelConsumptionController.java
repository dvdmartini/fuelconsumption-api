package com.fuelconsumption.management.controllers;

import com.fuelconsumption.management.controllers.dtos.FuelConsumptionDto;
import com.fuelconsumption.management.models.FuelConsumptionModel;
import com.fuelconsumption.management.services.FuelConsumptionService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author david.martini
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/fuel-consumption")
public class FuelConsumptionController {

    final FuelConsumptionService fuelConsumptionService;

    public FuelConsumptionController(FuelConsumptionService fuelConsumptionService) {
        this.fuelConsumptionService = fuelConsumptionService;
    }

    @PostMapping
    public ResponseEntity<Object> saveFuelConsumption(@RequestBody @Valid FuelConsumptionDto fuelConsumptionDto) {
        FuelConsumptionModel fuelConsumptionModel = new FuelConsumptionModel();
        BeanUtils.copyProperties(fuelConsumptionDto, fuelConsumptionModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(fuelConsumptionService.save(fuelConsumptionModel));

    }

    @GetMapping("/get-all-fuel")
    public ResponseEntity<Object> getAllFuelAndGroupByMonth(){
        return ResponseEntity.status(HttpStatus.OK).body(fuelConsumptionService.findAllByFuelType());
    }

}
