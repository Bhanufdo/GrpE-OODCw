import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class IITCarParkManager implements CarParkManager{

    private List<Vehicle> vehicleList;
    private int maxOfSlots;

    int Vcar =0, Vvan = 0, Vbike = 0, VminiLorry = 0, VminiBus =0;
    float Scar = 0, Svan = 0, Sbike = 0,Slorry = 0, Sbus = 0;



    public IITCarParkManager() {
        super();
        this.vehicleList = new ArrayList<Vehicle>();
        this.maxOfSlots = 180;
    }

    @Override
    public void addVehicle(Vehicle vehicle){
        if (vehicleList.size() < this.maxOfSlots){
            this.vehicleList.add(vehicle);
        } else {
            System.out.println("Car Park is full");
        }
    }

    @Override
    public void deleteVehicle(String regNo){
        List<Vehicle> removeList = new ArrayList<Vehicle>();
        for (Vehicle obj:vehicleList){
            System.out.println("                ");
            System.out.println("===============================================");
            System.out.println("<<<<<<<   Vehicle Deleting in processs  >>>>>>>");
            System.out.println("===============================================");
            if (obj instanceof Car){
                if (obj.getVehicleRegNo().equals(regNo)){
                    //vehicleList.remove(obj);
                    removeList.add(obj);
                }
            }else if (obj instanceof Van){
                if (obj.getVehicleRegNo().equals(regNo)){
                    //vehicleList.remove(obj);
                    removeList.add(obj);
                }
            }else if (obj instanceof Bike) {
                if (obj.getVehicleRegNo().equals(regNo)) {
                    //vehicleList.remove(obj);
                    removeList.add(obj);
                }
            }else if (obj instanceof MiniBus) {
                if (obj.getVehicleRegNo().equals(regNo)) {
                    //vehicleList.remove(obj);
                    removeList.add(obj);
                }
            }else if (obj instanceof MiniLorry) {
                if (obj.getVehicleRegNo().equals(regNo)) {
                    //vehicleList.remove(obj);
                    removeList.add(obj);
                }
            }


        }
        if (removeList.size() > 0){
            vehicleList.removeAll(removeList);
        }
        System.out.println("Your vehicle was Deleted Successfully!");

    }

    @Override
    public void viewLastVehicle() {
        Vehicle v = vehicleList.get(vehicleList.size()-1);

        System.out.println(v.getVehicleRegNo());
    }


    @Override
    public void charges(String regNo, String etime){
        int fee = 0;
        for (Vehicle obj:vehicleList){
            System.out.println("<<<<<<<<<   Wait for Your Bill  >>>>>>>>>");
            if (obj.getVehicleRegNo().equals(regNo)){
                SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
                try {
                    Date sd = df.parse(obj.dt.getStime()) ;
                    Date ed = df.parse(etime);

                    long difference_In_Time
                            = ed.getTime() - sd.getTime();

                    long difference_In_Seconds
                            = TimeUnit.MILLISECONDS
                            .toSeconds(difference_In_Time)
                            % 60;

                    long difference_In_Minutes
                            = TimeUnit
                            .MILLISECONDS
                            .toMinutes(difference_In_Time)
                            % 60;

                    long difference_In_Hours
                            = TimeUnit
                            .MILLISECONDS
                            .toHours(difference_In_Time)
                            % 24;

                    //System.out.print("Time Vehicle parked in Car park: ");
                    //System.out.println(difference_In_Hours+"hr,"+difference_In_Minutes+"min,"+difference_In_Seconds+"sec");

                    if (difference_In_Hours <= 3){
                        fee = 300;
                    }else if (difference_In_Hours >3){
                        long diff = difference_In_Hours - 3;
                        int d = (int)diff;
                        fee = 300 + (100 * d);
                    }else if (difference_In_Hours == 00){
                        fee = 3000;
                    }

                    System.out.println("===============================================");
                    System.out.println("                 IIT CAR PARK                  ");
                    System.out.println("===============================================");
                    System.out.println("                    INVOICE                    ");
                    System.out.println("-----------------------------------------------");
                    System.out.println("      Date              : "+obj.dt.getDate());
                    System.out.println("      Starting Time     : "+obj.dt.getStime());
                    System.out.println("      Ending Time       : "+etime);
                    System.out.println("-----------------------------------------------");
                    System.out.println("                  USER DETAILS                 ");
                    System.out.println("-----------------------------------------------");
                    System.out.println("      User Name         : "+obj.getOwnerName());
                    System.out.println("      Vehicle Reg.No    : "+obj.getVehicleRegNo());
                    System.out.println("-----------------------------------------------");
                    System.out.println("               AMOUNT & DENOMINATIONS          ");
                    System.out.println("-----------------------------------------------");
                    System.out.println("      Total time parked : "+difference_In_Hours+":"+difference_In_Minutes+":"+difference_In_Seconds);
                    System.out.println("      Total fee         : "+fee+"LKR");
                    System.out.println("===============================================");
                    System.out.println("                    Thank you!                 ");
                    System.out.println("===============================================");


                }catch (ParseException e){
                    e.printStackTrace();
                }
            }

        }
        deleteVehicle(regNo);
    }

    @Override
    public void longestParked() {
        if (!vehicleList.isEmpty()){
            Collections.sort(vehicleList,new sortItems());
            System.out.println(vehicleList.get(0));
        }
    }

    /*@Override
    public void searchVehicle(String regNo){
        for (Vehicle obj:vehicleList){
            if (obj instanceof Car){
                if (obj.vehicleRegNo.equals(regNo)){
                    System.out.println(" ");
                    System.out.println("*******************************");
                    System.out.println("Request found!");
                    System.out.println("Owner Name: "+obj.ownerName+"\n"+"Vehicle Number Plate: "+obj.vehicleRegNo+"\n"+"Number of Passengers: "+obj.noOfPassengers);
                }
            }
        }
    }*/
    @Override
    public void printStatus(){
        //System.out.println(vehicleList.size());
        for (int i = vehicleList.size()-1; i >= 0  ; i--){
            //System.out.println(i);
            Vehicle obj = vehicleList.get(i);

            if (obj instanceof Car){
                System.out.println("*******************************");
                System.out.println("Owner Name: "+obj.getOwnerName()+"\n"+"Vehicle Number Plate: "+obj.getVehicleRegNo()+"\n"+"Number of Passengers: "+obj.getNoOfPassengers());
            } else if (obj instanceof Van){
                System.out.println("*******************************");
                System.out.println("Owner Name: "+obj.getOwnerName()+"\n"+"Vehicle Number Plate: "+obj.getVehicleRegNo()+"\n"+"Number of Passengers: "+obj.getNoOfPassengers());
            }else if (obj instanceof Bike) {
                System.out.println("*******************************");
                System.out.println("Owner Name: " + obj.getOwnerName() + "\n" + "Vehicle Number Plate: " + obj.getVehicleRegNo() + "\n" + "Number of Passengers: " + obj.getNoOfPassengers());
            }else if (obj instanceof MiniBus) {
                System.out.println("*******************************");
                System.out.println("Owner Name: " + obj.getOwnerName() + "\n" + "Vehicle Number Plate: " + obj.getVehicleRegNo() + "\n" + "Number of Passengers: " + obj.getNoOfPassengers());
            }else if (obj instanceof MiniLorry) {
                System.out.println("*******************************");
                System.out.println("Owner Name: " + obj.getOwnerName() + "\n" + "Vehicle Number Plate: " + obj.getVehicleRegNo() + "\n" + "Number of Passengers: " + obj.getNoOfPassengers());
            }else{
                System.out.println("Unsupported Vehicle!");
            }
        }
    }

    @Override
    public void searchByDay(String day){
        for (Vehicle obj:vehicleList){
            if (obj.dt.getDate().equals(day)){
                System.out.println("Owner Name: "+obj.getOwnerName()+"\n"+"Vehicle Number Plate: "+obj.getVehicleRegNo()+"\n"+"Number of Passengers: "+obj.getNoOfPassengers());
            }
        }
    }

    @Override
    public void vehiclesByPercentage(){
        int total = Vcar + Vvan + Vbike + VminiBus + VminiLorry;
        double Pcar = Vcar*100/total;
        double Pvan = Vvan*100/total;
        double Pbike = Vbike*100/total;
        double Pbus = VminiBus*100/total;
        double Plorry= VminiLorry*100/total;

        System.out.println("Vehicle Percentages: ");
        System.out.println("Cars = "+Pcar+"%");
        System.out.println("Vans = "+Pvan+"%");
        System.out.println("Bike = "+Pbike+"%");
        System.out.println("Mini Bus = "+Pbus+"%");
        System.out.println("Mini Lorry = "+Plorry+"%");
    }

    @Override
    public boolean mainMenu(){
        boolean exit = false;
        System.out.println("============================================");
        System.out.println("Welcome to the IIT CarPark Management System");
        System.out.println("============================================");
        System.out.println("Here you can Park your Car,Van, Bike,MiniBus");
        System.out.println("Cars can park in 3rd floor and above");
        System.out.println("Van and bikes are allowed to park in 1stfloor");
        System.out.println("============================================");
        System.out.println("                                            ");


        System.out.println("============================================");
        System.out.println("[1] Add new Vehicle");
        System.out.println("[2] Print the list of vehicles parked");
        System.out.println("[3] Delete Vehicle");
        System.out.println("[4] Longest Parked Vehicle");
        System.out.println("[5] Search Vehicle By Day");
        System.out.println("[6] Vehicle percentage");
        System.out.println("[7] View last vehicle");
        System.out.println("[8] Exit");
        System.out.print("Enter your choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice){
            case 1:
                System.out.println("============================================");
                System.out.println("[1] Add a Car");
                System.out.println("[2] Add a Van");
                System.out.println("[3] Add a Bike");
                System.out.println("[4] Add a Mini Bus");
                System.out.println("[5] Add a Mini Lorry");
                System.out.print("Enter your choice: ");
                int choice2 = sc.nextInt();

                System.out.print("Enter Your Name: ");
                Scanner nm = new Scanner(System.in);
                String name = nm.next();
                System.out.println("Enter Date: [dd-mm-yyyy]");
                Scanner d = new Scanner(System.in);
                String date = d.next();
                System.out.println("Enter Time: [HH:mm:ss]");
                Scanner st = new Scanner(System.in);
                String stime = st.next();

                System.out.print("Enter the Vehicle Registration Number: ");
                String vehicleRegNo = sc.next();
                System.out.print("Enter the number of Passengers on board: ");
                int noOfPassengers = sc.nextInt();

                Vehicle obj = null;
                switch (choice2){
                    case 1:
                        String brand = null;
                        System.out.print("Enter the car brand: ");
                        brand = sc.next();

                        obj = new Car(vehicleRegNo,noOfPassengers,brand,name,date,stime);
                        //System.out.println("No.of remaining available slots: "+(maxOfSlots - 1));
                        Scar += 3;
                        Vcar += 1;
                        break;
                    case 2:
                        String modal = null;
                        System.out.print("Enter modal of van[long/ short]: ");
                        modal = sc.next();

                        obj = new Van(vehicleRegNo,noOfPassengers,modal,name,date,stime);
                        //System.out.println("No.of remaining available slots: "+(maxOfSlots - 2));
                        Svan += 6;
                        Vvan +=1;
                        break;
                    case 3:
                        String capacity = null;
                        System.out.print("Enter the engine capacity: ");
                        capacity = sc.next();

                        obj = new Bike(vehicleRegNo,noOfPassengers,name,date,stime,capacity);
                        //System.out.println("No.of remaining available slots: "+(maxOfSlots - 1));
                        Sbike +=1;
                        Vbike += 1;
                        break;
                    case 4:
                        String noOfDoors = null;
                        System.out.print("Enter the number of doors[1/2]: ");
                        noOfDoors = sc.next();

                        obj = new MiniBus(vehicleRegNo,noOfPassengers,name,date,stime,noOfDoors);
                        //System.out.println("No.of remaining available slots: "+(maxOfSlots - 1));
                        Sbus += 9;
                        VminiBus += 1;
                        break;
                    case 5:
                        String tcapacity = null;
                        System.out.print("Enter the Tank capacity: ");
                        tcapacity = sc.next();

                        obj = new Bike(vehicleRegNo,noOfPassengers,name,date,stime,tcapacity);
                        //System.out.println("No.of remaining available slots: "+(maxOfSlots - 1));
                        Slorry += 9;
                        VminiLorry += 1;
                        break;
                    default:
                        System.out.println("<<Invalid vehicle input. Please enter shape again!>>");
                }
                float total_spaces = Scar+Svan+Sbike+Sbus+Slorry;
                float final_spaces = (maxOfSlots - total_spaces)/3;
                if (obj != null){
                    addVehicle(obj);
                    System.out.println("Vehicle added Successfully!");
                    System.out.println("No.of remaining available slots: "+final_spaces);
                } else {
                    System.out.println("ERROR: Object not created Please trt again!");
                }

                break;

            case 2:
                printStatus();
                break;
            case 3:
                Scanner dl = new Scanner(System.in);
                System.out.println("                                            ");
                System.out.println("============================================");
                System.out.println("Enter your car Reg.no: ");
                String regNo = dl.next();
                System.out.print("Enter Time: [HH:mm:ss]");
                Scanner et = new Scanner(System.in);
                String etime = et.next();


                //deleteVehicle(regNo);
                charges(regNo,etime);
                break;
            /*case 4:
                Scanner se = new Scanner(System.in);
                System.out.println("                                            ");
                System.out.println("============================================");
                System.out.println("Enter your car Reg.no: ");
                String vNo = se.next();
                //searchVehicle(vNo);
                break;*/
            case 4:
                longestParked();
                break;
            case 5:
                Scanner dy = new Scanner(System.in);
                System.out.println("                                            ");
                System.out.println("============================================");
                System.out.println("Enter Date: [dd-mm-yyyy]");
                String day = dy.next();
                searchByDay(day);
                break;

            case 6:
                vehiclesByPercentage();
                break;
            case 7:
                viewLastVehicle();
                break;
            case 8:
                exit = true;
                System.out.println("Moving out from the application >>>>>>>");
                break;
            default:
                System.out.println("Invalid Choice please enter 1,2 or 3");

        }
        return exit;
    }
}

