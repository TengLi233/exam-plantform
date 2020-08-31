package exam.paperContext.domain.model.blankquiz;

import exam.paperContext.shared.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = {"blankQuizId"})
public class BlankQuiz implements Entity<BlankQuiz> {
    private BlankQuizId blankQuizId;

    private String teacherId;

    private String content;

    private String referenceAnswer;

    private int score;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    private BlankQuiz(String teacherId, String content, String referenceAnswer, int score) {
        this.blankQuizId = BlankQuizId.nextId();
        this.teacherId = teacherId;
        this.content = content;
        this.referenceAnswer = referenceAnswer;
        this.score =score;
        this.createdTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
    }

    public static BlankQuiz create(String teacherId, String content, String referenceAnswer, int score) {
        BlankQuiz blankQuiz = new BlankQuiz(teacherId, content, referenceAnswer, score);
        return blankQuiz;
    }


    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return this.blankQuizId.equals(other.getBlankQuizId());
    }
}
