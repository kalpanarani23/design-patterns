package lowleveldesign.src.behavioural;

import behavioural.ObserverPattern.Observable.IphoneObservableImpl;
import behavioural.ObserverPattern.Observable.StockObservable;
import behavioural.ObserverPattern.Observer.EmailAlertObserverImpl;
import behavioural.ObserverPattern.Observer.NotificationAlertObserver;

public class Main {
    public static void main(String[] args) {
//        Vehicle vehicle = new SportsVehicle();
//        vehicle.drive();


        StockObservable iphoneStockObservable = new IphoneObservableImpl();
        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("kalpana@gmail.com", iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.setStockCount(10);

    }
}