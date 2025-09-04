package bridge.navigation;

public class AppleMaps implements NavigationImpl {
    @Override
    public void navigateTo(String destination) {
        System.out.println("Apple Maps...");
    }
}
