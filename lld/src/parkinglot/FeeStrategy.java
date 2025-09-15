package parkinglot;

public interface FeeStrategy {
    double calculateFee(ParkingTicket ticket);
}
