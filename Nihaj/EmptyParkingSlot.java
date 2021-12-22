public class EmptyParkingSlot extends Vehicle{
    private String AvailableSlots;


    public EmptyParkingSlot(String AvailableSlot){

    }

    public String getAvailableSlots() {
        return AvailableSlots;
    }

    public void setAvailableSlots(String availableSlots) {
        AvailableSlots = availableSlots;
    }
    public String getTypeOfVehicle() {
        return TypeOfVehicle;
    }

    public  void setTypeOfVehicle(String typeOfVehicle) {
        TypeOfVehicle = typeOfVehicle;
    }

    public  String getVehicleNumberPlate() {
        return VehicleNumberPlate;
    }

    public  void setVehicleNumberPlate(String vehicleNumberPlate) {
        VehicleNumberPlate = vehicleNumberPlate;
    }

    public  String getBrandOfVehicle() {
        return BrandOfVehicle;
    }

    public  void setBrandOfVehicle(String brandOfVehicle) {
        BrandOfVehicle = brandOfVehicle;
    }

    public  DateTime getDateTime() {
        return dateTime;
    }

    public  void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

}
