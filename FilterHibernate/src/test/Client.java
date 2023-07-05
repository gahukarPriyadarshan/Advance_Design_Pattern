package test;

import beans.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("resources/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        Student stu1 = new Student(1, "Vickey", "vickey@gmail.com", 50.00);
//        Student stu2 = new Student(2, "Nayan", "nayan@gmail.com", 40.00);
//        Student stu3 = new Student(3, "Yash", "yash@gmail.com", 70.00);
//        Student stu4 = new Student(4, "pratik", "pratik@gmail.com", 30.00);
//        Student stu5 = new Student(5, "shivam", "shivam@gmail.com", 90.00);
//        Student stu6=new Student(6,"Pranit","pranit@gmail.com",80.00);
        Student stu7 = new Student(7,"Pranit","pranit@gmail.com",80.00);
        Student stu8 = new Student(8, "pratik", "pratik@gmail.com", 30.00);
        Student stu9 = new Student(9, "Nayan", "nayan@gmail.com", 40.00);


//        session.save(stu1);
//        session.save(stu2);
//        session.save(stu3);
//        session.save(stu4);
//        session.save(stu5);
//        session.save(stu6);
        session.save(stu7);
        session.save(stu8);
        session.save(stu9);


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
