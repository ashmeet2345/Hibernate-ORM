package org.example.springmvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbededMain {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("configuration.xml").buildSessionFactory();
        Session session=factory.openSession();

        Certificate certificate=new Certificate();
        certificate.setCourse("Apache Kafka");
        certificate.setDuration("2 months");

        Students student=new Students();
        student.setCity("Delhi");
        student.setName("Ashmeet");
        student.setCertificate(certificate);

        session.beginTransaction();
        session.save(student);

        session.getTransaction().commit();
        factory.close();
        session.close();
    }
}
