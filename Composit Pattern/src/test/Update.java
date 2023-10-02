package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Update {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("resource/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        String hql = "update Patient set name = 'Prakash', address = 'prakash@gmail.com', doctor = 'UpdatedDR' , fees = 5000 where id = 1";

        Query query = session.createQuery(hql);
        int i = query.executeUpdate();
        System.out.println("Number of queries executed : " + i);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
