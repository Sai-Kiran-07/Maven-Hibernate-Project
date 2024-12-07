package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Configure and build the session factory
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Device.class)
                .addAnnotatedClass(Smartphone.class).addAnnotatedClass(Tablet.class).buildSessionFactory();

        // Open a session
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Insert records
        Device device = new Device();
        device.setBrand("GenericBrand");
        device.setModel("GenericModel");
        device.setPrice(1000.00);

        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Apple");
        smartphone.setModel("iPhone 14");
        smartphone.setPrice(999.99);
        smartphone.setOperatingSystem("iOS");
        smartphone.setCameraResolution("12 MP");

        Tablet tablet = new Tablet();
        tablet.setBrand("Samsung");
        tablet.setModel("Galaxy Tab S9");
        tablet.setPrice(799.99);
        tablet.setScreenSize(11.0);
        tablet.setBatteryLife(10);

        // Persist objects
        session.persist(device);
        session.persist(smartphone);
        session.persist(tablet);

        // Commit transaction
        transaction.commit();

        // Close session
        session.close();
        sessionFactory.close();

        System.out.println("Records inserted successfully.");
    }
}
