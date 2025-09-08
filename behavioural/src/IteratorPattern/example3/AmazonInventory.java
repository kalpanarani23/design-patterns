package IteratorPattern.example3;

import IteratorPattern.example2.Product;

public class AmazonInventory {
    public static void main(String[] args) {
        // Products
        ProductInventory inventory = new ProductInventory();
        inventory.addProduct(new Product("Laptop", 99999.99));
        inventory.addProduct(new Product("Smartphone", 49999.99));
        inventory.addProduct(new Product("Headphones", 7999.99));

        Iterator<Product> productIterator = inventory.createIterator();
        Product currentProduct = productIterator.first();
        while (currentProduct != null) {
            System.out.println("Product: " + currentProduct.getName() + ", Price: $" + currentProduct.getPrice());
            currentProduct = productIterator.next();
        }

        // Notifications
        NotificationCenter center = new NotificationCenter();
        center.addNotification(new Notification("Your order has been shipped."));
        center.addNotification(new Notification("Your payment is confirmed."));
        center.addNotification(new Notification("Your item has been delivered."));

        Iterator<Notification> notificationIterator = center.createIterator();
        Notification currentNotification = notificationIterator.first();
        while (currentNotification != null) {
            System.out.println("Notification: " + currentNotification.getMessage());
            currentNotification = notificationIterator.next();
        }
    }
}
