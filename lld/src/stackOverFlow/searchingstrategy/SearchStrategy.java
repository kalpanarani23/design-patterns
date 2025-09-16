package stackOverFlow.searchingstrategy;

import stackOverFlow.entities.Questions;

import java.util.List;

public interface SearchStrategy {
    List<Questions> filter(List<Questions> questions);

}
