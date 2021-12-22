package com.company;


abstract public class Vehicle {
    private String numPlateID;
    private String vehicleBrand;
    private DateTime enteringTime;

    // constructor
    Vehicle(String numPlateID, String vehicleBrand, DateTime enteringTime) {
        this.numPlateID = numPlateID;
        this.vehicleBrand = vehicleBrand;
        this.enteringTime = enteringTime;
    }



    public Vehicle(String numPlateID, String vehicleBrand, DateTime enteringTime, String carColor) {

    }

    // setter & getters

    public String getNumPlateID() {
        return numPlateID;
    }

    public void setNumPlateID(String id) {
        this.numPlateID = id;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getEnteringTime() {
        return enteringTime.getHours() + " : " + enteringTime.getMinutes() + " " + enteringTime.getDay() + " / " + enteringTime.getMonth()
                + " / " + enteringTime.getYear();
    }

    public void setEnteringTime(DateTime enteringTime) {

        this.enteringTime = enteringTime;
    }

    public DateTime getEntryTimeObject() {

        return enteringTime;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "numPlateID='" + numPlateID + '\'' +
                ", vehicleBrand='" + vehicleBrand + '\'' +
                ", enteringTime=" + enteringTime +
                '}';
    }
}

