package com.dam2.ejhibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "alumnos")
public class Alumno extends Persona implements Serializable {
    @Id
    @Column
    private int curso;

    public Alumno() {
    }

    public Alumno(int cod, String nombre, int edad, int curso) {
        super(cod, nombre, edad);
        this.curso = curso;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "curso=" + curso +
                '}';
    }
}
