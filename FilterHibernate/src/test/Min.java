package test;

import beans.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

public class Min {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure("resources/hibernate.cfg.xml");
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Criteria criteria=session.createCriteria(Student.class);

        Projection projection = Projections.min("stumarks");
        criteria.setProjection(projection);
        double minMarks = (double)criteria.uniqueResult();
        System.out.println("****************************************************************");
        System.out.print("Max marks of an student is ");
        System.out.println(minMarks);

        session.close();
        sessionFactory.close();
    }
}