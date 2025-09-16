package stackOverFlow.entities;

import java.util.UUID;

public class Answer extends Post {

    private Boolean isAccepted = false;

    public Answer(String body, User user) {
        super(UUID.randomUUID().toString(), body, user);
    }

    public Boolean getAccepted() {
        return isAccepted;
    }

    public void setAccepted(Boolean accepted) {
        isAccepted = accepted;
    }
}
