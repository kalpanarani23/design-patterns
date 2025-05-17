package ObserverPattern.Observable;


import ObserverPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable {
    List<NotificationAlertObserver> observers = new ArrayList<>();
    int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for (NotificationAlertObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStock) {
        if (stockCount == 0) {
            notifySubscribers();
        }
        stockCount = stockCount + newStock;
    }

    @Override
    public int getDataStockCount() {
        return stockCount;
    }
}
