package CreateNewTableHibernate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {

    @EmbeddedId
    private KeyLinkedPurchaseList idLinkedPurchaseList;

    @Column(name = "student_id", insertable = false, updatable = false)
    private Integer studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private Integer courseId;

    public LinkedPurchaseList(Integer studentId, Integer courseId){
        this.idLinkedPurchaseList = new KeyLinkedPurchaseList(studentId, courseId);
        this.studentId = studentId;
        this.courseId = courseId;
    }





}
