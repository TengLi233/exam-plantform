package exam.paperContext.infrastructure;

import exam.paperContext.domain.model.blankquiz.BlankQuiz;
import exam.paperContext.domain.model.blankquiz.BlankQuizId;
import exam.paperContext.domain.model.blankquiz.BlankQuizRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class MemoryBlankQuizRepository implements BlankQuizRepository {
    private Set<BlankQuiz> blankQuizList = new HashSet<>();

    @Override
    public BlankQuiz find(BlankQuizId blankQuizId) {
        return blankQuizList.stream()
            .filter(blankQuiz -> blankQuiz.getBlankQuizId().sameValueAs(blankQuizId))
            .findFirst()
            .orElse(null);
    }

    @Override
    public BlankQuiz save(BlankQuiz blankQuiz) {
        this.blankQuizList.add(blankQuiz);
        return blankQuiz;
    }

    @Override
    public void delete(BlankQuiz blankQuiz) {
        blankQuizList.remove(blankQuiz);
    }

    @Override
    public List<BlankQuiz> getAll() {
        return new ArrayList<>(blankQuizList);
    }
}
