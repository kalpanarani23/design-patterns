package bridge.appvideoquality;

public abstract class StreamingApp {
    VideoQuality videoQuality;

    public StreamingApp(VideoQuality videoQuality) {
        this.videoQuality = videoQuality;
    }

    public abstract void playing(String title);
}
