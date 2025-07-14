package ratelimitingalgorithms;

import java.time.Instant;

public class SlidingWindowCounter {
    private final long windowSizeInSeconds;
    private final long maxRequestPerWindow;
    private long currentWindowStart;
    private long previousWindowCount;
    private long currentWindowCount;

    public SlidingWindowCounter(long windowSizeInSeconds, long maxRequestPerWindow) {
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.maxRequestPerWindow = maxRequestPerWindow;
        this.currentWindowStart = Instant.now().getEpochSecond();
        this.previousWindowCount = 0;
        this.currentWindowCount = 0;
    }


    public synchronized boolean allowRequest() {
        long now = Instant.now().getEpochSecond();
        long timePassedInWindow = now - currentWindowStart;

        if (timePassedInWindow >= windowSizeInSeconds) {
            previousWindowCount = currentWindowCount;
            currentWindowCount = 0;
            currentWindowStart = now;
            timePassedInWindow = 0;
        }

        double d  =0.0;
        return false;
    }
}
