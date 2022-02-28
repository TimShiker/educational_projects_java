package CreatingConnections;

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
public class KeyPurchaseList implements Serializable {

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;

    public KeyPurchaseList(String courseName, String studentName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }
}
