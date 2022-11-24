package com.dam2.ejhibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
@Entity
@Table(name = "asignaturas")
public class Asignatura implements Serializable {
    @Id
    @Column
    private int cod;
    @Column
    private String nombre;
    @ManyToMany(mappedBy = "asignatura", targetEntity = Asignatura.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "profesores-asignaturas",joinColumns = {@JoinColumn(name = "profesores", referencedColumnName = "nombre")},inverseJoinColumns = {@JoinColumn(name = "asignaturas",referencedColumnName = "nombre")})
    private Set<Profesor> profesores = new HashSet<Profesor>();

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    public Asignatura() {
    }

    public Asignatura(int cod, String nombre, Set<Profesor> profesores) {
        this.cod = cod;
        this.nombre = nombre;
        this.profesores = profesores;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Profesor> getprofesores() {
        return profesores;
    }

    public void setprofesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "cod=" + cod +
                ", nombre='" + nombre + '\'' +
                ", profesores=" + profesores +
                '}';
    }
    /*
    private Profesor prof;
    public Asignatura() {
        profesores =new Vector<Profesor>();
    }
    public Asignatura(String nombre) {  this.nombre = nombre; }
    public Asignatura(int cod, String nombre, List<Profesor> profesores) {
        this.cod = cod;
        this.nombre = nombre;
        this.profesores = profesores;
    }

    public Asignatura(int cod, String nombre) {
        this.cod = cod;
        this.nombre = nombre;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Profesor> getDiscos() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public void getProfesores() {
        for (Profesor profs: profesores)
            getTeacher();
    }
    public List<Profesor> getprofesores() { return profesores; }
    public Profesor getTeacher() {
        return prof;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "codAs=" + cod +
                ", nombreAs='" + nombre + '\'' /*+
                ", profesores=" + profesores +
                '}';

    }

     */
}
