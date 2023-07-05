package test;

import beans.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import java.util.List;

public class SelectProjectionList {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure("resources/hibernate.cfg.xml");
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Criteria criteria=session.createCriteria(Student.class);

        Projection projectionName = Projections.distinct(Projections.property("stuname"));
        Projection projectionMarks =Projections.property("stumarks");


        ProjectionList projectionList= Projections.projectionList();
        projectionList.add(projectionName);
        projectionList.add(projectionMarks);

        criteria.setProjection(projectionList);

        List<Object[]> nameMarks =criteria.list();


        for (Object[] obj: nameMarks) {

            System.out.print("Name : "+obj[0]);
            System.out.println(" MARKS : "+ obj[1]);

        }
        session.close();
        sessionFactory.close();
    }
}
