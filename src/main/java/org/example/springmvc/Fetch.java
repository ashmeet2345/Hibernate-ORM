package org.example.springmvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch {
    public static void main(String[] args) {
        //get,load
        SessionFactory factory=new Configuration().configure("configuration.xml").buildSessionFactory();
        Session session = factory.openSession();

        Students student=(Students) session.load(Students.class,1);
        Address ad=(Address) session.get(Address.class,3);

        /*
        *Get is used when we are not sure about the data is present in the db or not, else it will return null if not found
        * Load is used when we are sure that data is present in the db, else it will throw an ObjectNotFoundException
        * If get doesn't find data in the session cache, it will make call to db, which could be time consuming,
        * while load provides proxy data if the load method is not in use, when method is invoked, then it makes a call to db
        * */
        System.out.println(student);
        System.out.println(ad);
        session.close();
        factory.close();
    }
}
