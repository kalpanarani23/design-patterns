package ChainOfResponsibility;

public class ProcessPaymentHandler extends OrderHandler {
    ProcessPaymentHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Processing payment for order : " + order);
        if (nextHandler != null) {
            nextHandler.processOrder(order);
        }
    }
}
