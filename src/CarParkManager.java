public interface CarParkManager {
    void addVehicle(Vehicle vehicle);
    void deleteVehicle(String regNO);
    //void searchVehicle(String regNo);
    void viewLastVehicle();
    void printStatus();
    void searchByDay(String date,String fileName);
    void vehiclesByPercentage();
    void charges(String regNo, String etime);
    void longestParked();
    boolean mainMenu(String fileName);
}
