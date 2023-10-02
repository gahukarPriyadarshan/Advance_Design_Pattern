package test;

import beans.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Aggergate {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("resource/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query maxFeesQuery = session.createQuery("SELECT MAX(fees) FROM NewPatient");
        Object maxFees = maxFeesQuery.getSingleResult();


        Query minFeesQuery = session.createQuery("SELECT MIN(fees) FROM NewPatient");
        Object minFees = minFeesQuery.getSingleResult();


        Query avgFeesQuery = session.createQuery("SELECT AVG(fees) FROM NewPatient");
        Object avgFees = avgFeesQuery.getSingleResult();


        Query empCountQuery = session.createQuery("SELECT COUNT(*) FROM NewPatient");
        Object empCount = empCountQuery.getSingleResult();

        Query empDisCountQuery = session.createQuery("SELECT COUNT(distinct(name)) FROM NewPatient");
        Object empDisCount = empDisCountQuery.getSingleResult();

        Query sumFeesQuery = session.createQuery("SELECT SUM(fees) FROM NewPatient");
        Object sumFees = sumFeesQuery.getSingleResult();

        System.out.println("//////////////////////////////////////////////////////////////////////////");
        System.out.println();
        System.out.println("Maximum fees of Patient -> " + maxFees);
        System.out.println("Minimum fees of Patient -> " + minFees);
        System.out.println("Average fees of Patients -> " + avgFees);
        System.out.println("Total number of Patients -> " + empCount);
        System.out.println("Total number of Distinct Patients -> " + empDisCount);
        System.out.println("Total sum of fees of all Patients -> " + sumFees);
        System.out.println();
        System.out.println("//////////////////////////////////////////////////////////////////////////");

        session.close();
        sessionFactory.close();
    }
}
