package ObserverPattern.example3;

import java.util.ArrayList;
import java.util.List;

public class StockMarketImpl implements StockMarket {
    List<StockObserver> observerList = new ArrayList<>();

    @Override
    public void register(StockObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(StockObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notify(String symbol, Double price) {
        for (StockObserver ob : observerList) {
            ob.update(symbol, price);
        }
    }

    public void setStockPrice(String stockSymbol, Double stockPrice) {
        notify(stockSymbol, stockPrice);
    }


}
