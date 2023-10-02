package test;

import beans.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Select {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("resource/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from Patient order by id";
        Query query = session.createQuery(hql);
        List<Patient> patientList = query.list();

        for (Patient emp : patientList) {
            System.out.println("***********************************************************");
            System.out.println(emp.toString());
        }
        session.close();
        sessionFactory.close();
    }
}