package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class IITCarParkManager implements CarParkManager {
    private Vehicle[] vehicleParkingSpaces = new Vehicle[60];//parking space array to store vehicle objects
    static Scanner input = new Scanner(System.in);
    private Vehicle lastEntry = null;//to find the last entered vehicle

    private ArrayList<Integer> vehicleOrderList = new ArrayList<Integer>();//is used to have the index of the vehicles
    //which are currently parked in the last in First out approach
    private ArrayList<Vehicle> deletedTempVehicleList = new ArrayList<Vehicle>();//stores the vehicle object which had left the parking space

    public static void main(String[] args) {
        System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(" |***********  WELCOME TO THE  ***********|");
        System.out.println(" |********- IIT CAR PARK MANAGER -********|");
        System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        MainMenu();   //redirected to the MainMenu method
    }


    public static void MainMenu() {
        CarParkManager carParkObject = new IITCarParkManager();
        while (true) {//infinity loop
            System.out.println("");
            System.out.println("1. Add a vehicle to the parking Space");
            System.out.println("2. Delete a vehicle from the parking Space");
            System.out.println("3. Display all vehicles parked currently in the park");
            System.out.println("4. Display statistics of the car park");
            System.out.println("5. Display vehicles of a specific Day");
            System.out.println("Press Q to Quit the Program.");
            System.out.print("Enter Selection: ");

            String userInput = input.next();// prompted for input and stored in
            // the userInput variable
            System.out.println();

            switch (userInput.toLowerCase()) {
                case "1":
                    carParkObject.addVehicle();
                    break;
                case "2":
                    carParkObject.deleteVehicle();
                    break;
                case "3":
                    carParkObject.printCurrentList();
                    break;
                case "4":
                    carParkObject.printStatistics();
                    break;
                case "5":
                    carParkObject.printByDay();
                    break;
                case "q":
                    System.exit(0);// terminates the program
                    break;
                default:
                    System.err.println("\n**Please, Enter a Valid Input**");
                    System.out.println();
            }
        }
    }

    // Override
    public void addVehicle() {
        boolean typeVal = false;
        String typeOfVehicle = ""; //this string variable holding the type of vehicle
        while (!typeVal) { // loop to make sure only valid type is being entered
            System.out.print("Enter vehicle type(car/bike/van/minibus/minilorry): ");
            typeOfVehicle = input.next();
            if (typeOfVehicle.equalsIgnoreCase("car") || typeOfVehicle.equalsIgnoreCase("van")
                    || typeOfVehicle.equalsIgnoreCase("bike")||typeOfVehicle.equalsIgnoreCase("minibus")
                    ||typeOfVehicle.equalsIgnoreCase("minilorry")) {
                typeVal = true;
            } else {
                System.err.println("\n**Please, Enter a Valid Input**");
                System.out.println("");
            }
        }

        int checkFreeSpace = checkForFreeSpaces(typeOfVehicle);
        if (checkFreeSpace == -1) {
            System.out.println("**Parking Slot Full, No free slot available!**");
            return;
        }

        System.out.print("Enter Vehicle's Number Plate ID : ");
        String numPlateID = input.next();
        System.out.print("Enter Vehicle's Brand name (Nissan,Toyota etc.): ");
        String vehicleBrand = input.next();
        int hours;
        int minutes;
        int date;
        int month;
        int year;

        do {
            System.out.print(
                    "Enter the Date & Time (HH)(MM)(DD)(MM)(YYYY): ");
            hours = input.nextInt();
            minutes = input.nextInt();
            date = input.nextInt();
            month = input.nextInt();
            year = input.nextInt();
        } while (hours < 0 || hours > 24 || minutes < 0 || minutes > 60 || date < 0 || date > 31 || month < 0 || month > 12
                || year <= 2020); // Date & Time Validation

        DateTime enteringTime = new DateTime(hours, minutes, date, month, year);
        vehicleOrderList.add(checkFreeSpace);

        switch (typeOfVehicle) {
            case "car":
                System.out.print("Enter the colour of car: ");
                while (!input.hasNext()) {
                    System.err.print("Please, Enter a valid colour : ");
                    input.next();// validating user input
                }
                String carColour = input.next();
                System.out.print("Enter car type (sedan/hatchback etc.): ");
                String carType = input.next();
                vehicleParkingSpaces[checkFreeSpace] = new Car(numPlateID, vehicleBrand, enteringTime, carColour);
                break;

            case "van":
                System.out.print("Enter Number Of Seats: ");
                while (!input.hasNextInt()) {
                    System.err.print("Please, Enter an integer value for Number of seats : ");
                    input.next();// validating user input
                }
                int numberOfSeats = input.nextInt();
                vehicleParkingSpaces[checkFreeSpace] = new Van(numPlateID, vehicleBrand, enteringTime, numberOfSeats);
                vehicleParkingSpaces[checkFreeSpace + 1] = new Van(numPlateID, vehicleBrand, enteringTime, numberOfSeats);
                break;

            case "minibus":
                System.out.print("Enter Number Of Passengers can be travelled: ");
                while (!input.hasNextInt()) {
                    System.err.print("Please, Enter an integer value for Number of passengers : ");
                    input.next();// validating user input
                }
                int passengerCapacity = input.nextInt();
                vehicleParkingSpaces[checkFreeSpace] = new MiniBus(numPlateID, vehicleBrand, enteringTime, passengerCapacity);
                vehicleParkingSpaces[checkFreeSpace +1] = new MiniBus(numPlateID, vehicleBrand, enteringTime, passengerCapacity);
                vehicleParkingSpaces[checkFreeSpace +2] = new MiniBus(numPlateID, vehicleBrand, enteringTime, passengerCapacity);
                break;

            case "minilorry":
                System.out.print("Enter Maximum Weight can be loaded: ");
                while (!input.hasNextInt()) {
                    System.err.print("Please, Enter an integer value for Maximum weight : ");
                    input.next();// validating user input
                }
                int maxWeightCapacity = input.nextInt();
                vehicleParkingSpaces[checkFreeSpace] = new MiniLorry(numPlateID, vehicleBrand, enteringTime, maxWeightCapacity);
                vehicleParkingSpaces[checkFreeSpace +1] = new MiniLorry(numPlateID, vehicleBrand, enteringTime, maxWeightCapacity);
                vehicleParkingSpaces[checkFreeSpace +2] = new MiniLorry(numPlateID, vehicleBrand, enteringTime, maxWeightCapacity);
                break;

            case "bike":
                System.out.print("Enter engine capacity (in cc): ");
                while (!input.hasNextInt()) {
                    System.err.print("Please, Enter a integer value for engine capacity : ");
                    input.next();// validating user input based on string value
                }
                int engineCapacity = input.nextInt();
                vehicleParkingSpaces[checkFreeSpace] = new MotorBike(numPlateID, vehicleBrand, enteringTime, engineCapacity);
                break;
        }
        lastEntry = vehicleParkingSpaces[checkFreeSpace];
        System.out.println("");
        System.out.println(" The Vehicle has parked Successfully! ");
        System.out.println(" No of free spaces remaining is " + totalOfSlots());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public int checkForFreeSpaces(String VehicleType) {
        for (int i = 0; i < 60; i++) {
            if (vehicleParkingSpaces[i] == null) {
                if (VehicleType.equalsIgnoreCase("van")) {
                    if (vehicleParkingSpaces[i + 1] == null) {
                        return i;
                    }

                }
                else if (VehicleType.equalsIgnoreCase("minibus")) {
                    if ((vehicleParkingSpaces[i + 1] == null) && (vehicleParkingSpaces[i + 2]) == null){
                        return i;
                    }
                }
                else if (VehicleType.equalsIgnoreCase("minilorry")) {
                    if((vehicleParkingSpaces[i + 1] == null) && (vehicleParkingSpaces[i + 2]) == null){
                        return i;
                    }
                }
                else { // since one slot is sufficient for cars and bikes
                        return i;
                    }
                }
            }
            return -1; // if there is no free slots
        }


    public int totalOfSlots() {
        int number = 0;
        for (int i = 0; i < 60; i++) {
            if (vehicleParkingSpaces[i] == null) {
                ++number;
            }
        }
        return number;
    }

    // Override
    public void deleteVehicle() {
        boolean foundFlag = false;
        int i;
        System.out.print("Enter Number Plate ID of the vehicle to be Deleted: ");
        String id = input.next();

        for (i = 0; i < 60; i++) { // loop to find the element index
            if (vehicleParkingSpaces[i] != null) {
                if (vehicleParkingSpaces[i].getNumPlateID().equalsIgnoreCase(id)) {
                    foundFlag = true;
                    break; // end for loop once the value is found
                }
            }
        }
        if (!foundFlag) {
            System.err.println(" Invalid Vehicle Number Plate ID, Please Try Again!!");

            return;
        }
        // to display the vehicle leaving
        String VehicleType = vehicleParkingSpaces[i].getClass().getSimpleName();
        System.out.println("A " + VehicleType + " left the Vehicle Park.");
        deletedTempVehicleList.add(vehicleParkingSpaces[i]);
        if (VehicleType.equalsIgnoreCase("van")) {
            // to physically remove the element from the vehicle array
            vehicleParkingSpaces[i] = null;
            vehicleParkingSpaces[i + 1] = null;
        }
        else if (VehicleType.equalsIgnoreCase("minibus")) {
            vehicleParkingSpaces[i] = null;
            vehicleParkingSpaces[i + 1] = null;
            vehicleParkingSpaces[i + 2] = null;
        }
        else if (VehicleType.equalsIgnoreCase("minilorry")) {
            vehicleParkingSpaces[i] = null;
            vehicleParkingSpaces[i + 1] = null;
            vehicleParkingSpaces[i + 2] = null;
        }
        else {
            vehicleParkingSpaces[i] = null;
        }
        vehicleOrderList.remove(i);

    }

    // Override
    public void printStatistics() {
        printVehiclePercentage(); // method call of the method which prints
        // vehicle percentage
        printFirstAndLastVehicle();
    }

    private void printVehiclePercentage() {
        int car = 0;
        int van = 0;
        int bike = 0;
        int minibus = 0;
        int minilorry = 0;
        int total = 0;
        String vehicleType;

        for (int i = 0; i < 60; i++) { // loop to find the element index
            if (vehicleParkingSpaces[i] != null) { // if an element is not empty
                vehicleType = vehicleParkingSpaces[i].getClass().getSimpleName();
                ++total;
                switch (vehicleType) { // to increment each vehicle type counter
                    case "Car":
                        ++car;
                        break;
                    case "Van":
                        ++van;
                        ++i; // to skip the next space as well since a van occupied 2 spaces.
                        break;
                    case "MiniBus":
                        ++minibus;
                        ++i;
                        ++i; // to skip the next spaces as well since a minibus occupied 3 spaces.
                        break;
                    case "MiniLorry":
                        ++minilorry;
                        ++i;
                        ++i; // to skip the next spaces as well since a minilorry occupied 3 spaces.
                        break;
                    case "Motorbike":
                        ++bike;
                        break;
                }
            }
        }
        // Percentage calculation
        int carPercentage;
        int vanPercentage;
        int minibusPercentage;
        int minilorryPercentage;
        int bikePercentage;

        if (total == 0) { // if car park is empty(to avoid arithmeticException)
            carPercentage = 0;
            vanPercentage = 0;
            bikePercentage = 0;
            minibusPercentage = 0;
            minilorryPercentage = 0;
        }
        else {
            carPercentage = (car * 100 / total);
            vanPercentage = (van * 100 / total);
            minibusPercentage = (minibus * 100 / total);
            minilorryPercentage = (minilorry * 100 / total);
            bikePercentage = (bike * 100 / total);
        }

        System.out.println("Currently Parked Vehicle percentage");
        System.out.println("------------------------------------");
        System.out.println("         CAR       : " + carPercentage + "%");
        System.out.println("         VAN       : " + vanPercentage + "%");
        System.out.println("         MINI BUS  : " + minibusPercentage + "%");
        System.out.println("         MINI LORRY: " + minilorryPercentage + "%");
        System.out.println("         BIKE      :" + bikePercentage + "%");
        System.out.println("");
    }

    private void printFirstAndLastVehicle() {
        // to find the vehicle that was parked first.
        if (vehicleOrderList.size() != 0) {
            System.out.println("First vehicle Which was parked");
            System.out.println("-------------------------------");
            System.out.println("ID : " + vehicleParkingSpaces[vehicleOrderList.get(0)].getNumPlateID());
            System.out.println("Type : " + vehicleParkingSpaces[vehicleOrderList.get(0)].getClass().getSimpleName());
            System.out.println("Entry time : " + vehicleParkingSpaces[vehicleOrderList.get(0)].getEnteringTime());
        } else {
            System.out.println("No vehicle in the parking currently");
        }

        // to find the last vehicle that entered the parking slot.
        if (lastEntry != null) {
            System.out.println("Last vehicle which was parked");
            System.out.println("------------------------------");
            System.out.println("ID : " + lastEntry.getNumPlateID());
            System.out.println("Type : " + lastEntry.getClass().getSimpleName());
            System.out.println("Entry time : " + lastEntry.getEnteringTime());
        } else {
            System.out.println("**The Parking space is Empty no vehicles are parked currently**");
        }

    }

    // Override
    public void printCurrentList() {
        if (vehicleOrderList.size() == 0) {
            System.out.println("No vehicles are currently available in the parking space");
        }
        for (int i = (vehicleOrderList.size() - 1); i >= 0; i--) {
            int index = vehicleOrderList.get(i);
            System.out.println("Slot " + (index + 1) + " is Occupied.");
            System.out.println("ID plate: " + vehicleParkingSpaces[index].getNumPlateID());
            System.out.println("Entry time: " + vehicleParkingSpaces[index].getEnteringTime());
            System.out.println("Type: " + vehicleParkingSpaces[index].getClass().getSimpleName());
            System.out.println("");
        }

    }

    // Override
    public void printByDay() {
        boolean isValidFlag = true;
        int date = 0, month = 0, year = 0;
        do {
            System.out.print("Enter DayDay(DD) MonthMonth(MM) YearYearYearYear(YYYY) to search for Vehicles: ");
            try {
                date = Integer.parseInt(input.next());
                month = Integer.parseInt(input.next());
                year = Integer.parseInt(input.next());
                if (date > 0 || date < 31 || month > 0 || month < 12 || year == 2021) {
                    isValidFlag = true;
                } else {
                    isValidFlag = false;
                    System.err.println("Invalid Date input, Please Try Again");
                }
            } catch (Exception ex) {
                System.err.println("Invalid input, Please Try Again");
                isValidFlag = false;
            }
        } while (!isValidFlag);
        int count = 0;
        for (int i = 0; i < 60; i++) {
            if (vehicleParkingSpaces[i] != null) {
                int objectDate = vehicleParkingSpaces[i].getEntryTimeObject().getDay();
                int objectMonth = vehicleParkingSpaces[i].getEntryTimeObject().getMonth();
                int objectYear = vehicleParkingSpaces[i].getEntryTimeObject().getYear();
                if ((objectDate == date) && (objectMonth == month) && (objectYear == year)) {
                    count++;
                    String type = vehicleParkingSpaces[i].getClass().getSimpleName();
                    String id = vehicleParkingSpaces[i].getNumPlateID();
                    System.out.println(count + " : " + type + " Number Plate ID No : " + id);
                    if (type.equalsIgnoreCase("van")) {
                        i++;
                    }
                    if (type.equalsIgnoreCase("minibus")) {
                        i++;
                        i++;
                    }
                    if (type.equalsIgnoreCase("minilorry")) {
                        i++;
                        i++;
                    }

                }
            }
        }
        for (int y = 0; y < deletedTempVehicleList.size(); y++) {
            System.out.println("im here 3");
            int objDate = deletedTempVehicleList.get(y).getEntryTimeObject().getDay();
            int objMonth = deletedTempVehicleList.get(y).getEntryTimeObject().getMonth();
            int objYear = deletedTempVehicleList.get(y).getEntryTimeObject().getYear();
            if ((objDate == date) && (objMonth == month) && (objYear == year)) {
                count++;
                String type = deletedTempVehicleList.get(y).getClass().getSimpleName();
                String id = deletedTempVehicleList.get(y).getNumPlateID();
                System.out.println(count + " : " + type + " ID No : " + id);
                if (type.equalsIgnoreCase("van")) {
                    y++;
                }
                if (type.equalsIgnoreCase("minibus")) {
                    y++;
                    y++;
                }
                if (type.equalsIgnoreCase("minilorry")) {
                    y++;
                    y++;
                }
            }
        }

        if (count == 0) {
            System.out.println("**No vehicles were currently parked on " + date + "-" + month + "-" + year + "**");
        }
    }

}

