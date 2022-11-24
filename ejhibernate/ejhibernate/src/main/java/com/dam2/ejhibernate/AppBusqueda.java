package com.dam2.ejhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class AppBusqueda {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.obtenerSF();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        //Ejemplo de búsqueda de asignaturas
        String hql1 = "select nombre from Asignatura"; //Devuelve "Entornos"
        Query q = s.createQuery(hql1);
        q.setFetchSize(5);
        Iterator it = q.iterate();
        while (it.hasNext())
            System.out.println(it.next());
        //Ejemplo de búsqueda de profesores asociados a las asignaturas
        String hql2 = "select profesores from Asignatura"; //Devuelve "David", "Ricardo", "Miguel"
        Query q2 = s.createQuery(hql2);
        q.setFetchSize(5);
        List l = q2.list();
        System.out.println(l);
        t.commit();
        if (s != null)
            s.close();
    }
}
