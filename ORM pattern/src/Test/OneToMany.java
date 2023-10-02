package Test;

import beans.FacultyM;
import beans.SubjectM;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OneToMany {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        FacultyM faculty1 =new FacultyM(10,"Vickey");
        FacultyM faculty2 =new FacultyM(11,"Sanika");

        SubjectM subject1 =new SubjectM(101,"English",faculty1);
        SubjectM subject2 = new SubjectM(102,"Hindi",faculty1);
        SubjectM subject3 = new SubjectM(103,"Science",faculty2);
        SubjectM subject4 = new SubjectM(104,"Maths",faculty2);
        SubjectM subject5 = new SubjectM(105,"CS",faculty2);

        List<SubjectM> list =new ArrayList<>();
        list.add(subject1);
        list.add(subject2);
        list.add(subject3);
        list.add(subject4);
        list.add(subject5);

        faculty1.setSubjects(list);

        session.save(faculty1);
        session.save(faculty2);
        session.save(subject1);
        session.save(subject2);
        session.save(subject3);
        session.save(subject4);
        session.save(subject5);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
