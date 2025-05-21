package ObserverPattern.example2;

public class YoungSupporter extends Supporter {
    public YoungSupporter(String favoriteTeam, int excitementLevel) {
        super(favoriteTeam, excitementLevel);
    }

    @Override
    protected void react() {
        if (excitementLevel > 7) {
            System.out.println("Young supporter jumps wildly and screams at the top of their lungs!");
        } else if (excitementLevel > 3) {
            System.out.println("Young supporter claps enthusiastically and cheers!");
        } else {
            System.out.println("Young supporter smiles and nods appreciatively.");
        }
    }
}
