package facade.hometheater;

public class Main {
    public static void main(String[] args) {
        //IF FACADE DESIGN PATTERN WAS NOT THERE WE NEED TO CREATE INDIVIDUAL OBJECTS OF SUBSYSTEM!
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        StreamingPlayer streamingPlayer = new StreamingPlayer();
        Lights lights = new Lights();
        PopcornMaker popcornMaker = new PopcornMaker();

        // Create facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(projector, soundSystem,
                streamingPlayer, lights,
                popcornMaker);

        // Use the facade to watch a movie
        homeTheater.watchMovie("Inception");
        System.out.println("\n--- Movie is playing ---\n");

        // Use the facade to end the movie
        homeTheater.endMovie();
    }
}
