package bridge.appvideoquality;

public class PrimeVideo extends StreamingApp {
    public PrimeVideo(VideoQuality videoQuality) {
        super(videoQuality);
    }

    @Override
    public void playing(String title) {
        System.out.print("Prime Video: ");
        videoQuality.playVideo(title);
    }
}
