package stackOverFlow.entities;

import stackOverFlow.*;
import stackOverFlow.enums.EventType;
import stackOverFlow.enums.VoteType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Post extends Content {
    private final AtomicInteger voteCount = new AtomicInteger(0);
    private final Map<String, VoteType> voters = new ConcurrentHashMap<>(); //storing voting corresponding to a user
    private final List<Comment> comments = new ArrayList<>();
    private final List<PostObserver> postObserverList = new ArrayList<>();

    Post(String id, String body, User user) {
        super(id, body, user);
    }

    public void addObservers(PostObserver postObserver) {
        postObserverList.add(postObserver);
    }


    public void notifyObserver(Event event) {
        postObserverList.forEach(postObserver -> postObserver.update(event));
    }

    public synchronized void vote(User user, VoteType voteType) {
        String userId = user.getUserId();
        if (voters.get(userId) == voteType) {
            System.out.println("Already voted");
            return;
        }

        int score = 0;
        if (voters.containsKey(userId)) {
            score = voteType == VoteType.UP_VOTE ? 2 : -2;
        } else {
            score = voteType == VoteType.UP_VOTE ? 1 : -1;
        }

        voters.put(userId, voteType);
        voteCount.getAndAdd(score);

        EventType eventType = EventType.UPVOTE_QUESTION;
        if (this instanceof Questions) {
            eventType = (voteType == VoteType.UP_VOTE ? EventType.UPVOTE_QUESTION : EventType.DOWN_VOTE_QUESTION);
        } else {
            eventType = (voteType == VoteType.UP_VOTE ? EventType.UPVOTE_ANSWER : EventType.DOWNVOTE_ANSWER);
        }
        notifyObserver(new Event(eventType, user, this));
    }


}
