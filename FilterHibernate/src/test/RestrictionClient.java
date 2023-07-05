package test;

import beans.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.Iterator;
import java.util.List;

public class RestrictionClient {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure("resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Criteria criteria=session.createCriteria(Student.class);

        Criterion criterion0=Restrictions.between("stumarks",30.0,60.0);
        Criterion criterion1=Restrictions.eq("stumarks",90.0);
        Criterion criterion2=Restrictions.le("stumarks",70.0);
        Criterion criterion3=Restrictions.ge("stumarks",40.0);
        Criterion criterion4=Restrictions.ne("stumarks",90.0);
        Criterion criterion5=Restrictions.and(criterion2,criterion3);
        Criterion criterion7=Restrictions.ne("stuname","Pranit");
        
        criteria.add(criterion5);

        List<Student[]> list = criteria.list();
        Iterator it = list.iterator();

        System.out.println("******************************************************************");

        while (it.hasNext()) {
            Student stu = (Student) it.next();
            System.out.println(stu.toString());
        }

        System.out.println("*******************************************************************");

        session.close();
        sessionFactory.close();


    }
}
