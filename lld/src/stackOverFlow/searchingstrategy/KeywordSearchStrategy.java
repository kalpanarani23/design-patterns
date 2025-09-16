package stackOverFlow.searchingstrategy;

import stackOverFlow.entities.Questions;

import java.util.List;

public class KeywordSearchStrategy implements SearchStrategy{
    private final String keyword;

    public KeywordSearchStrategy(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public List<Questions> filter(List<Questions> questions) {
        return questions.stream().filter(ques -> ques.getTitle().equals(keyword) || ques.getBody().contains(keyword))
                .toList();
    }
}
