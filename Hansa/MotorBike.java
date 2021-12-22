package com.company;


public class MotorBike extends Vehicle {
    protected int engineCapacity;

    MotorBike(String numPlateID, String vehicleBrand, DateTime entryTime, int engineCapacity) {
        super(numPlateID, vehicleBrand, entryTime);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {

        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
}

