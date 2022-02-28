package CreateNewTableHibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.List;


public class Main {

    public final static String configureFile = "hibernate.cfg.xml";

    public static void main(String[] args) {


        try {

            SessionFactory sessionFactory = getSessionFactory(configureFile);
            Session session = sessionFactory.openSession();

            fillLinkedPurchaseListWithPurchaseLists(session, getPurchaseListWithHql(session));

            sessionFactory.close();


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

    public static List<PurchaseList> getPurchaseListWithHql(Session session) {

        Query query = session.createQuery("from PurchaseList where course is not null");
        return query.getResultList();

    }

    public static void fillLinkedPurchaseListWithPurchaseLists(Session session, List<PurchaseList> purchaseLists) {
        session.beginTransaction();

        for (PurchaseList purchaseList : purchaseLists) {
            session.save(new LinkedPurchaseList(purchaseList.getStudent().getId(),
                            purchaseList.getCourse().getId()));

        }
        session.getTransaction().commit();
    }
}
