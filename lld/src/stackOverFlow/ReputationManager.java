package stackOverFlow;

import stackOverFlow.entities.Event;
import stackOverFlow.entities.User;

public class ReputationManager implements PostObserver {
    @Override
    public void update(Event event) {
        User postAuthor = event.getUser();
        switch (event.getEventType()) {
            case ACCEPT_ANSWER -> postAuthor.setReputationScore(15);
            case DOWN_VOTE_QUESTION, DOWNVOTE_ANSWER -> {
                postAuthor.setReputationScore(-1);
                event.getUser().setReputationScore(-2);
            }
            case UPVOTE_ANSWER -> postAuthor.setReputationScore(5);
            case UPVOTE_QUESTION -> postAuthor.setReputationScore(5);

        }
    }
}
