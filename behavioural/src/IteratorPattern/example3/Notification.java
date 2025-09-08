package IteratorPattern.example3;

import IteratorPattern.example2.Product;

import java.util.ArrayList;
import java.util.List;

public class Notification {
        private String message;

        public Notification(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

interface Iterator<T> {
    T first();
    T next();
    boolean hasNext();
}

class NotificationIterator implements Iterator<Notification> {
    private List<Notification> notifications;
    private int current;

    public NotificationIterator(List<Notification> notifications) {
        this.notifications = notifications;
        this.current = 0;
    }

    public Notification first() {
        if (notifications.isEmpty()) return null;
        current = 0;
        return notifications.get(current);
    }

    public Notification next() {
        if (hasNext()) {
            return notifications.get(++current);
        }
        return null;
    }

    public boolean hasNext() {
        return current < notifications.size() - 1;
    }
}

//Inventory
class NotificationCenter {
    private List<Notification> notifications = new ArrayList<>();

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public Iterator<Notification> createIterator() {
        return new NotificationIterator(notifications);
    }
}


