package lowleveldesign.src.structural.proxy.example2;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet{

    private Internet realInternet = new RealInternet();
    private static List<String> bannedSites;

    static {
        bannedSites = new ArrayList<String>();
        bannedSites.add("banned1.com");
        bannedSites.add("banned2.com");
        bannedSites.add("banned3.com");
    }

    @Override
    public void connectTo(String serverHost) throws Exception {
        if (bannedSites.contains(serverHost)) {
            throw new Exception("Access Denied to " + serverHost);
        }

        realInternet.connectTo(serverHost);
    }


}
