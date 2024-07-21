package org.example.springmvc.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MapMain {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("configuration.xml").buildSessionFactory();
        Session session=factory.openSession();

        Question q1=new Question();
        Answer answer=new Answer();
        answer.setAnswerId(1);
        answer.setAnswer("Java is an object oriented programming language");

        q1.setId(1);
        q1.setQuestion("What is java");
        q1.setAnswer(answer);

        session.save(q1);
        session.save(answer);
        session.beginTransaction().commit();

        factory.close();
        session.close();
    }
}
