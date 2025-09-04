package ObserverPattern.example3;

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarketImpl();

        StockObserver observer1 = new Investor("A1");
        StockObserver observer2 = new Investor("A2");

        stockMarket.register(observer1);
        stockMarket.register(observer2);

        stockMarket.notify("NIFTY", 20.2);
        stockMarket.remove(observer1);
        
        stockMarket.notify("NIFTY", 2.3);

    }
}
