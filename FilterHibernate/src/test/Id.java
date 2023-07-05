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

public class Id {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure("resources/hibernate.cfg.xml");
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Criteria criteria=session.createCriteria(Student.class);

        ProjectionList projectionList=Projections.projectionList();
        projectionList.add(Projections.id());
        projectionList.add(Projections.property("stuname"));
        projectionList.add(Projections.property("stumarks"));
        criteria.setProjection(projectionList);
        List<Object[]> results = criteria.list();

        for (Object[] obj:results) {
            System.out.print("ID : "+obj[0]);
            System.out.print(" Name : "+obj[1]);
            System.out.println(" Marks : "+obj[2]);

        }
        session.close();
        sessionFactory.close();
    }
}
