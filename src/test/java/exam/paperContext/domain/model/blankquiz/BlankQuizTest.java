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
}
