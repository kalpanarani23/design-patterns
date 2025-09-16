package stackOverFlow.entities;


import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private String userId;
    private String userName;
    private AtomicInteger reputationScore;
    private long creationDate;

    public User(String userName) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
        this.reputationScore = new AtomicInteger(0);
        this.creationDate = new Date().getTime();
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getReputationScore() {
        return reputationScore.get();
    }

    public void setReputationScore(int reputationScore) {
        this.reputationScore.getAndAdd(reputationScore);
    }

    public long getCreationDate() {
        return creationDate;
    }
}
