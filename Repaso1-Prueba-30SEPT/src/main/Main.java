/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author crisc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            List<Alimento> alimentos = new ArrayList<Alimento>();
            String nombre = "";
            while(!nombre.equals("Fin")){
                nombre = "";
                while(nombre.equals("")){
                System.out.print("Denominacion del alimento ('Fin' para terminar): "); 
                nombre = Leer.cadena();
                }
                if(nombre.equals("Fin")){
                    break;
                }
                double proteinas = 100, lipidos = 100, hCarbono = 100;
                while((proteinas + lipidos + hCarbono) > 100){
                    boolean repetir = true;
                    while(repetir){
                        System.out.print("contenido en % de proteinas: "); 
                        try {
                            proteinas = Double.parseDouble(Leer.cadena());
                            repetir = false;
                        } catch (NumberFormatException e) {
                        }
                    }
                    
                    repetir = true;
                    while(repetir){
                        System.out.print("contenido en % de lipidos: "); 
                        try {
                            lipidos = Double.parseDouble(Leer.cadena());
                            repetir = false;
                        } catch (NumberFormatException e) {
                        }
                    }
                    
                    repetir = true;
                    while(repetir){
                        System.out.print("contenido en % de hidratos: "); 
                        try {
                            hCarbono = Double.parseDouble(Leer.cadena());
                            repetir = false;
                        } catch (NumberFormatException e) {
                        }
                    }
                    if((proteinas + lipidos + hCarbono) > 100){
                        System.out.println("La suma de proteinas, hidratos y lipidos no puede ser mayor que 100");
                    }
                }
                 
                    String vitaminas = "";
                    while(!vitaminas.equals("A") && !vitaminas.equals("M") && !vitaminas.equals("B")){
                        System.out.print("Contenido en vitaminas: ");
                        vitaminas = Leer.cadena();
                    }
                    
                    String minerales = "";
                    while(!minerales.equals("A") && !minerales.equals("M") && !minerales.equals("B")){
                        System.out.print("Contenido en minerales: ");
                        minerales = Leer.cadena();
                    }
                    
                    String animal = "";
                    while(!animal.equals("S") && !animal.equals("N")){
                        System.out.print("¿Es de origen animal?(S/N): ");
                        animal = Leer.cadena();
                    }
                    
                    Alimento alimento = new Alimento(nombre, lipidos, hCarbono, proteinas, animal, minerales, vitaminas);
                    alimentos.add(alimento);
            } 
            
            for(Alimento alim: alimentos){
                System.out.println(alim.mostrarAlimento());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    
}
