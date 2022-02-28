package CreateNewTableHibernate;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
public class KeySubscription implements Serializable {

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

    public KeySubscription(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

}