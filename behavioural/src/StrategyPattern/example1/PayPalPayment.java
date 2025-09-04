package StrategyPattern.example1;

public class PayPalPayment implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing pay pal payment of $" + amount);

    }
}
