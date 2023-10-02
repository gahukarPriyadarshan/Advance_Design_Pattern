package test;


import beans.NewPatient;
import beans.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertClient {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("resource/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        Patient patient1 = new Patient(1, "Vickey", "vickey@gmail.com","Karan", 500.00);
//        Patient patient2 = new Patient(2, "Nayan", "nayan@gmail.com","Doremon", 400.00);
//        Patient patient3 = new Patient(3, "Yash", "yash@gmail.com","Vaibhav", 700.00);
//        Patient patient4 = new Patient(4, "pratik", "pratik@gmail.com","Rohit", 300.00);
//        Patient patient5 = new Patient(5, "shivam", "shivam@gmail.com","Mani", 900.00);
//        Patient patient6 = new Patient(6,"Pranit","pranit@gmail.com","Shweta",800.00);
        NewPatient newpatient1 = new NewPatient(7,"Dog","dog@gmail.com","vet",8900.00);
        NewPatient newpatient2 = new NewPatient(8,"Cat","cat@gmail.com","vet",700.00);
        NewPatient newpatient3 = new NewPatient(9,"Cow","cow@gmail.com","vet",8000.00);

        session.save(newpatient1);
        session.save(newpatient2);
        session.save(newpatient3);

//        session.save(patient1);
//        session.save(patient2);
//        session.save(patient3);
//        session.save(patient4);
//        session.save(patient5);
//        session.save(patient6);
        
        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
