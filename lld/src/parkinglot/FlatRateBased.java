package parkinglot;

public class FlatRateBased implements FeeStrategy {
    @Override
    public double calculateFee(ParkingTicket ticket) {
        long duration = ticket.getExitTimestamp() - ticket.getEntryTimestamp();
        return ((duration / (1000 * 60 * 60)) + 1) * 10;
    }
}
