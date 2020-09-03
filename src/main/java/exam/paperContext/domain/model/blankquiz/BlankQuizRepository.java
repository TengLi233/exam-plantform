package exam.paperContext.domain.model.blankquiz;

import java.util.List;

public interface BlankQuizRepository {
    BlankQuiz find(BlankQuizId blankQuizId);

    List<BlankQuiz> getAll();

    BlankQuiz save(BlankQuiz blankQuiz);

    void delete(BlankQuiz blankQuiz);

}
