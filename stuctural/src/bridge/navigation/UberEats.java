package bridge.navigation;

public class UberEats implements NavigationSystem {
    String restaurantName;
    NavigationImpl navigationImpl;

    public void setNavigationImpl(NavigationImpl navigationImpl) {
        this.navigationImpl = navigationImpl;
    }

    UberEats(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Override
    public void navigate(String destination) {
        System.out.println("Uber Eats delivery from " + restaurantName + " to " + destination + " using ");
        navigationImpl.navigateTo(destination);
    }
}
