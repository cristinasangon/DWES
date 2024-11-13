/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author crisc
 */
public class Empresa implements Comparable<Empresa>{
    private String nombre, cif, representante, nif, sector, telefono, email, volumen, observaciones;

    public Empresa(String nombre, String cif, String representante, String nif, String sector, String telefono, String email, String volumen, String observaciones) {
        this.nombre = nombre;
        this.cif = cif;
        this.representante = representante;
        this.nif = nif;
        this.sector = sector;
        this.telefono = telefono;
        this.email = email;
        this.volumen = volumen;
        this.observaciones = observaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public int compareTo(Empresa o) {
       int tlf = Integer.parseInt(getTelefono());
       int otlf = Integer.parseInt(o.getTelefono());
       return tlf - otlf;
    }
    
    
}
