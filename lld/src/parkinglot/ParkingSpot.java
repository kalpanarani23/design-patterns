package parkinglot;

public class ParkingSpot {
    private String spotId;
    private SpotType spotType;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSpot(SpotType spotType, String spotId) {
        this.spotType = spotType;
        this.spotId = spotId;
        isOccupied = false;
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        if (!isOccupied) {
            this.vehicle = vehicle;
            this.isOccupied = true;
            System.out.println("Vehicle is parked with " + vehicle.getLicensePlate() + " in spot" + spotId);
            return true;
        }
        return false;
    }

    public synchronized boolean unParkVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
        return true;
    }

    public String getSpotId() {
        return spotId;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean canFit(Vehicle vehicle) {
        if (isOccupied) return false;

        switch (vehicle.getVehicleType()) {
            case BIKE:
                return this.spotType == SpotType.BIKE_SPOT;
            case CAR:
                return this.spotType == SpotType.CAR_SPOT;
            case TRUCK:
                return this.spotType == SpotType.TRUCK_SPOT;
            default:
                return false;
        }

    }
}
