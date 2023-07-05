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

public class GroupProperty {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure("resources/hibernate.cfg.xml");
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Criteria criteria=session.createCriteria(Student.class);

        ProjectionList projectionList= Projections.projectionList();
        projectionList.add(Projections.groupProperty("stuname"));
        projectionList.add(Projections.rowCount());

        criteria.setProjection(projectionList);

        List<Object[]> nameCount =criteria.list();
        System.out.println("******************************************************************");
        for (Object[] obj: nameCount) {

            System.out.print("NAME : "+obj[0]);
            System.out.println("  Rows : "+ obj[1]);

        }

        session.close();
        sessionFactory.close();
    }
}
