package bridge.navigation;

public class UberDemo {

    public static void main(String[] args) {
        UberRide uberRide = new UberRide("KKKKKK");
        UberEats uberEats = new UberEats("Parwat");

        GoogleMaps googleMaps = new GoogleMaps();
        AppleMaps appleMaps = new AppleMaps();

        uberEats.setNavigationImpl(googleMaps);
        uberEats.navigate("VIBE");

    }
}
