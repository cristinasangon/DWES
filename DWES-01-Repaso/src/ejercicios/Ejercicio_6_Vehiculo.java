/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.text.ParseException;

/**
 *
 * @author crisc
 */
public class Ejercicio_6_Vehiculo {
    //ATRIBUTOS
    private String modelo;
    private double potencia;
    private boolean cRuedas;
    
    //CONSTRUCTORES
    public Ejercicio_6_Vehiculo(){
    }

    public Ejercicio_6_Vehiculo(String modelo, String potencia, String cRuedas) throws Exception {
        setModelo(modelo);
        setPotencia(potencia);
        setcRuedas(cRuedas);
    }

    public Ejercicio_6_Vehiculo(String modelo) {
        
    }
    
    //GETTERS Y SETTERS
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) throws Exception{
        this.potencia = Double.parseDouble(potencia);
    }

    public boolean iscRuedas() {
        return cRuedas;
    }

    public void setcRuedas(String cRuedas) throws Exception{
        if(cRuedas.equals("s")){
            this.cRuedas = true;
        }else if (cRuedas.equals("n")){
            this.cRuedas = false;
        }
    }
    
}
