import abstractFactory.phoneExample.PhoneStore;
import abstractFactory.phoneExample.Phone;

public class Main {
    public static void main(String[] args) {
//        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
//        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
//        System.out.println("hascode : " + eagerSingleton1.hashCode());
//        System.out.println("hascode : " + eagerSingleton.hashCode());
//
//
//        LazySingleton lazySingleton = LazySingleton.getInstance();
//        LazySingleton lazySingleton1 = LazySingleton.getInstance();
//        System.out.println("lazy " + lazySingleton1.hashCode());
//        System.out.println("lazy " + lazySingleton.hashCode());
//
//        EnumSingleton.INSTANCE.getInfo();
//
//
//        var b = new Phoneb.PhoneBuilder()
//                .setCamera("2MP")
//                .setBattry("8000MH")
//                .setRam("4gb")
//                .setCpu("octa")
//                .setJack(true)
//                .setNetworkType("4g")
//                .build();
//        System.out.println(b.getCamera() +" " + b.getBattry());
//
//        Coffee coffee = new Coffee.CoffeeBuilder().setCoffeeType("Cap").build();
//        System.out.println(coffee.getCoffeeType());


//        ShapeFactory shapeFactory = new ShapeFactory();
//        shapeFactory.createShape("circle").draw();
//        shapeFactory.createShape("rectangle").erase();

//        for static factory pattern
//        Shape shapeFactory = Circle.doGetCircle();
//        shapeFactory.erase();

        Phone phone = PhoneStore.getPhone("Apple","iphone14");
        phone.getDescription();
        System.out.println();
        Phone phone1 = PhoneStore.getPhone("Apple","iphone13");
        phone1.getDescription();

    }
}