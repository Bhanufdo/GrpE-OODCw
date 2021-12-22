package com.company;


public class Van extends Vehicle{

    private int numberOfSeats;

    Van(String numPlateID, String vehicleBrand, DateTime enteringTime, int numberOfSeats){
        super(numPlateID, vehicleBrand, enteringTime);
        this.numberOfSeats = numberOfSeats;
    }

    //setter & getter for numberOfSeats
    public void setNumberOfSeats(int numberOfSeats){
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats(){
        return numberOfSeats;
    }
}

