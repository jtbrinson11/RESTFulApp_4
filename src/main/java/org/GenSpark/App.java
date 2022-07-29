package org.GenSpark;

import org.GenSpark.Entity.Computer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration();
        SessionFactory factory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();

        Query q = session.createQuery("update Computer set motherBoard=:n where computerID=:o");
        q.setParameter("n", "Z89");
        q.setParameter("o", 1);
        q.executeUpdate();

        trans.commit();

        factory.close();
        session.close();

        //Query query = session.createQuery("from Computer");
        //List<Computer> compList = query.list();

        //for (Computer computer : compList)
        //{
        //    System.out.println(computer);
        //}
    }
}

