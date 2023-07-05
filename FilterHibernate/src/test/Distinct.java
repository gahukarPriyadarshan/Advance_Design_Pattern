package test;

import beans.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import java.util.List;

public class Distinct {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure("resources/hibernate.cfg.xml");
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Criteria criteria=session.createCriteria(Student.class);

        ProjectionList projectionList= Projections.projectionList();
        projectionList.add(Projections.distinct(Projections.property("stuname")));
        criteria.setProjection(projectionList);
        List<String> distinctNames = criteria.list();
        System.out.println("******************************************************************");
        System.out.println("list of distinct Student names");
        for (String name: distinctNames) {
            System.out.println(name);
        }

        session.close();
        sessionFactory.close();
    }
}
