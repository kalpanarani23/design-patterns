package ratelimitingalgorithms;

import java.util.Calendar;
import java.util.Map;

public class BucketToken {
    private final int capacity;
    private final double fillRate;
    private double tokenLeft;
    private long lastFillTimestamp;


    BucketToken(int capacity, double fillRate){
        this.capacity = capacity;
        this.fillRate = fillRate;
        this.tokenLeft = capacity;
        lastFillTimestamp = Calendar.getInstance().getTimeInMillis();
    }

    public double getTokensLeft() {
        refill(); // ensure we get current count
        return tokenLeft;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getFillRate() {
        return fillRate;
    }


    public synchronized boolean allow_request(int tokenRequested) {
        refill();

        if (this.tokenLeft < tokenRequested){
            return false;
        }

        this.tokenLeft -= tokenRequested;
        return true;
    }

    private void refill() {
        long now = Calendar.getInstance().getTimeInMillis();
        double fill = (now - lastFillTimestamp) * fillRate / 1000.0;
        this.tokenLeft = Math.min(capacity, fill + tokenLeft);
        this.lastFillTimestamp = now;
    }


    public static void main(String[] args) throws InterruptedException {
        BucketToken bucketToken = new BucketToken(10, 2.0);
        for (int i = 0; i < 15; i++) {
            int tokensToRequest = 1; // Request 1 token each time
            boolean allowed = bucketToken.allow_request(tokensToRequest);
            System.out.printf("Request %d token -> %s (%.2f tokens left)%n",
                    tokensToRequest, allowed ? "ALLOWED" : "DENIED", bucketToken.getTokensLeft());

            // Add small delay to see refill in action
            Thread.sleep(100);
        }


        System.out.println("\nTesting burst scenario:");
        // Wait for bucket to refill
        Thread.sleep(2000);

        // Try to consume all tokens at once
        for (int i = 1; i <= 12; i++) {
            boolean allowed = bucketToken.allow_request(i);
            System.out.printf("Request %d tokens -> %s (%.2f tokens left)%n",
                    i, allowed ? "ALLOWED" : "DENIED", bucketToken.getTokensLeft());
        }
    }



}
