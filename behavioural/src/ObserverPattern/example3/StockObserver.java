package ObserverPattern.example3;

public interface StockObserver {
    void update(String stockSymbol, Double price);
}
