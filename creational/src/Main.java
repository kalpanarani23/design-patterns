import singleton.EagerSingleton;
import singleton.EnumSingleton;
import singleton.LazySingleton;

public class Main {
    public static void main(String[] args) {
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
        System.out.println("hascode : " + eagerSingleton1.hashCode());
        System.out.println("hascode : " + eagerSingleton.hashCode());


        LazySingleton lazySingleton = LazySingleton.getInstance();
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        System.out.println("lazy " + lazySingleton1.hashCode());
        System.out.println("lazy " + lazySingleton.hashCode());

        EnumSingleton.INSTANCE.getInfo();

    }
}