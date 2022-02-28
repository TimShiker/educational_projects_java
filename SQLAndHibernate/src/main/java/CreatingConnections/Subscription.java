package CreatingConnections;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "subscriptions")
public class Subscription {

    @EmbeddedId
    private KeySubscription idSubscription;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false, updatable = false, insertable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    @Column(name = "subscription_date", insertable = false, updatable = false)
    private Date subscriptionDate;
}
