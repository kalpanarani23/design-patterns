package lowleveldesign.src.structural.proxy.example2;

public class RealInternet implements Internet{

    @Override
    public void connectTo(String serverHost) {
        System.out.println("Connecting to " + serverHost);
    }
}
