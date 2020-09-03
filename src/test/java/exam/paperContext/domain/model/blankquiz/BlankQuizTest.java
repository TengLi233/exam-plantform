package exam.paperContext.domain.model.blankquiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BlankQuizTest {
    @Test
    void should_create_blank_quiz_with_factory_method() {
        String teacherId = "teacherId";
        String content = "Test";
        int score = 12;
        String referenceAnswer = "Test answer";

        BlankQuiz blankQuiz = BlankQuiz.create(teacherId, content, referenceAnswer, score);

        assertNotNull(blankQuiz);
        assertEquals(teacherId, blankQuiz.getTeacherId());
        assertEquals(content, blankQuiz.getContent());
        assertEquals(score, blankQuiz.getScore());
        assertEquals(referenceAnswer, blankQuiz.getReferenceAnswer());
    }

    @Test
    void should_revise_blank_quiz_given_new_attribution() {
        String teacherId = "teacherId";
        String content = "Test";
        int score = 10;
        String referenceAnswer = "Test answer";

        String updatedTeacherId = "teacherId-1";
        String updatedContent = "Test-1";
        int updatedScore = 25;
        String updatedReferenceAnswer = "Test answer-1";

        BlankQuiz blankQuiz = BlankQuiz.create(teacherId, content, referenceAnswer, score);
        BlankQuizId id = blankQuiz.getBlankQuizId();
        blankQuiz.revise(updatedTeacherId, updatedContent, updatedReferenceAnswer, updatedScore);

        assertEquals(id, blankQuiz.getBlankQuizId());
        assertEquals(updatedTeacherId, blankQuiz.getTeacherId());
        assertEquals(updatedContent, blankQuiz.getContent());
        assertEquals(updatedScore, blankQuiz.getScore());
        assertEquals(updatedReferenceAnswer, blankQuiz.getReferenceAnswer());
    }
}
