package stackOverFlow;

import stackOverFlow.entities.*;
import stackOverFlow.enums.EventType;
import stackOverFlow.enums.VoteType;
import stackOverFlow.searchingstrategy.SearchStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//facade design pattern --
// we use when we don't want to expose or don't want our client to know the inter complexities
public class StackOverFlow {
    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final Map<String, Questions> questions = new ConcurrentHashMap<>();
    private final Map<String, Answer> answers = new ConcurrentHashMap<>();
    private final PostObserver reputationManager = new ReputationManager();


    public User createUser(String name) {
        User user = new User(name);
        users.put(user.getUserId(), user);
        return user;
    }


    public Questions postQuestion(String userId, String title, String content, List<Tag> tags) {
        Questions question = new Questions(title, content, users.get(userId), tags);
        question.addObservers(reputationManager);
        questions.put(question.getId(), question);
        return question;
    }


    public Answer postAnswer(String userId, String questionId, String content) {
        Answer answer = new Answer(content, users.get(userId));
        Questions questions1 = questions.get(questionId);
        questions1.addAnswer(answer);
        answer.addObservers(reputationManager);
        answers.put(answer.getId(), answer);
        return answer;
    }

    public User getUserById(String userId) {
        return users.get(userId);
    }


    public void acceptAnswer(String questionId, String answerId) {
        Questions question = questions.get(questionId);
        question.acceptAnswer(answers.get(answerId));
    }

    public List<Questions> searching(List<SearchStrategy> searchStrategy) {
        List<Questions> result = new ArrayList<>(questions.values());

        for (SearchStrategy search : searchStrategy) {
            result = search.filter(result);
        }
        return result;
    }


    public void voteOnPost(String userId, String postId, VoteType voteType) {
        User user = users.get(userId);
        Post post;
        if (questions.containsKey(postId)) {
            post = questions.get(postId);
        } else if (answers.containsKey(postId)) {
            post = answers.get(postId);
        } else {
            throw new IllegalArgumentException("POST NOT AVAILABLE");
        }
        post.vote(user, voteType);
    }
}
