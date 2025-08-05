package com.rohan.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static volatile SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (HibernateUtil.class) {
                if (sessionFactory == null) {
                    try {
                        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
                    } catch (Exception e) {
                        throw new ExceptionInInitializerError("Initial SessionFactory creation failed: " + e);
                    }
                }
            }
        }
        return sessionFactory;
    }
}