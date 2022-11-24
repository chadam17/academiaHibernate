package com.dam2.ejhibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class App {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.obtenerSF();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Set<Profesor> teachers = new HashSet<Profesor>();
        teachers.add(new Profesor(1,"Ricardo",true));
        teachers.add(new Profesor(2,"David",false));
        teachers.add(new Profesor(3,"Miguel",false));

        Asignatura a1 = new Asignatura(1,"Entornos",teachers);

        s.save(a1);
        //s.delete(a1);
        /*
        Vector<Profesor> teachers = new Vector<Profesor>();
        teachers.add(new Profesor("Ricardo"));
        teachers.add(new Profesor("David"));
        teachers.add(new Profesor("Miguel"));
        Vector<Asignatura> subjects = new Vector<Asignatura>();
        subjects.add(new Asignatura(1,"Sistemas Informáticos"));
        subjects.add(new Asignatura(2,"Desarrollo de Interfaces"));
        subjects.add(new Asignatura(3,"Acceso a Datos"));

        Profesor p1 = new Profesor(1,"Godo",56);

        for (Asignatura as : subjects)
            System.out.println(as);

        System.out.println(p1);
/*
        for (int i=0; i < subjects.size(); i++) {
            System.out.println((subjects.elementAt(i)));
            s.save(subjects.elementAt(i).getTeachers());
        }
*/
       // s.save(p1);
        //Alumno a1 = new Alumno(1,"Pepe",14,1);
        /*
        Asignatura as1 = new Asignatura(1,"matematicas",teachers);
        Profesor p1 = new Profesor(1,"Godo",56,subjects);
        p1.getSubjects().add(as1);

         */

      //  s.save(as1);
       // s.save(p1);
        //s.delete(as1);
        //s.delete(p1);

    //    Asignatura as2 = new Asignatura(2,"lenguaje de marcas");
    //    Asignatura as3 = new Asignatura(3,"Entornos");

    //    Profesor p1 = new Profesor(1,"Godo",56,subjects);

        t.commit();
        if (s != null)
            s.close();
    }
}
