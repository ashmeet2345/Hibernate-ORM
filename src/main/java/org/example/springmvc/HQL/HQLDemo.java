package org.example.springmvc.HQL;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HQLDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("configuration.xml").buildSessionFactory();
        Session session=factory.openSession();

        Student student=new Student();
        String query="from Student where name=:x ";
        Query q=session.createQuery(query);
        q.setParameter("x","Sameer");
        List<Student> list=q.getResultList();
        for(Student s: list){
            System.out.println(s);
        }

        String query2="delete from Student where name=:x ";
        Query q2=session.createQuery(query2);
        Transaction tx=session.beginTransaction(); //required for row deletion
        q2.setParameter("x","Sanchit");

        int i=q2.executeUpdate();

        if(i>0){
            System.out.println("Row deletion successfull");
        } else {
            System.out.println("No data to be deleted");
        }


        String query3="UPDATE Student SET name=:x WHERE name=:y ";
        Query q3=session.createQuery(query3);
        q3.setParameter("x","Kanishk");
        q3.setParameter("y","Kanishka");
        int j=q3.executeUpdate();
        if(j>0){
            System.out.println("Row update successfull");
        }
        tx.commit();
        session.close();
        factory.close();
    }
}
