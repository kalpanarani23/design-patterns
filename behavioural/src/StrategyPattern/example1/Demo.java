package StrategyPattern.example1;

public class Demo {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        PaymentStrategy strategy = new CreditCardPayment();
        processor.setPaymentStrategy(strategy);

        processor.processPayment(100.0);

        strategy = new PayPalPayment();
        processor.setPaymentStrategy(strategy);

        processor.processPayment(50.0);
    }
}
