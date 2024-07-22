package org.example.springmvc.HQLPagination;

import jakarta.persistence.Query;
import org.example.springmvc.HQL.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import org.apache.log4j.Logger;

public class Main {

    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("configuration.xml").buildSessionFactory();
        Session session=factory.openSession();

        Query q=session.createQuery("from Student", Student.class);
        q.setFirstResult(0);
        q.setMaxResults(3);

        List<Student> l=q.getResultList();
        for(Student s:l){
            System.out.println(s);
        };
        session.close();
        factory.close();
    }
}
