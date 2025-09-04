package bridge.navigation;

public class UberRide implements NavigationSystem {
    String driverName;
    NavigationImpl navigationImpl;

    public UberRide(String driverName) {
        this.driverName = driverName;
    }

    public void setNavigationImpl(NavigationImpl navigationImpl) {
        this.navigationImpl = navigationImpl;
    }

    @Override
    public void navigate(String destination) {
        System.out.print("Uber ride with " + driverName + " to destination " + destination + " using ");
        navigationImpl.navigateTo(destination);
    }
}
