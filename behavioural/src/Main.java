import ObserverPattern.example1.Observable.IphoneObservableImpl;
import ObserverPattern.example1.Observable.StockObservable;
import ObserverPattern.example1.Observer.EmailAlertObserverImpl;
import ObserverPattern.example1.Observer.NotificationAlertObserver;

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