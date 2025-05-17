package lowleveldesign.src.structural.proxy.example2;

public class Main {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        try {
            // This will work
            internet.connectTo("allowed.com");

            // This will throw an exception
            internet.connectTo("banned2.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
