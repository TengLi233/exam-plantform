package exam.paperContext.domain.model.blankquiz;

import exam.paperContext.domain.model.paper.PaperId;
import exam.paperContext.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class BlankQuizId implements ValueObject<BlankQuizId> {
    private String id;

    public static BlankQuizId nextId() {
        return new BlankQuizId("blankquiz-" + UUID.randomUUID().toString());
    }

    @Override
    public boolean sameValueAs(BlankQuizId other) {
        return equals(other);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        BlankQuizId otherBlankQuizId = (BlankQuizId) other;
        return Objects.equals(id, otherBlankQuizId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
