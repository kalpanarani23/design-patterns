package bridge.appvideoquality;

public class LowQuality implements VideoQuality{
    @Override
    public void playVideo(String title) {
        System.out.println("Playing in " + title + "in low quality 520p...");
    }
}
