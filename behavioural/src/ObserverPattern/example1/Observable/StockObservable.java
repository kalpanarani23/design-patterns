package ObserverPattern.example1.Observable;


import ObserverPattern.example1.Observer.NotificationAlertObserver;

public interface StockObservable {
    void add(NotificationAlertObserver observer);

    void remove(NotificationAlertObserver observer);

    void notifySubscribers();
    void setStockCount(int newStock);

    int  getDataStockCount();
}
