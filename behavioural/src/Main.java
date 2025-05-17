import ObserverPattern.Observable.IphoneObservableImpl;
import ObserverPattern.Observable.StockObservable;
import ObserverPattern.Observer.EmailAlertObserverImpl;
import ObserverPattern.Observer.NotificationAlertObserver;

public class Main {
    public static void main(String[] args) {
//        Vehicle vehicle = new SportsVehicle();
//        vehicle.drive();


        StockObservable iphoneStockObservable = new IphoneObservableImpl();
        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("kalpana@gmail.com",
                iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.setStockCount(10);

    }
}