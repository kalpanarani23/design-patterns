package bridge.remotecontroldevices;

public interface Device {
    void turnOn();
    void turnOff();
    void setChannel(int channel);
}
