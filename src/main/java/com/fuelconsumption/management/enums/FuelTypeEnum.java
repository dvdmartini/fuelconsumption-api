package com.fuelconsumption.management.enums;

/**
 * @author david.martini
 */
public enum FuelTypeEnum {
    DIESEL("Diesel"),
    GASOLINE("Gasoline"),
    ALCOHOL("Alcohol");

    private final String describe;

    FuelTypeEnum(String describe) {
        this.describe = describe;
    }

    public String getDescribe() {
        return describe;
    }
}
