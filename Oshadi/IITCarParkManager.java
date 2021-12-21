import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IITCarParkManager implements CarParkManager {

    public List<Vehicle> List;
    public int Spaces;
    public List<String> entryTime;
    int Cspace, Vspace, Bspace, Lspace, Mspace = 0;
    int car, van, bus, lorry, bike = 0;
    int CP, VP, BP, MP, LP;
    int TotalSpace;
    int FinalSpace;
    double CarPercentage, VanPercentage, BusPercentage, LorryPercentage, BikePercentage;
    double TotalVehicles;
    String EntryTime;
    String ltv;
    String stv;

    public IITCarParkManager() {
        super();
        this.List = new ArrayList<Vehicle>();
        this.Spaces = 180; //60*3
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        if (List.size() < this.Spaces) {
            this.List.add(vehicle);
            TotalSpace++;
        }
    }

    @Override
    public void deleteVehicle(String RegNo) {
        for (Vehicle obj : List) {
            if (obj instanceof Car) {
                if (obj.vehicleRegNo.equals(RegNo)) {
                    List.remove(obj);
                    car -= 1;
                    Cspace-=3;
                    System.out.println("A CAR WITH REGISTER NUMBER " + obj.vehicleRegNo + " LEFT THE CAR PARK");
                }
            }
            else if (obj instanceof Van) {
                if (obj.vehicleRegNo.equals(RegNo)) {
                    List.remove(obj);
                    van -= 1;
                    Vspace-=6;
                    System.out.println("A VAN WITH REGISTER NUMBER " + obj.vehicleRegNo + " LEFT THE CAR PARK");
                }
            }
            else if (obj instanceof MiniBus) {
                if (obj.vehicleRegNo.equals(RegNo)) {
                    List.remove(obj);
                    bus -= 1;
                    Bspace-=9;
                    System.out.println("A MINI BUS WITH REGISTER NUMBER " + obj.vehicleRegNo + " LEFT THE CAR PARK");
                }
            }
            else if (obj instanceof MiniLorry) {
                if (obj.vehicleRegNo.equals(RegNo)) {
                    List.remove(obj);
                    lorry -= 1;
                    Lspace-=9;
                    System.out.println("A MINI LORRY WITH REGISTER NUMBER " + obj.vehicleRegNo + " LEFT THE CAR PARK");
                }
            }
            else if (obj instanceof MotorBike) {
                if (obj.vehicleRegNo.equals(RegNo)) {
                    List.remove(obj);
                    bike -= 1;
                    Mspace-=1;
                    System.out.println("A MOTOR BIKE WITH REGISTER NUMBER " + obj.vehicleRegNo + " LEFT THE CAR PARK");
                }
            }
        }
    }

    @Override
    public void findVehicle(String RegNo) {
        for (Vehicle obj : List) {
            if (obj instanceof Car) {
                if (obj.vehicleRegNo.equals(RegNo)) {
                    System.out.println("VEHICLE IS A CAR, OF REGISTER NUMBER: " + obj.vehicleRegNo);
                }
            }
            else if (obj instanceof Van) {
                if (obj.vehicleRegNo.equals(RegNo)) {
                    System.out.println("VEHICLE IS A VAN, OF REGISTER NUMBER: " + obj.vehicleRegNo);
                }
            }
            else if (obj instanceof MiniBus) {
                if (obj.vehicleRegNo.equals(RegNo)) {
                    System.out.println("VEHICLE IS A MINI BUS, OF REGISTER NUMBER: " + obj.vehicleRegNo);
                }
            }
            else if (obj instanceof MiniLorry) {
                if (obj.vehicleRegNo.equals(RegNo)) {
                    System.out.println("VEHICLE IS A MINI LORRY, OF REGISTER NUMBER: " + obj.vehicleRegNo);
                }
            }
            else if (obj instanceof MotorBike) {
                if (obj.vehicleRegNo.equals(RegNo)) {
                    System.out.println("VEHICLE IS A MOTOR BIKE, OF REGISTER NUMBER: " + obj.vehicleRegNo);
                }
            }
        }
    }
    @Override
    public boolean details() {
        boolean exit = false;
        System.out.println(" ");
        System.out.println("                     Select your preference");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Please enter number 1 to add a vehicle to the car park");
        System.out.println("Please enter number 2 to remove a vehicle from the car park");
        System.out.println("Please enter number 3 to print the list of vehicles parked");
        System.out.println("Please enter number 4 to print the percentage of vehicles parked");
        System.out.println("Please enter number 5 to print the receipt");
        System.out.println("Please enter number 6 to check the status of the vehicle");
        System.out.println("Please enter number 7 to print the first and last vehicle that was parked");
        System.out.println("Please enter number 8 to exit from the system");
        System.out.print(" ");
        Scanner sc = new Scanner(System.in);
        int preference = sc.nextInt();

        if (preference == 1) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Please enter number 1 to add a car");
            System.out.println("Please enter number 2 to add a van");
            System.out.println("Please enter number 3 to add a motor bike");
            System.out.println("Please enter number 4 to add a mini bus");
            System.out.println("Please enter number 5 to add a mini lorry");
            System.out.print(" ");
            int choice2 = sc.nextInt();

            System.out.print("Enter the vehicle register Number: ");
            String vehicleRegNo = sc.next();

            Vehicle veh = null;
            switch (choice2) {
                case 1:
                    veh = new Car(vehicleRegNo, EntryTime);
                    Cspace += 3;
                    car += 1;
                    break;
                case 2:
                    veh = new Van(vehicleRegNo, EntryTime);
                    Vspace += 6;
                    van += 1;
                    break;
                case 3:
                    veh = new MotorBike(vehicleRegNo, EntryTime);
                    Mspace += 1;
                    bike += 1;
                    break;
                case 4:
                    veh = new MiniBus(vehicleRegNo, EntryTime);
                    Bspace += 9;
                    bus += 1;
                    break;
                case 5:
                    veh = new MiniLorry(vehicleRegNo, EntryTime);
                    Lspace += 9;
                    lorry += 1;
                    break;
                default:
                    System.out.println("INVALID INPUT");
            }
            TotalSpace = Cspace + Vspace + Bspace + Lspace + Mspace;
            FinalSpace = (Spaces - TotalSpace) / 3;

            if (veh != null) {
                addVehicle(veh);
                System.out.println("VEHICLE ADDED!");
                if (FinalSpace != 0)
                    System.out.println("REMAINING NUMBER OF SPACE: " + FinalSpace);
                else
                    System.out.println("NO SPACE AVAILABLE");
            } else {
                System.out.println("ERROR!");
            }
        }

        else if (preference == 2) {
            Scanner dl = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Enter the vehicle register Number: ");
            String regNo = dl.nextLine();
            deleteVehicle(regNo);
        }
        else if (preference == 3) {
            printList();
        }
        else if (preference == 4) {
            printPercentage();
        }
        else if (preference == 5) {
            printReceipt();
        }
        else if (preference == 6) {
            Scanner reg = new Scanner(System.in);
            System.out.print("Enter the vehicle register Number: ");
            String regNo2 = reg.nextLine();
            findVehicle(regNo2);
        }
        else if (preference == 7) {
            printVehicle();
        }
        else if (preference == 8) {
            exit = true;
            System.out.println("CLOSE!");
        }
        else{
            System.out.println("INVALID INPUT");
        }
        return exit;
    }

    @Override
    public void printPercentage() {
        double car1 = car;
        double van1 = van;
        double bike1 = bike;
        double lorry1 = lorry;
        double bus1 = bus;

        TotalVehicles = (car1 + van1 + bike1 + lorry1 + bus1);

        CarPercentage = (car1 / TotalVehicles) * 100;
        VanPercentage = (van1 / TotalVehicles) * 100;
        BikePercentage = (bike1 / TotalVehicles) * 100;
        BusPercentage = (bus1 / TotalVehicles) * 100;
        LorryPercentage = (lorry1 / TotalVehicles) * 100;

        CP = (int) CarPercentage;
        VP = (int) VanPercentage;
        MP = (int) BikePercentage;
        BP = (int) BusPercentage;
        LP = (int) LorryPercentage;

        System.out.println("Percentage of cars is " + CP + "%");
        System.out.println("Percentage of vans is " + VP + "%");
        System.out.println("Percentage of motor bikes is " + MP + "%");
        System.out.println("Percentage of mini buses is " + BP + "%");
        System.out.println("Percentage of mini lorries is " + LP + "%");
    }
    @Override
    public void printReceipt() {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter the register number: ");
        String regno = sc1.nextLine();

        Scanner sc2 = new Scanner(System.in);
        System.out.print("Enter the entry time in HH:mm:ss order: ");
        String EntryTime = sc2.nextLine();

        Scanner sc3 = new Scanner(System.in);
        System.out.print("Enter the exit time in HH:mm:ss order: ");
        String ExitTime = sc3.nextLine();

        Scanner sc4 = new Scanner(System.in);
        System.out.print("Enter the entry date in DD/MM/YYYY order: ");
        String Date = sc4.nextLine();

        String time1 = EntryTime;
        String time2 = ExitTime;

        try {
            int charge;
            int newCharge=0;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

            Date date1 = simpleDateFormat.parse(time1);
            Date date2 = simpleDateFormat.parse(time2);

            long differenceInMilliSeconds = Math.abs(date2.getTime() - date1.getTime());
            long differenceInHours = (differenceInMilliSeconds / (60 * 60 * 1000)) % 24;
            long differenceInMinutes = (differenceInMilliSeconds / (60 * 1000)) % 60;
            long differenceInSeconds = (differenceInMilliSeconds / 1000) % 60;

            int l1 = (int) differenceInHours;

            if(l1==00){
                charge = 3000;
            }
            else if((l1-3)>0){
                charge = (3*300) + (l1-3)*100;
            }
            else {
                charge = (l1 * 100);
            }

            Scanner ch = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("Enter the vehicle type");
            System.out.println("[1] Car");
            System.out.println("[2] Van");
            System.out.println("[3] Motor Bike");
            System.out.println("[4] Mini Bus");
            System.out.println("[5] Mini Lorry");
            int ch2 = ch.nextInt();

            if(ch2 == 1)
                newCharge = charge*1;
            else if(ch2 == 2)
                newCharge = charge*2;
            else if(ch2 == 3)
                newCharge = charge/3;
            if(ch2 == 4)
                newCharge = charge*3;
            if(ch2 == 5)
                newCharge = charge*3;

            System.out.println(" ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("                            CAR PARK                  ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("                            INVOICE                   ");
            System.out.println("------------------------------------------------------------");
            System.out.println("            Date              : " + Date);
            System.out.println("            Starting Time     : " + EntryTime);
            System.out.println("            Ending Time       : " + ExitTime);
            System.out.println("            Vehicle Reg.No    : " + regno);
            System.out.println("           Vehicle parked for : " + differenceInHours + " hours " + differenceInMinutes + " minutes " + differenceInSeconds + " Seconds. ");
            System.out.println("------------------------------------------------------------");
            System.out.println("                            CHARGE                  ");
            System.out.println("------------------------------------------------------------");
            System.out.println("         Total charge         : " + "LKR " + newCharge);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("                            THANK YOU!              ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void printList() {
        for (int i = List.size()-1 ; i>=0 ; i--) {
            Vehicle obj = List.get(i);
            if (obj instanceof Car) {
                System.out.println("VEHICLE IS A CAR AND REGISTER NUMBER IS: " + obj.vehicleRegNo);
            } else if (obj instanceof Van) {
                System.out.println("VEHICLE IS A VAN AND REGISTER NUMBER IS: " + obj.vehicleRegNo);
            } else if (obj instanceof MiniBus) {
                System.out.println("VEHICLE IS A MINI BUS AND REGISTER NUMBER IS: " + obj.vehicleRegNo);
            } else if (obj instanceof MiniLorry) {
                System.out.println("VEHICLE IS A MINI LORRY AND REGISTER NUMBER IS: " + obj.vehicleRegNo);
            } else if (obj instanceof MotorBike) {
                System.out.println("VEHICLE IS A MOTOR BIKE AND REGISTER NUMBER IS: " + obj.vehicleRegNo);
            } else {
                System.out.println("INVALID VEHICLE TYPE!");
            }
        }

    }
    public void printVehicle(){

        for (int i = List.size()-1 ; i>=0 ; i--) {
            Vehicle obj = List.get(0);
            ltv = (obj.vehicleRegNo);
        }
        System.out.println("REGISTER NUMBER OF THE VEHICLE PARKED FOR LONGEST TIME IS " + ltv);

        for (int i = 0 ; i<=List.size()-1 ; i++) {
            Vehicle obj = List.get(i);
            stv = (obj.vehicleRegNo);
        }
        System.out.println("REGISTER NUMBER OF THE LAST PARKED VEHICLE IS " + stv);
    }
}
