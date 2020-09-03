package exam.paperContext.userInterface.DTO;

import exam.paperContext.domain.model.blankquiz.BlankQuiz;
import exam.paperContext.domain.model.blankquiz.BlankQuizId;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlankQuizDTO {
    private BlankQuizId blankQuizId;

    private String teacherId;

    private String content;

    private String referenceAnswer;

    private int score;

    public static BlankQuizDTO from(BlankQuiz blankQuiz) {
        return BlankQuizDTO.builder()
            .blankQuizId(blankQuiz.getBlankQuizId())
            .teacherId(blankQuiz.getTeacherId())
            .content(blankQuiz.getContent())
            .referenceAnswer(blankQuiz.getReferenceAnswer())
            .score(blankQuiz.getScore())
            .build();
    }
}
