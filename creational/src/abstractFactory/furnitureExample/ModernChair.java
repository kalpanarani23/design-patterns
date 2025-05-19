package abstractFactory.furnitureExample;

public class ModernChair implements Chair {
    @Override
    public void sit() {
        System.out.println("Sitting on a modern chair.");
    }
}
