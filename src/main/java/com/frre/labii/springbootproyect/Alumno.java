package com.frre.labii.springbootproyect;

/**
 * Created by root on 28/11/15.
 */
// Clase alumno con sus atributos, constructor y métodos publicos
public class Alumno {
    private String nombre;
    private String apellido;
    private int legajo;
    private String carrera;
    private int cantMaterias;

    public Alumno(String nombre, String apellido, int legajo, String carrera, int cantMaterias) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.carrera = carrera;
        this.cantMaterias = cantMaterias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getCantMaterias() {
        return cantMaterias;
    }

    public void setCantMaterias(int cantMaterias) {
        this.cantMaterias = cantMaterias;
    }
}
