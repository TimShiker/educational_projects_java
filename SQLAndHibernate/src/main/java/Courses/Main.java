package Courses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

    public final static String configureFile = "hibernate.cfg.xml";

    public static void main(String[] args) {

        Session session = getSessionFactory(configureFile).openSession();

        Course courseJava = session.get(Course.class, 3);

        System.out.println("\nCourse name: " + courseJava.getName() + ".\n" +
                "Number of students in this course: " + courseJava.getStudentsCount() + ".");


        session.close();
    }

    public static SessionFactory getSessionFactory(String configureFile){

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
                configure(configureFile).build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        return sessionFactory;
    }


}
