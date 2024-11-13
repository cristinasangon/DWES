/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author crisc
 */
public class Reserva {
    private String nombre, apellidos, dni, ss, telefono, email, provincia, entrada, salida, regimen;
    private String[] servicios;

    public Reserva(String nombre, String apellidos, String dni, String ss, String telefono, String email, String provincia, String entrada, String salida, String regimen, String[] servicios) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.ss = ss;
        this.telefono = telefono;
        this.email = email;
        this.provincia = provincia;
        this.entrada = entrada;
        this.salida = salida;
        this.regimen = regimen;
        this.servicios = servicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    public String[] getServicios() {
        return servicios;
    }

    public void setServicios(String[] servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "Reserva{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", ss=" + ss + ", telefono=" + telefono + ", email=" + email + ", provincia=" + provincia + ", entrada=" + entrada + ", salida=" + salida + ", regimen=" + regimen + ", servicios=" + servicios + '}';
    }
    
    
}
