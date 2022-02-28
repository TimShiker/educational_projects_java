package CreatingConnections;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {

    public final static String configureFile = "hibernate.cfg.xml";

    public static void main(String[] args) {


        try {


            Session session = getSessionFactory(configureFile).openSession();

            Student student = session.get(Student.class, 1);

            System.out.println("Out from Purchase");
            for(Course course : student.getCoursesFromPurchase()){
                System.out.println(course.getName());
            }

            System.out.println("Out from Subscriptions");
            for(Course course : student.getCoursesFromPurchase()){
                System.out.println(course.getName());
            }

            Course course = session.get(Course.class, 10);

            System.out.println("Out from Purchase");
            for(Student student1 : course.getStudentsFromPurchase()){
                System.out.println(student1.getName());
            }

            System.out.println("Out from Subscriptions");
            for(Student student1 : course.getStudentsFromSubscriptions()){
                System.out.println(student1.getName());
            }

            session.close();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

    }

    public static SessionFactory getSessionFactory(String configureFile) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
                configure(configureFile).build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        return metadata.getSessionFactoryBuilder().build();
    }
}
