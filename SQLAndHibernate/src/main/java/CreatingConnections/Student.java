package CreatingConnections;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(name = "registration_date")
    private Date registrationDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private List<Subscription> subscriptions;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Course> coursesFromSubscriptions;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PurchaseList",
            joinColumns = {@JoinColumn(name = "student_name", referencedColumnName = "name")},
            inverseJoinColumns = {@JoinColumn(name = "course_name", referencedColumnName = "name")})
    private List<Course> coursesFromPurchase;
}