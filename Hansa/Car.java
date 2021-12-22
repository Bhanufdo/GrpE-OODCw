package com.company;


public class Car extends Vehicle{
    private String carColor;
    private String carType;

    public Car(String numPlateID, String vehicleBrand, DateTime enteringTime, String carColor, String carType) {
        super(numPlateID, vehicleBrand, enteringTime);
        this.carColor = carColor;
        this.carType = carType;
    }

    public Car(String numPlateID, String vehicleBrand, DateTime enteringTime, String carColor) {
        super(numPlateID, vehicleBrand, enteringTime, carColor);
    }

    //setters & getters
    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarColor() {
        return carColor;
    }
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
}

