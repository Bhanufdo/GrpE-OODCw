public class MiniLorry extends Vehicle {
    private String LengthOfVehicle;

    public MiniLorry() {
        super();
    }

    public MiniLorry(String LengthOfVehicle) {
        super();
        this.LengthOfVehicle = LengthOfVehicle;
    }

    public MiniLorry(String typeOfVehicle, String vehicleNumberPlate, String brandOfVehicle, DateTime dateTime, String lengthOfVehicle) {
        super(typeOfVehicle, vehicleNumberPlate, brandOfVehicle, dateTime);
        this.LengthOfVehicle = lengthOfVehicle;
        this.setTypeOfVehicle (typeOfVehicle);
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

    public String getLengthOfVehicle() {
        return LengthOfVehicle;
    }

    public void setLengthOfVehicle(String lengthOfVehicle) {
        LengthOfVehicle = lengthOfVehicle;
    }

    @Override
    public String toString() {
        return "MiniLorry{" +
                "LengthOfVehicle='" + LengthOfVehicle + '\'' +
                ", TypeOfVehicle='" + TypeOfVehicle + '\'' +
                ", VehicleNumberPlate='" + VehicleNumberPlate + '\'' +
                ", BrandOfVehicle='" + BrandOfVehicle + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}


