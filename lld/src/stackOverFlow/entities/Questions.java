package stackOverFlow.entities;

import stackOverFlow.enums.EventType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Questions extends Post {
    private final String title;
    private final List<Answer> answers = new ArrayList<>();
    private final List<Tag> tags;
    private Answer acceptedAnswer;


    public Questions(String title, String body, User user, List<Tag> tags) {
        super(UUID.randomUUID().toString(), body, user);
        this.title = title;
        this.tags = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addAnswer(Answer answer){
        answers.add(answer);
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public synchronized void acceptAnswer(Answer answer) {
        if (!this.user.getUserId().equals(answer.getUser().getUserId()) && this.acceptedAnswer == null) {
            this.acceptedAnswer = answer;
            answer.setAccepted(true);
            notifyObserver(new Event(EventType.ACCEPT_ANSWER, answer.getUser(), answer));
        }
    }

    public List<Tag> getTags() {
        return tags;
    }
}
