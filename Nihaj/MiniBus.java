public class MiniBus extends Vehicle {
    public String NumberOfSeats;

    public MiniBus() {
        super();
    }

    public MiniBus(String NumberOfSeats) {
        super();
        this.NumberOfSeats = NumberOfSeats;
    }

    public MiniBus(String typeOfVehicle, String vehicleNumberPlate, String brandOfVehicle, DateTime dateTime, String numberOfSeats) {
        super(typeOfVehicle, vehicleNumberPlate, brandOfVehicle, dateTime);
        this.NumberOfSeats = numberOfSeats;
        this.setTypeOfVehicle(typeOfVehicle);
        this.setVehicleNumberPlate(vehicleNumberPlate);
        this.setBrandOfVehicle(brandOfVehicle);
        this.setDateTime(dateTime);
    }

    public String getNumberOfSeats() {
        return NumberOfSeats;
    }

    public void setNumberOfSeats(String numberOfSeats) {
        NumberOfSeats = numberOfSeats;
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
        return "MiniBus{" +
                "NumberOfSeats='" + NumberOfSeats + '\'' +
                ", TypeOfVehicle='" + TypeOfVehicle + '\'' +
                ", VehicleNumberPlate='" + VehicleNumberPlate + '\'' +
                ", BrandOfVehicle='" + BrandOfVehicle + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
