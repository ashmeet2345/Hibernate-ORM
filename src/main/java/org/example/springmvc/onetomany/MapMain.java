package org.example.springmvc.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapMain {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("configuration.xml").buildSessionFactory();
        Session session=factory.openSession();

        Answer a1=new Answer();
        Answer a2=new Answer();

        Question q1=new Question();
        q1.setId(1);
        q1.setQuestion("What is java");

        a1.setAnswerId(1);
        a1.setAnswer("Java is an object oriented programming language");
        a1.setQuestion(q1);
        a2.setAnswerId(2);
        a2.setQuestion(q1);
        a2.setAnswer("It is fast, scalable, robust etc");

        List<Answer> answers= Arrays.asList(a1,a2);
        q1.setAnswer(answers);

        session.save(q1);

        session.beginTransaction().commit();

        factory.close();
        session.close();
    }
}
