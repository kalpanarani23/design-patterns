package bridge.remotecontroldevices;

public class Main {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl remote = new BasicRemoteControl(tv);
        remote.turnOn();
        remote.setChannel(101);
        remote.turnOff();

        Device radio = new Radio();
        RemoteControl radioRemote = new BasicRemoteControl(radio);
        radioRemote.turnOn();
        radioRemote.setChannel(202);
        radioRemote.turnOff();
    }
}
