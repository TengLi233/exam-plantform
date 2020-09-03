package exam.paperContext.application;

import exam.paperContext.domain.model.blankquiz.BlankQuiz;
import exam.paperContext.domain.model.blankquiz.BlankQuizId;
import exam.paperContext.domain.model.blankquiz.BlankQuizRepository;
import exam.paperContext.userInterface.DTO.BlankQuizDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class BlankQuizApplicationService {
    private final BlankQuizRepository blankQuizRepository;

    public BlankQuiz create(BlankQuizDTO blankQuizDTO) {
        BlankQuiz blankQuiz = BlankQuiz
            .create(blankQuizDTO.getTeacherId(), blankQuizDTO.getContent(), blankQuizDTO.getReferenceAnswer(), blankQuizDTO.getScore());
        return blankQuizRepository.save(blankQuiz);
    }

    public List<BlankQuiz> getAll() {
        return blankQuizRepository.getAll();
    }

    public void revise(String id, BlankQuizDTO blankQuizDTO) {
        BlankQuizId blankQuizId = new BlankQuizId(id);
        BlankQuiz blankQuiz = blankQuizRepository.find(blankQuizId);
        if (isNull(blankQuiz)) {
            throw new BlankQuizNotFoundException(id);
        }
        blankQuiz.revise(blankQuizDTO.getTeacherId(), blankQuizDTO.getContent(), blankQuizDTO.getReferenceAnswer(), blankQuizDTO.getScore());
        blankQuizRepository.save(blankQuiz);
    }

    public void delete(String id) {
        BlankQuiz blankQuiz = get(id);
        blankQuizRepository.delete(blankQuiz);
    }

    public BlankQuiz get(String id) {
        return blankQuizRepository.find(new BlankQuizId(id));
    }
}
