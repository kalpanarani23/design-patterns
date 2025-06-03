package adapter;

public class PriceServiceAdapterInd implements PriceServiceAdapter{
    private PriceService priceService; //has-a

    public PriceServiceAdapterInd() {
        priceService = new ConsumablePriceService();
    }

    //returns the price for the given product in Indian currency
    @Override
    public double getPrice(String productId) {

        double price = priceService.getPriceInDollar(productId);

        return price * 82.0;
    }
}
