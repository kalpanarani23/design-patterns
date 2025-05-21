package ObserverPattern.example1.Observer;


import ObserverPattern.example1.Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
    String emailId;
    StockObservable observable;

    public EmailAlertObserverImpl(String emailId, StockObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmail(emailId, "Product is in stock");
    }

    private void sendEmail(String emailId, String productIsInStock) {
        System.out.printf("Mail send to : " + emailId);
    }
}
