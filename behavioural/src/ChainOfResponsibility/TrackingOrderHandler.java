package ChainOfResponsibility;

public class TrackingOrderHandler extends OrderHandler {
    TrackingOrderHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Tacking order : " + order);
    }
}
