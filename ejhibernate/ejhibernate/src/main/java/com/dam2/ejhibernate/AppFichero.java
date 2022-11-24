package com.dam2.ejhibernate;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class AppFichero {
    public static void main(String[] args) {
        try
        (
            FileOutputStream fos = new FileOutputStream("instituto.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        )
        {
            Set<Profesor> teachers = new HashSet<Profesor>();
            teachers.add(new Profesor(1,"Ricardo",true));
            teachers.add(new Profesor(2,"David",false));
            teachers.add(new Profesor(3,"Miguel",false));

            Asignatura a1 = new Asignatura(1,"Entornos",teachers);
            oos.writeObject(a1);
            oos.writeObject(teachers);
        } catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
