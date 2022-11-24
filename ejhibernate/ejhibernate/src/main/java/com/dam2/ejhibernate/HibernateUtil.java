package com.dam2.ejhibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    private static SessionFactory sf = null;
    private static ServiceRegistry serviceRegistry;
    private HibernateUtil() {
    }

    public static SessionFactory obtenerSF() {
        if (sf == null)
            serviceRegistry = new StandardServiceRegistryBuilder().
                    configure().loadProperties("hibernate.properties").build();
             sf = new Configuration().buildSessionFactory(serviceRegistry);
        return sf;
    }
}