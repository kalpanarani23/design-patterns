package abstractFactory.furnitureExample;

public class VintageFurnitureFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new VintageChair();
    }

    @Override
    public Table createTable() {
        return new VintageTable();
    }
}
