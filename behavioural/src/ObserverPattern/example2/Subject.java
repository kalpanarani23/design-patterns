package ObserverPattern.example2;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(String team);
}
