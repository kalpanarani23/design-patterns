package stackOverFlow.searchingstrategy;

import stackOverFlow.entities.Questions;
import stackOverFlow.entities.User;

import java.util.List;

public class UserSearchStrategy implements SearchStrategy{
    private final User user;

    public UserSearchStrategy(User user) {
        this.user = user;
    }

    @Override
    public List<Questions> filter(List<Questions> questions) {
        return questions.stream().filter(ques -> ques.getUser().getUserName().equalsIgnoreCase(user.getUserName())).toList();
    }
}
