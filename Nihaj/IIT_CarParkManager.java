import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public  class IIT_CarParkManager implements CarParkManager {
    Scanner sc;
    static int parkingSlotCount = 60;
    static int carCounter;
    static int vanCounter;
    static int motorbikeCounter;
    static int miniLorryCounter;
    static int miniBusCounter;
    static EmptyParkingSlot emptySlot = new EmptyParkingSlot("Empty");
    static List<Vehicle> slots = new ArrayList();
    public Vehicle vehicle;

    public IIT_CarParkManager() {
        this.sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("\n-------------------------------------------------------------------------------------------- ");
        System.out.println("\t                 IIT Car Park Management System");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("            # The IIT car park is consist with 6 floors."                  );
        System.out.println("            # Each floor have 60 parking spaces for park the vehicle."     );
        System.out.println("            # Cars, Vans, Minibus, Mini lorries and Motorbikes can park in the ground floor.");
        System.out.println("            # The first and second floor can accommodate Cars,Vans and MotorBikes.");
        System.out.println("            # only the cars allows to park in the upper floors.");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println();


        IIT_CarParkManager iit_carParkManager = new IIT_CarParkManager();
        iit_carParkManager.displayMainMenu();
    }

    public void displayMainMenu() {
        try {
            this.sc = new Scanner(System.in);
            IIT_CarParkManager iit_carParkManager = new IIT_CarParkManager();
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  Main Menu ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~~ ~ ~ ~ ~ ~ ");
            System.out.println();
            System.out.println("1. Add a new Vehicle");
            System.out.println("2. Delete a Vehicle");
            System.out.println("3. Print a list of vehicle currently parked");
            System.out.println("4. The percentage of Cars, Vans, MotorBike, MiniBus and the MiniLorry which are currently parked.");
            System.out.println("5. Display the longest Parked Vehicle");
            System.out.println("6. Display the Last Parked Vehicle");
            System.out.println("7. Parking Charges");
            System.out.println("8. Parking Logs");
            System.out.println("0. Exit Program");
            System.out.println();
            System.out.print("Please enter your option:");
            int SelectedOption = this.sc.nextInt();
            switch (SelectedOption) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    iit_carParkManager.addVehicle();
                    break;
                case 2:
                    iit_carParkManager.deleteVehicle();
                    break;
                case 3:
                    iit_carParkManager.printVehicleList();
                    break;
                case 4:
                    iit_carParkManager.calculatePercentages();
                    break;
                case 5:
                    iit_carParkManager.printLongestParked();
                    break;
                case 6:
                    iit_carParkManager.printLastParked();
                    break;
                case 7:
                    iit_carParkManager.calculateParkingCharges();
                    break;
                case 8:
                    iit_carParkManager.displayParkingLog();
                    break;
                default:
                    System.err.println("\nYou have selected an invalid option !");
                    System.out.println();
                    this.displayMainMenu();
            }
        } catch (Exception e) {
            System.out.println("\nInvalid option!");
            this.sc.hasNextInt();
            this.displayMainMenu();
        }

    }

    public void addVehicle() {
        try {
            this.sc = new Scanner(System.in);
            System.out.println();
            System.out.println("****************** Add a new vehicle to the System ****************** \n ");
            this.trackFreeSlots();
            if (parkingSlotCount <= 0) {
                return;
            }

            System.out.println("\t 1 - Car");
            System.out.println("\t 2 - Van");
            System.out.println("\t 3 - MotorBike");
            System.out.println("\t 4 - MiniLorry");
            System.out.println("\t 5 - MiniBus");
            System.out.print("Please select the type of the Vehicle: ");
            System.out.println();
            int selectedVehicleType = this.sc.nextInt();
            DateTime dateTime = new DateTime();
            switch (selectedVehicleType) {
                case 1:
                    Car car = new Car();
                    car.setColorOfCar("Car");
                    System.out.println("\n\t********************** Add a Car to the park ********************** ");
                    System.out.println("\nPlease enter the Vehicle Number Plate number of the Car (EE-ABCD-1234)");
                    car.setVehicleNumberPlate(this.sc.next());
                    System.out.println("Please enter the Brand of the Car");
                    car.setBrandOfVehicle(this.sc.next());
                    this.timeValidator(dateTime);
                    this.dateValidator(dateTime);
                    System.out.println("Please enter the Color of the Car");
                    car.setColorOfCar(this.sc.next());
                    car.setDateTime(dateTime);
                    slots.add(car);
                    --parkingSlotCount;
                    ++carCounter;
                    this.fileWriting(car);
                    this.returnToMenu();
                    break;
                case 2:
                    if (parkingSlotCount > 2) {
                        Van van = new Van();
                        van.setTypeOfVehicle("Van");
                        System.out.println("\n\t********************* Add a van to the park *********************** ");
                        System.out.println("\nPlease enter the Vehicle Number Plate number of the Van (EE-ABCD-1234)");
                        van.setVehicleNumberPlate(this.sc.next());
                        System.out.println("Please enter the Brand of the Van");
                        van.setBrandOfVehicle(this.sc.next());
                        this.timeValidator(dateTime);
                        this.dateValidator(dateTime);
                        System.out.println("Please enter the gear type of the Van (Auto/Manual)");
                        van.setGearType(this.sc.next());
                        van.setDateTime(dateTime);
                        slots.add(van);
                        --parkingSlotCount;
                        --parkingSlotCount;
                        ++vanCounter;
                        this.fileWriting(van);
                        this.returnToMenu();
                    } else {
                        System.out.println("Sorry! There's no space available for a Van right now.");
                        this.returnToMenu();
                    }
                    break;
                case 3:
                    MotorBike motorbike = new MotorBike();
                    motorbike.setTypeOfVehicle("Motorbike");
                    System.out.println("\n\t******************* Add a Motorbike to the park *************************");
                    System.out.println("\nPlease enter the Vehicle Number Plate number of the Motorbike (EE-ABC-1234)");
                    motorbike.setVehicleNumberPlate(this.sc.next());
                    System.out.println("Please enter the Brand of the Motorbike");
                    motorbike.setBrandOfVehicle(this.sc.next());
                    this.timeValidator(dateTime);
                    this.dateValidator(dateTime);
                    System.out.println("Please enter the Engine Capacity of the Motorbike");
                    motorbike.setEngineCC(this.sc.nextInt());
                    motorbike.setDateTime(dateTime);
                    slots.add(motorbike);
                    --parkingSlotCount;
                    ++motorbikeCounter;;

                     this.fileWriting(motorbike);
                    this.returnToMenu();
                    break;
                case 4:
                    if (parkingSlotCount > 3) {
                        MiniBus miniBus = new MiniBus();
                        miniBus.setNumberOfSeats("MiniBus");
                        System.out.println("\n\t********************** Add a MiniBus to the park ***********************");
                        System.out.println("\nPlease enter the Vehicle Number Plate number of the MiniBus (EE-ABCD-1234)");
                        miniBus.setVehicleNumberPlate(this.sc.next());
                        System.out.println("Please enter the Brand of the MiniBus");
                        miniBus.setBrandOfVehicle(this.sc.next());
                        this.timeValidator(dateTime);
                        this.dateValidator(dateTime);
                        System.out.println("Please enter the number of seats of the MiniBus(54/60)");
                        miniBus.setNumberOfSeats(this.sc.next());
                        miniBus.setDateTime(dateTime);
                        slots.add(miniBus);
                        --parkingSlotCount;
                        --parkingSlotCount;
                        --parkingSlotCount;
                        ++miniBusCounter;
                        this.fileWriting(miniBus);
                        this.returnToMenu();
                    } else {
                        System.out.println("Sorry! There's no space available for a MiniBus right now.");
                        this.returnToMenu();
                    }
                    break;
                case 5:
                    if (parkingSlotCount > 3) {
                        MiniLorry miniLorry = new MiniLorry();
                        miniLorry.setLengthOfVehicle("MiniLorry");
                        System.out.println("\n\t******************** Add a MiniLorry to the park *************************");
                        System.out.println("\nPlease enter the vehicle Number Plate number of the MiniLorry (EE-ABCD-1234)");
                        miniLorry.setVehicleNumberPlate(this.sc.next());
                        System.out.println("Please enter the Brand of the MiniLorry");
                        miniLorry.setBrandOfVehicle(this.sc.next());
                        this.timeValidator(dateTime);
                        this.dateValidator(dateTime);
                        System.out.println("Please enter the length of the MiniLorry (m)");
                        miniLorry.setLengthOfVehicle(this.sc.next());
                        miniLorry.setDateTime(dateTime);
                        slots.add(miniLorry);
                        --parkingSlotCount;
                        --parkingSlotCount;
                        --parkingSlotCount;
                        ++miniLorryCounter;

                        this.fileWriting(miniLorry);
                        this.returnToMenu();
                    } else {
                        System.out.println("Sorry! There's no space available for a miniLorry right now.");
                        this.returnToMenu();
                    }
                    break;
                default:
                    System.out.println("\n Your input is valid. Please try again later.");
                    this.addVehicle();
            }
        } catch (InputMismatchException var5) {
            System.out.println("\nYour input is valid. Please try again later.");
            this.sc.hasNextInt();
            this.addVehicle();
        }

    }

    public void trackFreeSlots() {
        if (parkingSlotCount > 0) {
            if (parkingSlotCount == 1) {
                System.out.println("Great! There is a parking slot remaining");
            } else {
                System.out.println("There are " + parkingSlotCount + " remaining right now. \n");
            }
        } else {
            System.out.println("\nThere are no remaining slots right now. \nThank You.");
        }

    }

    public void deleteVehicle() {
        System.out.println();
        System.out.println("******************* Delete a vehicle ********************* \n ");
        float totalVehicles = (float) (carCounter + vanCounter + motorbikeCounter + miniBusCounter + miniLorryCounter);
        if (totalVehicles == 0.0F) {
            System.out.println("OMG! You cannot do this deletion right now.");
            System.out.println("There are no vehicles in the park right now! Please try again later.");
        } else {
            System.out.println("Vehicle list in the parking\n");
            Iterator var2 = slots.iterator();

            while (var2.hasNext()) {
                Vehicle vehicle = (Vehicle) var2.next();
                String VehicleNumberPlate = vehicle.getVehicleNumberPlate();
                if (VehicleNumberPlate != null) {
                    System.out.println("\t" + VehicleNumberPlate);
                }
            }

            System.out.println("\nPlease select the vehicle you want to delete");

            try {
                String deleteVehicle = this.sc.next();
                String leavingVehicle = ((Vehicle) slots.get(this.getIndexByProperty(deleteVehicle))).getBrandOfVehicle();
                System.out.println("\nA " + leavingVehicle + " is leaving the park right now.");
                if (leavingVehicle.equals("Car")) {
                    ++parkingSlotCount;
                    --carCounter;
                } else if (leavingVehicle.equals("Van")) {
                    ++parkingSlotCount;
                    ++parkingSlotCount;
                    --vanCounter;
                } else if (leavingVehicle.equals("MotorBike")) {
                    ++parkingSlotCount;
                    --motorbikeCounter;
                } else if (leavingVehicle.equals("MiniBus")) {
                    ++parkingSlotCount;
                    ++parkingSlotCount;
                    ++parkingSlotCount;
                    --miniBusCounter;
                } else if (leavingVehicle.equals("MiniLorry")) {
                    ++parkingSlotCount;
                    ++parkingSlotCount;
                    ++parkingSlotCount;
                    --miniLorryCounter;
                }

                slots.remove(this.getIndexByProperty(deleteVehicle));
            } catch (Exception var5) {
            }
        }

        this.returnToMenu();
    }

    private int getIndexByProperty(String yourString) {
        for (int i = 0; i < slots.size(); ++i) {
            if (((Vehicle) slots.get(i)).getVehicleNumberPlate() != null && ((Vehicle) slots.get(i)).getVehicleNumberPlate().equalsIgnoreCase(yourString)) {
                return i;
            }
        }

        System.out.println("\nSorry! There are no vehicles in the park with the specified Vehicle Number plate.\n");
        return -1;
    }

    public void printVehicleList() {
        System.out.println();
        System.out.println("****************** List of Vehicles in the Parking ********************\n ");
        float totalVehiclesCount = (float) (carCounter + vanCounter + motorbikeCounter + miniBusCounter + miniLorryCounter);
        if (totalVehiclesCount == 0.0F) {
            System.out.println("There are no vehicles parked in the park at the moment!");
        } else {
            this.sortArraylist();
            Collections.reverse(slots);
            Iterator var2 = slots.iterator();

            while (var2.hasNext()) {
                Vehicle vehicle = (Vehicle) var2.next();
                System.out.println("Vehicle Number Plate - " + vehicle.getVehicleNumberPlate() + "\nEntrance Date & Time - " + vehicle.getDateTime().getYear() + "-" + vehicle.getDateTime().getMonth() + "-" + vehicle.getDateTime().getDay() + "/" + vehicle.getDateTime().getHour() + ":" + vehicle.getDateTime().getMinute() + ":" + vehicle.getDateTime().getSecond() + "\nThe brand of the vehicle - " + vehicle.getBrandOfVehicle() + "\n\n\n");
            }
        }

        this.returnToMenu();
    }

    public void sortArraylist() {
        Collections.sort(slots, (p1, p2) -> {
            int value = p1.getDateTime().getYear() - p2.getDateTime().getYear();
            if (value == 0) {
                value = p1.getDateTime().getMonth() - p2.getDateTime().getMonth();
            }

            if (value == 0) {
                value = p1.getDateTime().getDay() - p2.getDateTime().getDay();
            }

            if (value == 0) {
                value = p1.getDateTime().getHour() - p2.getDateTime().getHour();
            }

            if (value == 0) {
                value = p1.getDateTime().getMinute() - p2.getDateTime().getMinute();
            }

            if (value == 0) {
                value = p1.getDateTime().getSecond() - p2.getDateTime().getSecond();
            }

            return value;
        });
    }


    public void calculatePercentages() {
        System.out.println();
        System.out.println("::::::::::::::::::::: Percentage of Vehicles in the parking :::::::::::::::::::: \n ");
        float totalVehicles = (float) (carCounter + vanCounter + motorbikeCounter + miniBusCounter + miniLorryCounter);
        if (totalVehicles == 0.0F) {
            System.out.println("There are no vehicles parked in the park just right now!");
        } else {
            float carPercentage = (float) (carCounter * 100) / totalVehicles;
            float vanPercentage = (float) (vanCounter * 100) / totalVehicles;
            float bikePercentage = (float) (motorbikeCounter * 100) / totalVehicles;
            float miniBusPercentage = (float) (miniBusCounter * 100) / totalVehicles;
            float miniLorryPercentage = (float) (miniLorryCounter * 100) / totalVehicles;
            System.out.println("The percentage of parked-Cars are " + carPercentage + "%");
            System.out.println("The percentage of parked-Vans are " + vanPercentage + "%");
            System.out.println("The percentage of parked-Motorbikes are " + bikePercentage + "%");
            System.out.println("The percentage of parked-miniBuses are " + miniBusPercentage + "%");
            System.out.println("The percentage of parked-miniLorry are " + miniLorryPercentage + "%");

        }

        this.returnToMenu();
    }

    public void printLongestParked() {
        System.out.println();
        System.out.println("::::::::::::::::::::::::::: Longest Parked Vehicle :::::::::::::::::::::::: \n ");
        float totalVehicles = (float) (carCounter + vanCounter + motorbikeCounter + miniBusCounter + miniLorryCounter);
        if (totalVehicles == 0.0F) {
            System.out.println("The parking is empty right now! Please try again later.");
        } else {
            this.sortArraylist();
            System.out.println("The vehicle that has been parked longest time - ");
            System.out.println("Vehicle Number Plate - " + ((Vehicle) slots.get(0)).getVehicleNumberPlate());
            System.out.println("The type of the vehicle - " + ((Vehicle) slots.get(0)).getBrandOfVehicle());
            System.out.println("Entry Time - " + ((Vehicle) slots.get(0)).getDateTime().getHour() + ":" + ((Vehicle) slots.get(0)).getDateTime().getMinute() + ":" + ((Vehicle) slots.get(0)).getDateTime().getSecond());
            System.out.println("Entry Date - " + ((Vehicle) slots.get(0)).getDateTime().getYear() + "-" + ((Vehicle) slots.get(0)).getDateTime().getMonth() + "-" + ((Vehicle) slots.get(0)).getDateTime().getDay());
        }

        this.returnToMenu();
    }

    public void printLastParked() {
        System.out.println();
        System.out.println("::::::::::::::::::::::::::: Last Parked Vehicle :::::::::::::::::::::::: \n ");
        float totalVehicles = (float) (carCounter + vanCounter + motorbikeCounter + miniBusCounter + miniLorryCounter);
        if (totalVehicles == 0.0F) {
            System.out.println("The parking is empty right now! Please try again later.");
        } else {
            this.sortArraylist();
            System.out.println("\nThe last vehicle that was parked - ");
            System.out.println("Vehicle Number Plate - " + ((Vehicle) slots.get(slots.size() - 1)).getVehicleNumberPlate());
            System.out.println("The type of the vehicle - " + ((Vehicle) slots.get(slots.size() - 1)).getBrandOfVehicle());
            System.out.println("Entry Time - " + ((Vehicle) slots.get(slots.size() - 1)).getDateTime().getHour() + ":" + ((Vehicle) slots.get(slots.size() - 1)).getDateTime().getMinute() + ":" + ((Vehicle) slots.get(slots.size() - 1)).getDateTime().getSecond());
            System.out.println("Entry Date - " + ((Vehicle) slots.get(slots.size() - 1)).getDateTime().getYear() + "-" + ((Vehicle) slots.get(slots.size() - 1)).getDateTime().getMonth() + "-" + ((Vehicle) slots.get(slots.size() - 1)).getDateTime().getDay());
        }

        this.returnToMenu();
    }
    public void calculateParkingCharges() {
        System.out.println();
        System.out.println("::::::::::::::::::::: Parking Charges ::::::::::::::::::::::: \n ");
        float totalVehicles = (float) (carCounter + vanCounter + motorbikeCounter + miniBusCounter + miniLorryCounter);
        if (totalVehicles == 0.0F) {
            System.out.println("The parking is empty right now! Please try again later.");
        } else {
            while (true) {
                System.out.println("Please enter the current Time in the format of HH:MM:SS");
                String timeString = this.sc.next();
                String[] time = timeString.split(":");
                if (Integer.parseInt(time[0]) >= 24 || Integer.parseInt(time[1]) >= 60 || Integer.parseInt(time[2]) >= 60) {
                    System.out.println("\n Invalid time format. Please try again.\n ");
                }

                if (Integer.parseInt(time[0]) < 24 && Integer.parseInt(time[1]) < 60 && Integer.parseInt(time[2]) < 60) {
                    String[] date;
                    do {
                        System.out.println("Please enter the current Date in the format of YYYY-MM-DD");
                        String dateString = this.sc.next();
                        date = dateString.split("-");
                        if (Integer.parseInt(date[1]) <= 12 && Integer.parseInt(date[2]) <= 31) {
                            if ((int) Math.log10((double) Integer.parseInt(date[0])) + 1 < 4) {
                                System.out.println("\n The year you typed appears to be invalid. Please try again.\n ");
                            }
                        } else {
                            System.out.println("\n Invalid date. Please try again.\n ");
                        }
                    } while ((int) Math.log10((double) Integer.parseInt(date[0])) + 1 < 4 || Integer.parseInt(date[1]) > 12 || Integer.parseInt(date[2]) > 31);

                    System.out.println();
                    String inputTime = date[0] + "-" + date[1] + "-" + date[2] + "T" + time[0] + ":" + time[1] + ":" + time[2] + "Z";
                    long inputMillisecond = this.dateFormatter(inputTime).getTime();
                    System.out.println("\t\t\tParking Charges\n");

                    try {
                        System.out.println("\n\tHow would you like to view the charges?\n");
                        System.out.println("\t1. Whole Car Park \t 2. Specific Vehicle");
                        String leftAlignFormat;
                        long hourlyCost;
                        long dayCost;
                        long vehicleMillisecond;
                        long days;
                        long hours;
                        String vehicleTime;
                        long totalCost;
                        switch (this.sc.nextInt()) {
                            case 1:
                                leftAlignFormat = "| %-17s | %-17d |%n";
                                System.out.format("+~~~~~~~~~~~~~~~~~~~~~~~~+~~~~~~~~~~~~~~~~~~~~~+%n");
                                System.out.format("|  Vehicle Number Plate  |  Total Charge (LKR) |%n");
                                System.out.format("+~~~~~~~~~~~~~~~~~~~~~~~~~+~~~~~~~~~~~~~~~~~~~~+%n");

                                for (
                                        int i = 0;
                                        i < slots.size();
                                        ++i
                                ) {
                                    totalCost = 0;
                                    hourlyCost = 0;
                                    dayCost = 0;
                                    vehicleTime = ((Vehicle) slots.get(i)).getDateTime().getYear() + "-" + ((Vehicle) slots.get(i)).getDateTime().getMonth() + "-" + ((Vehicle) slots.get(i)).getDateTime().getDay() + "T" + ((Vehicle) slots.get(i)).getDateTime().getHour() + ":" + ((Vehicle) slots.get(i)).getDateTime().getMinute() + ":" + ((Vehicle) slots.get(i)).getDateTime().getSecond() + "Z";
                                    vehicleMillisecond = this.dateFormatter(vehicleTime).getTime();
                                    days = this.hourCalculator(inputMillisecond, vehicleMillisecond) / 24;
                                    hours = this.hourCalculator(inputMillisecond, vehicleMillisecond) % 24;
                                    if (days > 0) {
                                        dayCost = days * 3000;
                                    }

                                    if (hours <= 3) {
                                        hourlyCost = hours * 300;
                                    } else if (hours > 3 && hours < 9) {
                                        hourlyCost = (hours - 3) * 400;
                                        hourlyCost += 900;
                                    } else if (hours >= 9) {
                                        hourlyCost = 3000;
                                    }

                                    totalCost = dayCost + hourlyCost;
                                    System.out.format(leftAlignFormat, ((Vehicle) slots.get(i)).getVehicleNumberPlate(), totalCost);
                                }
                                break;
                            case 2:
                                leftAlignFormat = "| %-17s | %-17d |%n";
                                System.out.println("List of Vehicles in the parking right now\n");
                                Iterator var10 = slots.iterator();

                                while (var10.hasNext()) {
                                    Vehicle vehicle = (Vehicle) var10.next();
                                    String ID = vehicle.getVehicleNumberPlate();
                                    if (ID != null) {
                                        System.out.println("\t" + ID);
                                    }
                                }

                                System.out.println("\nPlease select the vehicle you wish the Charges");
                                String checkedVehicle = this.sc.next();

                                try {
                                    System.out.format("+~~~~~~~~~~~~~~~~~~~~~~~+~~~~~~~~~~~~~~~~~~~~~+%n");
                                    System.out.format("| Vehicle Number Plate  |  Total Charge (LKR) |%n");
                                    System.out.format("+~~~~~~~~~~~~~~~~~~~~~~~+~~~~~~~~~~~~~~~~~~~~~+%n");
                                    totalCost = 0L;
                                    hourlyCost = 0L;
                                    dayCost = 0L;
                                    vehicleTime = ((Vehicle) slots.get(this.getIndexByProperty(checkedVehicle))).getDateTime().getYear() + "-" + ((Vehicle) slots.get(this.getIndexByProperty(checkedVehicle))).getDateTime().getMonth() + "-" + ((Vehicle) slots.get(this.getIndexByProperty(checkedVehicle))).getDateTime().getDay() + "T" + ((Vehicle) slots.get(this.getIndexByProperty(checkedVehicle))).getDateTime().getHour() + ":" + ((Vehicle) slots.get(this.getIndexByProperty(checkedVehicle))).getDateTime().getMinute() + ":" + ((Vehicle) slots.get(this.getIndexByProperty(checkedVehicle))).getDateTime().getSecond() + "Z";
                                    vehicleMillisecond = this.dateFormatter(vehicleTime).getTime();
                                    days = this.hourCalculator(inputMillisecond, vehicleMillisecond) / 24L;
                                    hours = this.hourCalculator(inputMillisecond, vehicleMillisecond) % 24L;
                                    if (days > 0L) {
                                        dayCost = days * 3000;
                                    }

                                    if (hours <= 3L) {
                                        hourlyCost = hours * 300;
                                    } else if (hours > 3L && hours < 9L) {
                                        hourlyCost = (hours - 3L) * 400;
                                        hourlyCost += 9L;
                                    } else if (hours >= 9L) {
                                        hourlyCost = 300;
                                    }

                                    totalCost = dayCost + hourlyCost;
                                    System.out.format(leftAlignFormat, ((Vehicle) slots.get(this.getIndexByProperty(checkedVehicle))).getVehicleNumberPlate(), totalCost);
                                } catch (Exception var24) {
                                }
                                break;
                            default:
                                System.out.println("\nInvalid option!");
                                this.displayMainMenu();
                        }
                    } catch (Exception var25) {
                        System.out.println("\nInvalid option!");
                        this.displayMainMenu();
                    }

                    System.out.format("+~~~~~~~~~~~~~~~~~~~+~~~~~~~~~~~~~~~~~~~+%n");
                    System.out.println("\nRates - First 3 hours - LKR 300 per hour , Starting from 4th Hour - LKR 400  per hour\n\n\t NOTE - The maximum charge for any 24 hour periods is LKR 3000");
                    break;
                }
            }
        }

        this.returnToMenu();
    }

    public Date dateFormatter(String dateInString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        Date date = null;

        try {
            date = formatter.parse(dateInString.replaceAll("Z$", "+0000"));
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        return date;
    }

    public long hourCalculator(long inputTime, long vehicleTime) {
        long duration = inputTime - vehicleTime;
        long hours = TimeUnit.MILLISECONDS.toHours(duration);
        return hours;
    }

    public void timeValidator(DateTime dateTime) {
        while (true) {
            try {
                System.out.println("Please enter the entrance Time in the format of HH:MM:SS");
                String timeString = this.sc.next();
                String[] time = timeString.split(":");
                if (Integer.parseInt(time[0]) >= 24 || Integer.parseInt(time[1]) >= 60 || Integer.parseInt(time[2]) >= 60) {
                    System.out.println("\n Invalid time. Please try again.\n ");
                }

                if (Integer.parseInt(time[0]) >= 24 || Integer.parseInt(time[1]) >= 60 || Integer.parseInt(time[2]) >= 60) {
                    continue;
                }

                dateTime.setHour(Integer.parseInt(time[0]));
                dateTime.setMinute(Integer.parseInt(time[1]));
                dateTime.setSecond(Integer.parseInt(time[2]));
            } catch (Exception var4) {
                System.out.println("\nSorry! Wrong time format. Please try again");
                this.addVehicle();
            }

            return;
        }
    }

    public void dateValidator(DateTime dateTime) {
        while (true) {
            try {
                System.out.println("Please enter the entrance Date in the format of YYYY-MM-DD");
                String dateString = this.sc.next();
                String[] date = dateString.split("-");
                if (Integer.parseInt(date[1]) <= 12 && Integer.parseInt(date[2]) <= 31) {
                    if ((int) Math.log10((double) Integer.parseInt(date[0])) + 1 < 4) {
                        System.out.println("\n The year you entered appears to be invalid. Please try again.\n ");
                    }
                } else {
                    System.out.println("\n Invalid date. Please try again.\n ");
                }

                if ((int) Math.log10((double) Integer.parseInt(date[0])) + 1 < 4 || Integer.parseInt(date[1]) > 12 || Integer.parseInt(date[2]) > 31) {
                    continue;
                }

                dateTime.setYear(Integer.parseInt(date[0]));
                dateTime.setMonth(Integer.parseInt(date[1]));
                dateTime.setDay(Integer.parseInt(date[2]));
            } catch (Exception var4) {
                System.out.println("\nSorry! Wrong date format. Please try again");
                this.addVehicle();
            }

            return;
        }
    }


    public void displayParkingLog() {
        System.out.println();
        System.out.println(":::::::::::::: Parking Log :::::::::::::::::: \n ");
        System.out.print("Please enter the specific Day - ");
        int enteredDay = 0;
        int enteredMonth = 0;
        int enteredYear = 0;
        enteredDay = this.sc.nextInt();
        if (enteredDay <= 31) {
            System.out.print("Please enter the specific Month - ");
            enteredMonth = this.sc.nextInt();
            if (enteredMonth <= 12) {
                System.out.print("Please enter the specific Year - ");
                enteredYear = this.sc.nextInt();
            } else {
                System.out.println("Invalid month! Please try again.");
                this.displayParkingLog();
            }
        } else {
            System.out.println("Invalid date! Please try again.");
            this.displayParkingLog();
        }

        System.out.println("");
        String fileName = enteredYear + "-" + enteredMonth + "-" + enteredDay + "File.txt";
        fileReading(fileName);
        this.returnToMenu();
    }

    public void fileWriting(Vehicle vehicle) {
        try {
            int parkedYear = vehicle.getDateTime().getYear();
            int parkedMonth = vehicle.getDateTime().getMonth();
            int parkedDay = vehicle.getDateTime().getDay();
            String fileName = parkedYear + "-" + parkedMonth + "-" + parkedDay + "File.txt";
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(vehicle.toString());
            bw.newLine();
            bw.close();
        } catch (IOException var9) {
            System.out.println("Sorry! The program could not locate the text file");
        }

    }



    public static void fileReading(String fileName) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(fileName));
            if (!isEmptyFile(fileName)) {
                System.out.println("The list of vehicles parked on " + fileName + " (YYYY/MM/DD) \n");
                String leftAlignFormat = "| %-13s | %-13s | %-16s | %-15s | %n";
                System.out.format("+---------------+---------------+----------------------+-----------------+%n");
                System.out.format("|  Parked Date  |  Parked Time  | Vehicle Number Plate |  Vehicle Brand  |%n");
                System.out.format("+---------------+---------------+----------------------+-----------------+%n");

                String currentLine;
                while ((currentLine = br.readLine()) != null) {
                    String[] lineParts = currentLine.split("/", -1);
                    String date = lineParts[0];
                    String time = lineParts[1];
                    String id = lineParts[2];
                    String brand = lineParts[3];
                    System.out.format(leftAlignFormat, date, time, id, brand);
                }

                System.out.format("+---------------+---------------+------------------+-----------------+%n");
            } else {
                System.out.println("No vehicle was parked on " + fileName);
            }
        } catch (IOException var17) {
            System.out.println("\nSorry! The program could not locate the text file");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException var16) {
                System.out.println("\nOops! Something went wrong.");
            }

        }

    }

    static boolean isEmptyFile(String source) {
        try {
            Iterator var1 = Files.readAllLines(Paths.get(source)).iterator();

            while (var1.hasNext()) {
                String line = (String) var1.next();
                if (line != null && !line.trim().isEmpty()) {
                    return false;
                }
            }
        } catch (IOException var3) {
            var3.printStackTrace();
        }

        return true;
    }

    public void returnToMenu() {
        try {
            System.out.println("\n\tDo you want to continue with main menu?\n");
            System.out.println(" Please select your option \n 1. Yes \n 2. No");
            switch (this.sc.nextInt()) {
                case 1:
                    this.displayMainMenu();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid option!");
                    this.displayMainMenu();
            }
        } catch (Exception var2) {
            System.out.println("\nInvalid option!");
            this.displayMainMenu();
        }

    }
}
