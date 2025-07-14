package ratelimitingalgorithms;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowLog {
    private final long windowSizeInSeconds;  // Size of each window in seconds
    private final long maxRequestsPerWindow; // Maximum number of requests allowed per window
    private Queue<Long> requestLog;          // Log of request timestamps

    public SlidingWindowLog(long windowSizeInSeconds, long maxRequestsPerWindow) {
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.maxRequestsPerWindow = maxRequestsPerWindow;
        this.requestLog = new LinkedList<>();
    }

    synchronized boolean allow_request() {
        long now = Instant.now().getEpochSecond();
        long windowStart = now - windowSizeInSeconds;
        while (!requestLog.isEmpty() && requestLog.peek() <= windowStart) {
            requestLog.poll();
        }

        if (requestLog.size() < maxRequestsPerWindow) {
            requestLog.offer(now);
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws InterruptedException {
        SlidingWindowLog slidingWindowLog = new SlidingWindowLog(60, 5);
        for (int i = 0; i < 10; i++) {
            System.out.println(slidingWindowLog.allow_request());
            Thread.sleep(80);
        }
    }
}
