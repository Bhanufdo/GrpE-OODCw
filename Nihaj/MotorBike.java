public class MotorBike extends Vehicle {
    private int EngineCC;

    public MotorBike() {
        super();
    }

    public MotorBike(int engineCC) {
        this.EngineCC = engineCC;
    }

    public MotorBike(String typeOfVehicle, String vehicleNumberPlate, String brandOfVehicle, DateTime dateTime, int engineCC) {
        super(typeOfVehicle, vehicleNumberPlate, brandOfVehicle, dateTime);
        this.EngineCC = engineCC;
        this.setTypeOfVehicle (typeOfVehicle);
        this.setVehicleNumberPlate(vehicleNumberPlate);
        this.setBrandOfVehicle(brandOfVehicle);
        this.setDateTime(dateTime);
    }

    public int getEngineCC() {
        return EngineCC;
    }

    public void setEngineCC(int engineCC) {
        EngineCC = engineCC;
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
        return "MotorBike{" +
                "EngineCC=" + EngineCC +
                ", TypeOfVehicle='" + TypeOfVehicle + '\'' +
                ", VehicleNumberPlate='" + VehicleNumberPlate + '\'' +
                ", BrandOfVehicle='" + BrandOfVehicle + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
