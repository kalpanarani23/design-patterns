package parkinglot;

public abstract class Vehicle {
    VehicleType vehicleType;
    String licensePlate;

    public Vehicle(VehicleType vehicleType, String licensePlate) {
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
