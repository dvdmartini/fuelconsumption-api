package com.fuelconsumption.management.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuelconsumption.management.controllers.dtos.FuelConsumptionDto;
import com.fuelconsumption.management.enums.FuelTypeEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author david.martini
 */
@SpringBootTest
@AutoConfigureMockMvc
public class FuelConsumptionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void ShouldCreateNewFuelConsumption() throws Exception {
        FuelConsumptionDto fuelConsumptionDto = new FuelConsumptionDto();
        fuelConsumptionDto.setFuelType(FuelTypeEnum.DIESEL);
        fuelConsumptionDto.setDate(LocalDate.now());
        fuelConsumptionDto.setVolume(25.0);
        fuelConsumptionDto.setValue(2.5);
        mockMvc.perform(post("/fuel-consumption")
                .content(mapper.writeValueAsString(fuelConsumptionDto))
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    public void ShouldNotCreateNewFuelConsumptionMissingFuelType() throws Exception {
        FuelConsumptionDto fuelConsumptionDto = new FuelConsumptionDto();
        fuelConsumptionDto.setFuelType(null);
        fuelConsumptionDto.setDate(LocalDate.now());
        fuelConsumptionDto.setVolume(25.0);
        fuelConsumptionDto.setValue(2.5);
        mockMvc.perform(post("/fuel-consumption")
                .content(mapper.writeValueAsString(fuelConsumptionDto))
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());

    }

    @Test
    public void ShouldNotCreateNewFuelConsumptionMissingDate() throws Exception {
        FuelConsumptionDto fuelConsumptionDto = new FuelConsumptionDto();
        fuelConsumptionDto.setFuelType(FuelTypeEnum.DIESEL);
        fuelConsumptionDto.setDate(null);
        fuelConsumptionDto.setVolume(25.0);
        fuelConsumptionDto.setValue(2.5);
        mockMvc.perform(post("/fuel-consumption")
                .content(mapper.writeValueAsString(fuelConsumptionDto))
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());

    }

    @Test
    public void ShouldNotCreateNewFuelConsumptionMissingVolume() throws Exception {
        FuelConsumptionDto fuelConsumptionDto = new FuelConsumptionDto();
        fuelConsumptionDto.setFuelType(FuelTypeEnum.DIESEL);
        fuelConsumptionDto.setDate(LocalDate.now());
        fuelConsumptionDto.setVolume(null);
        fuelConsumptionDto.setValue(2.5);
        mockMvc.perform(post("/fuel-consumption")
                .content(mapper.writeValueAsString(fuelConsumptionDto))
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());

    }

    @Test
    public void ShouldNotCreateNewFuelConsumptionMissingFuelValue() throws Exception {
        FuelConsumptionDto fuelConsumptionDto = new FuelConsumptionDto();
        fuelConsumptionDto.setFuelType(FuelTypeEnum.DIESEL);
        fuelConsumptionDto.setDate(LocalDate.now());
        fuelConsumptionDto.setVolume(25.0);
        fuelConsumptionDto.setValue(null);
        mockMvc.perform(post("/fuel-consumption")
                .content(mapper.writeValueAsString(fuelConsumptionDto))
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());

    }

    @Test
    public void ShouldGetAllFuelConsumptionGroupByMonth() throws Exception {
        mockMvc.perform(get("/fuel-consumption/get-all-fuel"))
                .andExpect(status().isOk());

    }

    @Test
    public void ShouldGetErrorWithWrongUrl() throws Exception {
        mockMvc.perform(get("/fuel-consumption/get-all-fuels"))
                .andExpect(status().isNotFound());

    }

}