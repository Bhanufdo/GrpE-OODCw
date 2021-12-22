public class Car extends Vehicle {
    private String ColorOfCar;

    public Car() {
        super();
    }

    public Car(String ColorOfCar) {
        super();
        this.ColorOfCar = ColorOfCar;
    }

    public Car(String typeOfVehicle, String vehicleNumberPlate, String brandOfVehicle, DateTime dateTime, String colorOfCar) {
        super(typeOfVehicle, vehicleNumberPlate, brandOfVehicle, dateTime);
        this.ColorOfCar = colorOfCar;
        this.setTypeOfVehicle (typeOfVehicle);
        this.setVehicleNumberPlate(vehicleNumberPlate);
        this.setBrandOfVehicle(brandOfVehicle);
        this.setDateTime(dateTime);
    }

    public String getColorOfCar() {
        return ColorOfCar;
    }

    public void setColorOfCar(String colorOfCar) {
        ColorOfCar = colorOfCar;
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
        return "Car{" +
                "ColorOfCar='" + ColorOfCar + '\'' +
                ", TypeOfVehicle='" + TypeOfVehicle + '\'' +
                ", VehicleNumberPlate='" + VehicleNumberPlate + '\'' +
                ", BrandOfVehicle='" + BrandOfVehicle + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
