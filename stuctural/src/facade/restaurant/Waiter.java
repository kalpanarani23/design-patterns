package facade.restaurant;

public class Waiter {
    void takeOrder(){
        System.out.println("Waiter takes order from client");
    }

    void takeOrderToKitchen() {
        System.out.println("send order to the kitchen ");
    }

    void serverCustomer() {
        System.out.println("server's the food to customer");
    }

}
