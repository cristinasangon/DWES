/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author crisc
 */
public class Empresa {
    private String nombre, cif, representante, nif, telefono, email, volVentas, observaciones, sector;

    public Empresa(String nombre, String cif, String representante, String nif, String telefono, String email, String volVentas, String observaciones, String sector) {
        setNombre(nombre);
        setCif(cif);
        setRepresentante(representante);
        setNif(nif);
        setTelefono(telefono);
        setEmail(email);
        setVolVentas(volVentas);
        setObservaciones(observaciones);
        setSector(sector);
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

    public String getVolVentas() {
        return volVentas;
    }

    public void setVolVentas(String volVentas) {
        this.volVentas = volVentas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "Empresa{" + "nombre=" + nombre + ", cif=" + cif + ", representante=" + representante + ", nif=" + nif + ", telefono=" + telefono + ", email=" + email + ", volVentas=" + volVentas + ", observaciones=" + observaciones + ", sector=" + sector + '}';
    }
    
    
}
