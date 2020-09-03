package exam.paperContext.application;

public class BlankQuizNotFoundException extends RuntimeException {
    public BlankQuizNotFoundException(String id) {
        super(String.format("BlankQuiz not found, id: %s", id));
    }
}
