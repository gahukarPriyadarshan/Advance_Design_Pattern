package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Delete {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("resource/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "delete Patient where id = 1";

        Query query = session.createQuery(hql);
        query.executeUpdate();
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}