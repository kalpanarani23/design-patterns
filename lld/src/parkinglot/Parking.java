package parkinglot;

import java.util.List;
import java.util.Optional;

public class Parking {
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> parkingFloors, Vehicle vehicle) {
        for (ParkingFloor floor : parkingFloors) {
            Optional<ParkingSpot> spotOnThisFloor = floor.findAvailableSpot(vehicle);
            if (spotOnThisFloor.isPresent()) {
                return spotOnThisFloor;
            }
        }
        return null;
    }
}
