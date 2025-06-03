package ratelimitingalgorithms;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class LeakyBucket {

    public LeakyBucket(int capacity, int leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
        this.bucket = new LinkedList<>();
        this.lastFillTimestamp = Instant.now();
    }

    private final int capacity;
    private final int leakRate;
    private Queue<Instant> bucket;
    private Instant lastFillTimestamp;

    public boolean allowRequest() {
        refill_request();
        if (bucket.size() < capacity) {
            bucket.offer(Instant.now());
            return true;
        }
        return false;
    }

    private void refill_request() {
        Instant now = Instant.now();
        long elapsedMillis = now.toEpochMilli() - lastFillTimestamp.toEpochMilli();
        int leakedItems = (int) (elapsedMillis * leakRate / 1000.0);  // Calculate how many items should have leaked

        // Remove the leaked items from the bucket
        for (int i = 0; i < leakedItems && !bucket.isEmpty(); i++) {
            bucket.poll();
        }
        lastFillTimestamp = now;
    }

}
