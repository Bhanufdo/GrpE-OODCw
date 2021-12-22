package com.company;

public class MiniBus extends Vehicle{

    private int passengerCapacity;

    MiniBus(String numPlateID, String vehicleBrand, DateTime enteringTime, int passengerCapacity){
        super(numPlateID, vehicleBrand, enteringTime);
        this.passengerCapacity = passengerCapacity;
    }

    //setter & getter for numberOfPassengers
    public void setPassengerCapacity(int passengerCapacity){
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity(){
        return passengerCapacity;
    }
}

