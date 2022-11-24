package com.dam2.ejhibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "personas")
public abstract class Persona implements Serializable {
    @Id
    @Column
    protected int cod;
    @Column
    protected String nombre;
    @Column
    protected int edad;

    public Persona() {
    }

    public Persona(int cod, String nombre) {
        this.cod = cod;
        this.nombre = nombre;
    }

    public Persona(int cod, String nombre, int edad) {
        this.cod = cod;
        this.nombre = nombre;
        this.edad = edad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "cod=" + cod +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
