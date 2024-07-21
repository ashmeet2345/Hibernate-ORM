package org.example.springmvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        SessionFactory factory=new Configuration().configure("configuration.xml").buildSessionFactory();

        /*Students st=new Students();
        st.setName("Sameer");
        st.setCity("Chandigarh");*/


        Address ad=new Address();
        ad.setStreet("street 1");
        ad.setCity("Delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(234.55D);

        FileInputStream is=new FileInputStream("C:\\Users\\ACER\\Desktop\\pic.jpeg");
        byte[] input=new byte[is.available()];
        is.read(input);
        ad.setImage(input);

        Session session=factory.openSession();
        session.beginTransaction();

        session.save(ad);

        session.getTransaction().commit();

        session.close();

    }
}