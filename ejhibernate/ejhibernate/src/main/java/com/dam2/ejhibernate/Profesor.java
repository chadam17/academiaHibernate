package com.dam2.ejhibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;
@Entity
@Table(name = "profesores")
public class Profesor extends Persona implements java.io.Serializable {
    private boolean tutor;
    public Profesor() {
    }
    public Profesor(String nombre) {
        this.nombre = nombre;
    }
    public Profesor(int cod, String nombre, boolean tutor) {
        super(cod, nombre);
        this.tutor = tutor;
    }
    public Profesor(int cod, String nombre, int edad, boolean tutor) {
        super(cod, nombre, edad);
        this.tutor = tutor;
    }

    public boolean isTutor() {
        return tutor;
    }

    public void setTutor(boolean tutor) {
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "cod=" + cod +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", tutor=" + tutor +
                '}';
    }
}
