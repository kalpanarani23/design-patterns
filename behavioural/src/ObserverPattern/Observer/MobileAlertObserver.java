package ObserverPattern.Observer;


import ObserverPattern.Observable.StockObservable;

public class MobileAlertObserver implements NotificationAlertObserver {
    String userName;
    StockObservable observable;

    public MobileAlertObserver(String userName, StockObservable observable) {
        this.userName = userName;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMssgOnMobile(userName, "Product is in stock hurry up!");
    }

    private void sendMssgOnMobile(String userName, String s) {
        System.out.println("mssg sent to " + userName);
    }
}
