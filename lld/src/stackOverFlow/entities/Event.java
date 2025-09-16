package stackOverFlow.entities;

import stackOverFlow.enums.EventType;

public class Event {
    private final EventType eventType;
    private final User user;
    private final Post targetPost;

    public Event(EventType eventType, User user, Post targetPost) {
        this.eventType = eventType;
        this.user = user;
        this.targetPost = targetPost;
    }

    public EventType getEventType() {
        return eventType;
    }

    public User getUser() {
        return user;
    }

    public Post getTargetPost() {
        return targetPost;
    }
}
