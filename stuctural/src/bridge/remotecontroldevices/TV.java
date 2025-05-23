package bridge.remotecontroldevices;

public class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("Turn on tv");
    }

    @Override
    public void turnOff() {
        System.out.println("turn off tv");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("change the tv channel to ");
    }
}
