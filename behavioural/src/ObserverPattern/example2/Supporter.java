package ObserverPattern.example2;

public abstract class Supporter implements Observer {
    protected String favoriteTeam;
    protected int excitementLevel; // 1-10

    public Supporter(String favoriteTeam, int excitementLevel) {
        this.favoriteTeam = favoriteTeam;
        this.excitementLevel = excitementLevel;
    }

    @Override
    public void update(String team) {
        if (team.equals(favoriteTeam)) {
            react();
        } else {
            System.out.println("A supporter of " + favoriteTeam + " looks disappointed.");
        }
    }

    // Different types of supporters will implement this differently
    protected abstract void react();
}
