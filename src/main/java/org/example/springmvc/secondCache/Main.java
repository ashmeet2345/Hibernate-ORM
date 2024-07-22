package org.example.springmvc.secondCache;


import org.example.springmvc.HQL.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cache.spi.SecondLevelCacheLogger;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory=new Configuration().configure("configuration.xml")
                .buildSessionFactory();
        Session session=factory.openSession();
        Session session2=factory.openSession();

        Student s1=(Student)session.get(Student.class,1);
        System.out.println(s1);
        session.close();

        Student s2=(Student)session2.get(Student.class, 1);
        System.out.println(s2);
        session2.close();

        factory.close();
    }
}
