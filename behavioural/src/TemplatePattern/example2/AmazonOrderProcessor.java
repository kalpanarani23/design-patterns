package TemplatePattern.example2;

public class AmazonOrderProcessor {
    public static void main(String[] args) {
        OrderProcessingTemplate localOrder = new LocalOrderProcessor();
        OrderProcessingTemplate internationalOrder = new InternationalOrderProcessor();

        System.out.println("Processing a local order:");
        localOrder.processOrder();
        System.out.println();

        System.out.println("Processing an international order:");
        internationalOrder.processOrder();
    }
}
