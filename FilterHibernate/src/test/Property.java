package test;

import beans.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

public class Property {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure("resources/hibernate.cfg.xml");
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Criteria criteria=session.createCriteria(Student.class);

        Projection projection = Projections.property("stuname");
        criteria.setProjection(projection);
        boolean property1 =criteria.isReadOnly();
        boolean property2 =criteria.isReadOnlyInitialized();
        System.out.println("*****************************************************************");
        System.out.println(property1);
        System.out.println(property2);

        session.close();
        sessionFactory.close();
    }
}
