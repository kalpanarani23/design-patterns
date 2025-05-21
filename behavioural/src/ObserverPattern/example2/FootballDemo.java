package ObserverPattern.example2;

public class FootballDemo {
    public static void main(String[] args) {
        // Create the subject
        Football game = new Football();

        // Create observers
        Observer youngFan1 = new YoungSupporter("Barcelona", 9);
        Observer youngFan2 = new YoungSupporter("Real Madrid", 6);
        Observer oldFan1 = new OldSupporter("Barcelona", 5);
        Observer oldFan2 = new OldSupporter("Real Madrid", 8);

        // Register observers to the subject
        game.attach(youngFan1);
        game.attach(youngFan2);
        game.attach(oldFan1);
        game.attach(oldFan2);

        // Simulate game events
        game.goalScored("Barcelona");

        System.out.println("\nHalf time...\n");

        // One supporter leaves
        game.detach(oldFan2);

        // Second half goal
        game.goalScored("Real Madrid");
    }
}
