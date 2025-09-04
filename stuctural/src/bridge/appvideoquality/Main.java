package bridge.appvideoquality;

public class Main {

    public static void main(String[] args) {
        VideoQuality videoQuality = new HDquality();
        StreamingApp netflix = new Netflix(videoQuality);
        netflix.playing("JOHN WICK");
    }
}
