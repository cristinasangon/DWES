/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author crisc
 */
public class Actividad implements Comparable<Actividad>{
    private String nombre, lugar, fecha, hora, destinada, curso, profesor, observaciones, departamento;
    private String[] tipo;

    public Actividad(String nombre, String lugar, String fecha, String hora, String destinada, String curso, String profesor, String observaciones, String departamento, String[] tipo) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
        this.destinada = destinada;
        this.curso = curso;
        this.profesor = profesor;
        this.observaciones = observaciones;
        this.departamento = departamento;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDestinada() {
        return destinada;
    }

    public void setDestinada(String destinada) {
        this.destinada = destinada;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        departamento = departamento.toUpperCase();
        this.departamento = departamento;
    }

    public String[] getTipo() {
        return tipo;
    }

    public void setTipo(String[] tipo) {
        this.tipo = tipo;
    }

    @Override
    public int compareTo(Actividad o) {
        String[] fechaSeparada = getFecha().split("/");
        String fecha = fechaSeparada[2] + "-" + fechaSeparada[1] + "-" + fechaSeparada[0];
        
        String[] fechaSeparadao = o.getFecha().split("/");
        String fechao = fechaSeparadao[2] + "-" + fechaSeparadao[1] + "-" + fechaSeparadao[0];
        
        LocalDate fecha1 = LocalDate.parse(fecha);
        LocalDate fecha2 = LocalDate.parse(fechao);
        
        
        return fecha1.compareTo(fecha2);
    }
    
    
    
    
}
