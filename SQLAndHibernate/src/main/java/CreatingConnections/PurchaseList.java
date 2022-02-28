package CreatingConnections;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "purchaselist")
public class PurchaseList {

    @EmbeddedId
    private KeyPurchaseList idPurchase;

    private int price;

    @Column(name = "subscription_date", insertable = false, updatable = false)
    private Date subscriptionDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_name", referencedColumnName = "name", nullable=false, updatable = false, insertable = false)
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_name",  referencedColumnName = "name", nullable=false, updatable = false, insertable = false)
    private Course course;
}
