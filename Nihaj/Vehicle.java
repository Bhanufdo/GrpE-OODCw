public abstract class Vehicle {
    public String TypeOfVehicle;
    public String VehicleNumberPlate;
    public String BrandOfVehicle;
    DateTime dateTime;


    public Vehicle() {
        super();
        this.TypeOfVehicle = null;
        this.VehicleNumberPlate = null;
        this.BrandOfVehicle = null;
    }

    public Vehicle(String typeOfVehicle, String vehicleNumberPlate, String brandOfVehicle, DateTime dateTime) {
        super();
        this.TypeOfVehicle =typeOfVehicle;
        this.VehicleNumberPlate = vehicleNumberPlate;
        this.BrandOfVehicle = brandOfVehicle;
        this.dateTime = dateTime;
    }

    public String getTypeOfVehicle() {
        return TypeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        TypeOfVehicle = typeOfVehicle;
    }

    public String getVehicleNumberPlate() {
        return VehicleNumberPlate;
    }

    public void setVehicleNumberPlate(String vehicleNumberPlate) {
        VehicleNumberPlate = vehicleNumberPlate;
    }

    public String getBrandOfVehicle() {
        return BrandOfVehicle;
    }

    public void setBrandOfVehicle(String brandOfVehicle) {
        BrandOfVehicle = brandOfVehicle;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "TypeOfVehicle='" + TypeOfVehicle + '\'' +
                ", VehicleNumberPlate='" + VehicleNumberPlate + '\'' +
                ", BrandOfVehicle='" + BrandOfVehicle + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}


