package lowleveldesign.src.behavioural.ObserverPattern.Observable;


import lowleveldesign.src.behavioural.ObserverPattern.Observer.NotificationAlertObserver;

public interface StockObservable {
    void add(NotificationAlertObserver observer);

    void remove(NotificationAlertObserver observer);

    void notifySubscribers();
    void setStockCount(int newStock);

    int  getDataStockCount();
}
