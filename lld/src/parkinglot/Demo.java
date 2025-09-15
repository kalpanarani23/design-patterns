package parkinglot;

import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        ParkingFloor parkingFloor1 = new ParkingFloor(1);

        parkingFloor1.addSpot(new ParkingSpot(SpotType.CAR_SPOT, "F1-CAR1"));
        parkingFloor1.addSpot(new ParkingSpot(SpotType.BIKE_SPOT, "F1-BIKE1"));
        parkingFloor1.addSpot(new ParkingSpot(SpotType.TRUCK_SPOT, "F1-TRUCK1"));

        ParkingFloor parkingFloor2 = new ParkingFloor(2);
        parkingFloor2.addSpot(new ParkingSpot(SpotType.CAR_SPOT, "F2-CAR2"));
        parkingFloor2.addSpot(new ParkingSpot(SpotType.BIKE_SPOT, "F2-BIKE2"));
        parkingFloor2.addSpot(new ParkingSpot(SpotType.BIKE_SPOT, "F2-BIKE2"));

        parkingLot.addFloor(parkingFloor1);
        parkingLot.addFloor(parkingFloor2);

        parkingLot.setFeeStrategy(new VehicleBasedStrategy());

        Vehicle bike = new Bike("B-123");
        Vehicle car = new Car("C-456");
        Vehicle truck = new Truck("T-789");

        System.out.println("\n--- Availability Before parking ---");
        parkingFloor1.displayAvailability();
        parkingFloor2.displayAvailability();


        Optional<ParkingTicket> ticket1 = parkingLot.parkVehicle(car);
        Optional<ParkingTicket> ticket2 = parkingLot.parkVehicle(truck);
        Optional<ParkingTicket> ticket3 = parkingLot.parkVehicle(bike);


        System.out.println("\n--- Availability after parking ---");
        parkingFloor1.displayAvailability();
        parkingFloor2.displayAvailability();

        // 3. Simulate another car entry (should go to floor 2)
        Vehicle car2 = new Car("C-999");
        Optional<ParkingTicket> car2TicketOpt = parkingLot.parkVehicle(car2);

        // 4. Simulate a vehicle entry that fails (no available spots)
        Vehicle bike2 = new Bike("B-000");
        Optional<ParkingTicket> failedBikeTicketOpt = parkingLot.parkVehicle(bike2);

        // 5. Simulate vehicle exits and fee calculation
        System.out.println("\n--- Vehicle Exits ---");

        if (ticket1.isPresent()) {
            Optional<Double> feeOpt = parkingLot.unparkVehicle(car.getLicensePlate());
            feeOpt.ifPresent(fee -> System.out.printf("Car C-456 unparked. Fee: $%.2f\n", fee));
        }

        System.out.println("\n--- Availability after one car leaves ---");
        parkingFloor1.displayAvailability();
        parkingFloor2.displayAvailability();

    }
}
