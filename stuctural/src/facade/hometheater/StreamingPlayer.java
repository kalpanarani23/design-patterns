package facade.hometheater;

public class StreamingPlayer {
    public void on() {
        System.out.println("Streaming Player is ON");
    }

    public void off() {
        System.out.println("Streaming Player is OFF");
    }

    public void play(String movie) {
        System.out.println("Playing \"" + movie + "\" on Streaming Player");
    }

    public void stop() {
        System.out.println("Stopped Streaming Player");
    }
}
