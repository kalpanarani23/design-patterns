package ChainOfResponsibility;


public class OrderPreparationHandler extends OrderHandler {
    OrderPreparationHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Start preparing order : " + order);
        if (nextHandler != null) {
            nextHandler.processOrder(order);
        }
    }
}
