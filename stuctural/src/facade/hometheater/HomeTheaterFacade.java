package facade.hometheater;

public class HomeTheaterFacade {
    private Projector projector;
    private SoundSystem soundSystem;
    private StreamingPlayer streamingPlayer;
    private Lights lights;
    private PopcornMaker popcornMaker;

    public HomeTheaterFacade(Projector projector, SoundSystem soundSystem, StreamingPlayer streamingPlayer,
                             Lights lights, PopcornMaker popcornMaker) {
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.streamingPlayer = streamingPlayer;
        this.lights = lights;
        this.popcornMaker = popcornMaker;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popcornMaker.on();
        popcornMaker.pop();

        lights.dim(10);
        projector.on();
        projector.wideScreenMode();

        soundSystem.on();
        soundSystem.setVolume(5);

        streamingPlayer.on();
        streamingPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater...");
        popcornMaker.off();
        lights.on();
        projector.off();
        soundSystem.off();
        streamingPlayer.stop();
        streamingPlayer.off();
    }
}
