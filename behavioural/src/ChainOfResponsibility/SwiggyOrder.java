package ChainOfResponsibility;

public class SwiggyOrder {
    public static void main(String[] args) {
        OrderHandler handler = new OrderValidationHandler(
                new ProcessPaymentHandler(
                        new OrderPreparationHandler(
                                new DeliveryAssignmentHandler(
                                        new TrackingOrderHandler(null)))));
        handler.processOrder("KABAB");
    }
}
