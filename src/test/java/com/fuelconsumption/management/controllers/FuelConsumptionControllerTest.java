package com.fuelconsumption.management.controllers;

import com.fuelconsumption.management.controllers.dtos.FuelConsumptionDto;
import com.fuelconsumption.management.models.FuelConsumptionModel;
import com.fuelconsumption.management.services.FuelConsumptionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

/**
 * @author david.martini
 */
@SpringBootTest
public class FuelConsumptionControllerTest {

    @Mock
    private FuelConsumptionService fuelConsumptionService;

    @InjectMocks
    private FuelConsumptionController fuelConsumptionController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void ShouldCreateNewFuelConsumption() {

    FuelConsumptionDto fuelConsumptionDto = new FuelConsumptionDto();
        fuelConsumptionDto.setFuelType(null);
        fuelConsumptionDto.setDate(LocalDate.now());
        fuelConsumptionDto.setVolume(25.0);
        fuelConsumptionDto.setValue(2.5);


        FuelConsumptionModel fuelConsumptionModel = new FuelConsumptionModel();

        BeanUtils.copyProperties( fuelConsumptionDto, fuelConsumptionModel);
        Mockito.when(fuelConsumptionService.save(fuelConsumptionModel)).thenReturn(fuelConsumptionModel);
        ResponseEntity<Object> fuelConsumptionReturn = fuelConsumptionController.saveFuelConsumption(fuelConsumptionDto);

        Assertions.assertEquals(HttpStatus.CREATED, fuelConsumptionReturn.getStatusCode());

    }

//    @Test
//    public void ShouldNotCreateNewFuelConsumptionMissingFuelType() {
//        fuelConsumptionDto.setFuelType(null);
//
//        FuelConsumptionModel fuelConsumptionModel = new FuelConsumptionModel();
//
//        BeanUtils.copyProperties(fuelConsumptionDto, fuelConsumptionModel);
//        Mockito.when(fuelConsumptionService.save(fuelConsumptionModel)).thenReturn(fuelConsumptionModel);
//        ResponseEntity<Object> fuelConsumptionReturn = fuelConsumptionController.saveFuelConsumption(fuelConsumptionDto);
//
//        Assertions.assertEquals(HttpStatus.BAD_REQUEST, fuelConsumptionReturn.getStatusCode());
//
//    }

}