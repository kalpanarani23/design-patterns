package ratelimitingalgorithms;

import java.time.Instant;

public class FixedWindowCounter {
    private final long windowSizeInSeconds;  // Size of each window in seconds
    private final long maxRequestsPerWindow; // Maximum number of requests allowed per window
    private long currentWindowStart;         // Start time of the current window
    private long requestCount;

    public FixedWindowCounter(long windowSizeInSeconds, long maxRequestsPerWindow) {
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.maxRequestsPerWindow = maxRequestsPerWindow;
        this.currentWindowStart = Instant.now().getEpochSecond();
        this.requestCount = 0;
    }


    public boolean allow_request() {
        long now = Instant.now().getEpochSecond();

        if (now - currentWindowStart >= windowSizeInSeconds) {
            currentWindowStart = now;
            requestCount = 0;
        }

        if (requestCount < maxRequestsPerWindow) {
            requestCount++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        FixedWindowCounter fixedWindowCounter = new FixedWindowCounter(60, 12);
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.println(fixedWindowCounter.allow_request());
        }
    }


}
