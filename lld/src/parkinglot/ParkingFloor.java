package parkinglot;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ParkingFloor {
    private final int floorNumbers;
    private final Map<String, ParkingSpot> spots;

    public ParkingFloor(int floorNumbers) {
        this.floorNumbers = floorNumbers;
        this.spots = new ConcurrentHashMap<>();
    }

    public void addSpot(ParkingSpot spot) {
        spots.put(spot.getSpotId(), spot);
    }

    public synchronized Optional<ParkingSpot> findAvailableSpot(Vehicle vehicle) {
        return spots.values().stream()
                .filter(e -> !e.isOccupied() && e.canFit(vehicle))
                .sorted(Comparator.comparing(ParkingSpot::getSpotType))
                .findFirst();

    }

    public int getFloorNumbers() {
        return floorNumbers;
    }

    public Map<String, ParkingSpot> getParkingSpots() {
        return spots;
    }


    public void displayAvailability() {
        System.out.printf("--- Floor %d Availability ---\n", floorNumbers);
        Map<SpotType, Long> availableCounts = spots.values().stream()
                .filter(spot -> !spot.isOccupied())
                .collect(Collectors.groupingBy(ParkingSpot::getSpotType, Collectors.counting()));

        for (SpotType type : SpotType.values()) {
            System.out.printf("  %s spots: %d\n", type , availableCounts.getOrDefault(type, 0L));
        }
    }
}
