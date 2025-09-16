package stackOverFlow.searchingstrategy;

import stackOverFlow.entities.Questions;
import stackOverFlow.entities.Tag;

import java.util.List;
import java.util.stream.Collectors;

public class TagSearchStrategy implements SearchStrategy{
    private final Tag tag;

    public TagSearchStrategy(Tag tag) {
        this.tag = tag;
    }

    @Override
    public List<Questions> filter(List<Questions> questions) {
        return questions.stream()
                .filter(q -> q.getTags().stream()
                        .anyMatch(t -> t.getTagName().equalsIgnoreCase(tag.getTagName())))
                .collect(Collectors.toList());
    }
}
