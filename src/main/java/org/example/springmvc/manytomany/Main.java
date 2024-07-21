package org.example.springmvc.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("configuration.xml").buildSessionFactory();
        Session session=factory.openSession();

        Employee e1=new Employee();
        Employee e2=new Employee();

        e1.setEid(1);
        e1.setEmployeeName("Ashmeet");

        e2.setEid(2);
        e2.setEmployeeName("Jasmeet");

        Project p1=new Project();
        Project p2=new Project();

        p1.setPid(41);
        p1.setProjectName("Library management system");

        p2.setPid(85);
        p2.setProjectName("CHATBOT");

        List<Employee> l1=new ArrayList<>();
        List<Project> l2=new ArrayList<>();

        l1.add(e1);
        l1.add(e2);

        l2.add(p1);
        l2.add(p2);

        e1.setProjects(l2);
        p2.setEmployees(l1);

        Transaction tx=session.beginTransaction();

        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);


        tx.commit();
        session.close();
        factory.close();

    }
}
