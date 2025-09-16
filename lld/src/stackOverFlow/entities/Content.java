package stackOverFlow.entities;


import java.util.Date;

//Base class for common attributes
public abstract class Content {
    protected final String id;
    protected final String body;
    protected final User user;
    protected final long creationTime;


    Content(String id, String body, User user) {
        this.id = id;
        this.body = body;
        this.user = user;
        this.creationTime = new Date().getTime();
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public User getUser() {
        return user;
    }
}
