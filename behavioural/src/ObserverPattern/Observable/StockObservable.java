package ObserverPattern.Observable;


import ObserverPattern.Observer.NotificationAlertObserver;

public interface StockObservable {
    void add(NotificationAlertObserver observer);

    void remove(NotificationAlertObserver observer);

    void notifySubscribers();
    void setStockCount(int newStock);

    int  getDataStockCount();
}
