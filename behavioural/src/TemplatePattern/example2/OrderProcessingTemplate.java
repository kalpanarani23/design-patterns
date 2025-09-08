package TemplatePattern.example2;

public  abstract class OrderProcessingTemplate {
    public void processOrder() {
        verifyOrder();
        assignDeliveryAgent();
        trackDelivery();
    }

    abstract void verifyOrder();
    abstract void assignDeliveryAgent();
    abstract void trackDelivery();
}

// Concrete subclass for processing orders from local restaurants
class LocalOrderProcessor extends OrderProcessingTemplate {
    void verifyOrder() {
        System.out.println("Verifying local order...");
        // Specific logic for verifying local orders
    }

    void assignDeliveryAgent() {
        System.out.println("Assigning a local delivery agent...");
        // Specific logic for assigning local delivery agents
    }

    void trackDelivery() {
        System.out.println("Tracking local delivery...");
        // Specific logic for tracking local deliveries
    }
}

// Concrete subclass for processing orders from international restaurants
class InternationalOrderProcessor extends OrderProcessingTemplate {
    void verifyOrder() {
        System.out.println("Verifying international order...");
        // Specific logic for verifying international orders
    }

    void assignDeliveryAgent() {
        System.out.println("Assigning an international delivery agent...");
        // Specific logic for assigning international delivery agents
    }

    void trackDelivery() {
        System.out.println("Tracking international delivery...");
        // Specific logic for tracking international deliveries
    }
}

