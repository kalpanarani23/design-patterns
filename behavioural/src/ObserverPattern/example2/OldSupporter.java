package ObserverPattern.example2;

public class OldSupporter extends Supporter {
    public OldSupporter(String favoriteTeam, int excitementLevel) {
        super(favoriteTeam, excitementLevel);
    }

    @Override
    protected void react() {
        if (excitementLevel > 7) {
            System.out.println("Old supporter stands up and applauds vigorously!");
        } else if (excitementLevel > 3) {
            System.out.println("Old supporter nods approvingly and says 'Good goal!'");
        } else {
            System.out.println("Old supporter gives a polite golf clap.");
        }
    }
}
