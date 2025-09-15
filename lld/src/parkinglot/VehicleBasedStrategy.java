package parkinglot;

import java.util.Map;

public class VehicleBasedStrategy implements FeeStrategy {
    private static final Map<SpotType, Integer> rates = Map.of(SpotType.BIKE_SPOT, 10,
            SpotType.CAR_SPOT, 20,
            SpotType.TRUCK_SPOT, 50);

    @Override
    public double calculateFee(ParkingTicket ticket) {
        long duration = ticket.getExitTimestamp() - ticket.getEntryTimestamp();
        return (duration / (1000 * 60 * 60) + 1) * rates.get(ticket.getSpot().getSpotType());
    }
}
