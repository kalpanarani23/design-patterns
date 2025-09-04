package bridge.appvideoquality;

public class Netflix extends StreamingApp {
    public Netflix(VideoQuality videoQuality) {
        super(videoQuality);
    }

    @Override
    public void playing(String title) {
        System.out.print("Netflix : ");
        videoQuality.playVideo(title);
    }
}
