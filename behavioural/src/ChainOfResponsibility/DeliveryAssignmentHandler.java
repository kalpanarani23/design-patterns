package ChainOfResponsibility;

public class DeliveryAssignmentHandler extends OrderHandler {
    DeliveryAssignmentHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Assigning Delivery partner for order : " + order);
        if (nextHandler != null) {
            nextHandler.processOrder(order);
        }
    }
}
