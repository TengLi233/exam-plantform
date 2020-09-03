package exam.paperContext.userInterface;

import exam.paperContext.application.BlankQuizApplicationService;
import exam.paperContext.domain.model.blankquiz.BlankQuiz;
import exam.paperContext.userInterface.DTO.BlankQuizDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@AllArgsConstructor
public class BlankQuizController {
    private final BlankQuizApplicationService blankQuizApplicationService;

    @PostMapping("/blank-quiz")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    BlankQuizDTO create(@RequestBody BlankQuizDTO blankQuizDTO) {
        BlankQuiz blankQuiz = blankQuizApplicationService.create(blankQuizDTO);
        return BlankQuizDTO.from(blankQuiz);
    }

    @GetMapping("/blank-quizzes")
    List<BlankQuizDTO> getAll() {
        return blankQuizApplicationService.getAll().stream()
            .map(BlankQuizDTO::from)
            .collect(toList());
    }

    @PutMapping("/blank-quiz/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void revise(@PathVariable String id, @RequestBody BlankQuizDTO blankQuizDTO) {
        blankQuizApplicationService.revise(id, blankQuizDTO);
    }

    @DeleteMapping("/blank-quiz/{id}")
    void delete(@PathVariable String id) {
        blankQuizApplicationService.delete(id);
    }

    @GetMapping("/blank-quiz/{id}")
    BlankQuizDTO getById(@PathVariable String id) {
        return BlankQuizDTO.from(blankQuizApplicationService.get(id));
    }
}
