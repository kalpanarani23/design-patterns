package facade.restaurant;

public class OrderFacade {
    private Waiter waiter;
    private Kitchen kitchen;

    public OrderFacade(Waiter waiter, Kitchen kitchen) {
        this.waiter = waiter;
        this.kitchen = kitchen;
    }

    public void orderFood() {
        waiter.takeOrder();
        waiter.takeOrderToKitchen();
        kitchen.prepareFood();
        kitchen.callWaiter();
        waiter.serverCustomer();
        kitchen.washDishes();
    }
}
