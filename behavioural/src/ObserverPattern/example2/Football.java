package ObserverPattern.example2;

import java.util.ArrayList;
import java.util.List;

public class Football implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
        System.out.println("New supporter is watching the game");
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
        System.out.println("A supporter left the game");
    }

    @Override
    public void notifyObservers(String team) {
        for (Observer observer : observers) {
            observer.update(team);
        }
    }

    // This method is called when a team scores a goal
    public void goalScored(String team) {
        System.out.println("\nGOAL! " + team + " has scored!");
        notifyObservers(team);
    }
}
