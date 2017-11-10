package com.simpleprogrammer;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilities {
    
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    
    static
    {
        try
        {
            Configuration configuration = new Configuration().configure();
            configuration.addClass(com.simpleprogrammer.User.class);
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        catch(HibernateException exception)
        {
            System.out.println("Problem creating session factory!");
            exception.printStackTrace();
        }
        
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
