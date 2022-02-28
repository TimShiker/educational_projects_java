package CreateNewTableHibernate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int duration;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private CourseType type;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Teacher teacher;

    @Column(name = "students_count")
    private Integer studentsCount;

    private int price;

    @Column(name = "price_per_hour")
    float pricePerHour;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private List<Student> studentsFromSubscriptions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private List<Subscription> subscriptions;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PurchaseList",
            joinColumns = {@JoinColumn(name = "course_name", referencedColumnName = "name")},
            inverseJoinColumns = {@JoinColumn(name = "student_name", referencedColumnName = "name")})
    private List<Student> studentsFromPurchase;
}