public class Van extends Vehicle {
    private String GearType;

    public Van() {
        super();
    }

    public Van(String gearType) {
        super();
        this.GearType = gearType;
    }

    public Van(String typeOfVehicle, String vehicleNumberPlate, String brandOfVehicle, DateTime dateTime, String gearType) {
        super(typeOfVehicle, vehicleNumberPlate, brandOfVehicle, dateTime);
        this.GearType = gearType;
        this.setTypeOfVehicle(typeOfVehicle);
        this.setVehicleNumberPlate(vehicleNumberPlate);
        this.setBrandOfVehicle(brandOfVehicle);
        this.setDateTime(dateTime);
    }



    @Override
    public String getTypeOfVehicle() {
        return super.getTypeOfVehicle();
    }

    @Override
    public void setTypeOfVehicle(String typeOfVehicle) {
        super.setTypeOfVehicle(typeOfVehicle);
    }

    @Override
    public String getVehicleNumberPlate() {
        return super.getVehicleNumberPlate();
    }

    @Override
    public void setVehicleNumberPlate(String vehicleNumberPlate) {
        super.setVehicleNumberPlate(vehicleNumberPlate);
    }

    @Override
    public String getBrandOfVehicle() {
        return super.getBrandOfVehicle();
    }

    @Override
    public void setBrandOfVehicle(String brandOfVehicle) {
        super.setBrandOfVehicle(brandOfVehicle);
    }

    @Override
    public DateTime getDateTime() {
        return super.getDateTime();
    }

    @Override
    public void setDateTime(DateTime dateTime) {
        super.setDateTime(dateTime);
    }

    public String getGearType() {
        return GearType;
    }

    public void setGearType(String gearType) {
        GearType = gearType;
    }

    @Override
    public String toString() {
        return "Van{" +
                "GearType='" + this.GearType + '\'' +
                ", TypeOfVehicle='" + this.TypeOfVehicle + '\'' +
                ", VehicleNumberPlate='" + this.VehicleNumberPlate + '\'' +
                ", BrandOfVehicle='" + this.BrandOfVehicle + '\'' +
                ", dateTime=" + this.dateTime +
                '}';
    }
}

