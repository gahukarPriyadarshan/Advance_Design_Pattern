package Test;

import beans.Faculty;
import beans.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOne {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Subject subject1 =new Subject(101,"English");
        Faculty faculty1 =new Faculty(10,"Vickey",subject1);
        subject1.setFaculty(faculty1);

        Subject subject2 =new Subject(102,"Maths");
        Faculty faculty2 =new Faculty(11,"Nayan",subject2);
        subject2.setFaculty(faculty2);

        Subject subject3 =new Subject(103,"Science");
        Faculty faculty3 =new Faculty(12,"Vikas",subject3);
        subject3.setFaculty(faculty3);


        session.save(faculty1);
        session.save(faculty2);
        session.save(faculty3);
        session.save(subject1);
        session.save(subject2);
        session.save(subject3);



        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
