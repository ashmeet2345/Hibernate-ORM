package org.example.springmvc.firstCache;

import org.example.springmvc.HQL.Student;
import org.example.springmvc.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    private static final SessionFactory factory=new Configuration().
            configure("configuration.xml").
            buildSessionFactory();

    private static final Session session=factory.openSession();

    public static void main(String[] args) {
        Student s=new Student();
        Student s1=session.get(Student.class, 1);
        System.out.println(s1);
        System.out.println("Again fetching");
        Student s2=session.get(Student.class,1);
        System.out.println(s2);

        System.out.println(session.contains(s1));

    }
}
