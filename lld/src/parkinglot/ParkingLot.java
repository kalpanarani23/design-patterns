package parkinglot;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

    private static ParkingLot instance;
    final List<ParkingFloor> parkingFloors;
    final Map<String, ParkingTicket> parkingTicketMap;
    FeeStrategy feeStrategy;
    Parking parking = new Parking();

    private ParkingLot() {
        this.parkingTicketMap = new ConcurrentHashMap<>();
        this.feeStrategy = new FlatRateBased();
        this.parkingFloors = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        parkingFloors.add(floor);
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public Optional<Double> unparkVehicle(String licenceNUmber) {
        ParkingTicket ticket = parkingTicketMap.remove(licenceNUmber);
        ticket.setExitTimestamp(new Date().getTime());
        ticket.getSpot().unParkVehicle();
        System.out.println("Unparked vehicle " + ticket.getSpot().unParkVehicle());
        parkingTicketMap.remove(ticket.getTicketId());
        Double parkingFee = feeStrategy.calculateFee(ticket);
        return Optional.of(parkingFee);

    }


    public Optional<ParkingTicket> parkVehicle(Vehicle vehicle) {
        Optional<ParkingSpot> parkingSpot = parking.findSpot(parkingFloors, vehicle);

        if (parkingSpot.isPresent()) {
            ParkingSpot spot = parkingSpot.get();
            spot.parkVehicle(vehicle);
            System.out.println("Parked vehicle " + spot.parkVehicle(vehicle));
            ParkingTicket ticket = new ParkingTicket(vehicle, spot);
            parkingTicketMap.put(vehicle.getLicensePlate(), ticket);
            System.out.printf("%s parked at %s. Ticket: %s\n", vehicle.getLicensePlate(), spot.getSpotId(), ticket.getTicketId());
            return Optional.of(ticket);
        }

        System.out.println("No available spot for " + vehicle.getLicensePlate());
        return Optional.empty();
    }
}
