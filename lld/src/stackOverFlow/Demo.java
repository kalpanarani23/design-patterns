package stackOverFlow;

import stackOverFlow.entities.Answer;
import stackOverFlow.entities.Questions;
import stackOverFlow.entities.Tag;
import stackOverFlow.entities.User;
import stackOverFlow.enums.VoteType;
import stackOverFlow.searchingstrategy.SearchStrategy;
import stackOverFlow.searchingstrategy.TagSearchStrategy;
import stackOverFlow.searchingstrategy.UserSearchStrategy;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        StackOverFlow stackOverFlow = new StackOverFlow();
        User inoske = stackOverFlow.createUser("Inoske");
        User tanjiro = stackOverFlow.createUser("Taniro");
        User zenitsu = stackOverFlow.createUser("Zenitsu");
        
        // 2. Inoske posts a question
        System.out.println("--- Inoske posts a question ---");
        Tag javaTag = new Tag("java");
        Tag designPatternsTag = new Tag("design-patterns");
        List<Tag> tags = List.of(javaTag, designPatternsTag);
        Questions question = stackOverFlow.postQuestion(inoske.getUserId(), "How to implement Observer Pattern?", "Details about Observer Pattern...", tags);
        printReputations(inoske, tanjiro, zenitsu);

        System.out.println("\n--- Tanjiro and Zenitsu post answers ---");
        Answer tanjiroAnswer = stackOverFlow.postAnswer(tanjiro.getUserId(), question.getId(), "You can use the java.util.Observer interface.");
        Answer zenitsuAnswer = stackOverFlow.postAnswer(zenitsu.getUserId(), question.getId(), "A better way is to create your own Observer interface.");
        printReputations(inoske, tanjiro, zenitsu);

        // 4. Voting happens
        System.out.println("\n--- Voting Occurs ---");
        stackOverFlow.voteOnPost(inoske.getUserId(), question.getId(), VoteType.UP_VOTE); // Inoske upvotes her own question
        stackOverFlow.voteOnPost(tanjiro.getUserId(), zenitsuAnswer.getId(), VoteType.UP_VOTE); // Tanjiro upvotes Charlie's answer
        stackOverFlow.voteOnPost(inoske.getUserId(), tanjiroAnswer.getId(), VoteType.DOWN_VOTE); // zenitsu downvotes Bob's answer
        printReputations(inoske, tanjiro, zenitsu);

        System.out.println("\n--- Inoske Accept's Zenitsu answer ---");
        stackOverFlow.acceptAnswer(question.getId(), zenitsuAnswer.getId());
        printReputations(inoske, tanjiro, zenitsu);

        // 6. Search for questions
        System.out.println("\n--- (C) Combined Search: Questions by 'Inoske' with tag 'java' ---");
        List<SearchStrategy> filtersC = List.of(
                new UserSearchStrategy(inoske),
                new TagSearchStrategy(javaTag)
        );
        List<Questions> searchResults = stackOverFlow.searching(filtersC);
        searchResults.forEach(q -> System.out.println("  - Found: " + q.getTitle()));
    }

    private static void printReputations(User... users) {
        System.out.println("--- Current Reputations ---");
        for(User user : users) {
            System.out.printf("%s: %d\n", user.getUserName(), user.getReputationScore());
        }
    }

}
