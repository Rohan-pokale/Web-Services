package com.rohan.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.security.auth.login.AppConfigurationEntry;

public class hibernateUtil {
    private static SessionFactory sessionFactory ;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
        }
}
