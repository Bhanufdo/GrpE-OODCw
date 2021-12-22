package com.company;

public class MiniLorry extends Vehicle {

        private int maxWeightCapacity;

        MiniLorry(String numPlateID, String vehicleBrand, DateTime enteringTime, int maxWeightCapacity){
            super(numPlateID, vehicleBrand, enteringTime);
            this.maxWeightCapacity = maxWeightCapacity;
        }

        //setter & getter for maxWeightCapacity
        public void setMaxWeightCapacity(int maxWeightCapacity){
            this.maxWeightCapacity = maxWeightCapacity;
        }

        public int getMaxWeightCapacity(){
            return maxWeightCapacity;
        }
    }

