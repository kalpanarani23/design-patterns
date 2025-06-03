package adapter;

public class Client {
    private static PriceServiceAdapter priceServiceAdapter; //has-a

    public static void main(String[] args) {
        priceServiceAdapter = new PriceServiceAdapterInd();

        String productId = "sampleProductId";
        double priceInRup = priceServiceAdapter.getPrice(productId);

        System.out.println("Product price is {}" + priceInRup);
    }

}
