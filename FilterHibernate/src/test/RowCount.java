package test;

import beans.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

public class RowCount {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure("resources/hibernate.cfg.xml");
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Criteria criteria=session.createCriteria(Student.class);

        Projection projection = Projections.rowCount();
        criteria.setProjection(projection);
        long count = (long) criteria.uniqueResult();
        System.out.println("****************************************************************");
        System.out.println("total no of rows in the table are : "+count);

        session.close();
        sessionFactory.close();
    }
}
