package test;

import beans.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import java.util.List;

public class Alias {public static void main(String[] args) {
    Configuration configuration=new Configuration();
    configuration.configure("resources/hibernate.cfg.xml");
    SessionFactory sessionFactory= configuration.buildSessionFactory();
    Session session=sessionFactory.openSession();
    Criteria criteria=session.createCriteria(Student.class);

    Projection projection = Projections.alias(Projections.property("stuname"),"Student_name");
    criteria.setProjection(projection);

    List<String> StudentList =criteria.list();

    for (String stuname : StudentList) {
        System.out.println(stuname);
    }
    session.close();
    sessionFactory.close();
}
}
