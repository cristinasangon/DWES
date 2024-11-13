/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author crisc
 */
public class Actividad {
    private String nombre, lugar, fecha, hora, destinada, curso, profesor, observaciones;
    private String[]tipoActividad;

    public Actividad(String nombre, String lugar, String fecha, String hora, String destinada, String[] tipoActividad, String curso, String profesor, String observaciones) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
        this.destinada = destinada;
        this.tipoActividad = tipoActividad;
        this.curso = curso;
        this.profesor = profesor;
        this.observaciones = observaciones;
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

    public String[] getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String[] tipoActividad) {
        this.tipoActividad = tipoActividad;
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

    @Override
    public String toString() {
        return "Actividad{" + "nombre=" + nombre + ", lugar=" + lugar + ", fecha=" + fecha + ", hora=" + hora + ", destinada=" + destinada + ", tipoActividad=" + tipoActividad + ", curso=" + curso + ", profesor=" + profesor + ", observaciones=" + observaciones + '}';
    }

}
