package facade.restaurant;

public class Main {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        Waiter waiter = new Waiter();

        OrderFacade order = new OrderFacade(waiter, kitchen);
        order.orderFood();
    }
}
