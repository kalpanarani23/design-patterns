package ObserverPattern.example3;

public class Investor implements StockObserver{
    String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, Double price) {
        System.out.println(name + "received an update " + stockSymbol + " $" + price);
    }
}
