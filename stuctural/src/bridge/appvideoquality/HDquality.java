package bridge.appvideoquality;

public class HDquality implements VideoQuality {
    @Override
    public void playVideo(String title) {
        System.out.println("Playing " + title + "in  1080p HD quality");
    }
}
