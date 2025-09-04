package bridge.appvideoquality;

public class FullHDquality implements VideoQuality {
    @Override
    public void playVideo(String title) {
        System.out.println("Playing " + title + "in full HD 2010p...");
    }
}
