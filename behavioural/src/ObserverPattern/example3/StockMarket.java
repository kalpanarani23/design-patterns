package ObserverPattern.example3;


//The Subject
public interface StockMarket {

    void register(StockObserver observer);

    void remove(StockObserver observer);

    void notify(String symbol, Double price);
}
