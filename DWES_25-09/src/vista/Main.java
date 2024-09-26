/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author crisc
 */
public class Main {
     public static void main(String[] args) {
         try {
             System.out.print("Denominacion de un alimento: ");
             String nombre = leer.cadena();
             while(nombre.equals("")){
                 System.out.println("- - No puede ser una cadena vacia");
                 System.out.print("Denominacion de un alimento: ");
                 nombre = leer.cadena();
             }
             
             Double lipidos = 100.0, hidratos = 100.0, proteinas = 100.0;
             while((lipidos + hidratos + proteinas) > 100){
                 boolean seguir = true;
                 while(seguir){
                     try {
                        System.out.print("Contenido en % de lipidos: ");
                        String dato = leer.cadena();
                        lipidos = Double.parseDouble(dato);
                        if(lipidos > 0 && lipidos <= 100){
                            seguir = false;
                        }else{
                            System.out.println("- - Dato no valido introducido");
                        }
                    } catch (Exception e) {
                        System.out.println("- - Dato no valido introducido");
                    }
                 }    
                 seguir = true;
                 while(seguir){
                     try {
                        System.out.print("Contenido en % de proteinas: ");
                        String dato = leer.cadena();
                        proteinas = Double.parseDouble(dato);
                        if(proteinas > 0 && proteinas <= 100){
                            seguir = false;
                        }else{
                            System.out.println("- - Dato no valido introducido");
                        }
                    } catch (Exception e) {
                        System.out.println("- - Dato no valido introducido");
                    }
                 }
                 seguir = true;
                 while(seguir){
                     try {
                        System.out.print("Contenido en % de hidratos: ");
                        String dato = leer.cadena();
                        hidratos = Double.parseDouble(dato);
                        if(hidratos > 0 && hidratos <= 100){
                            seguir = false;
                        }else{
                            System.out.println("- - Dato no valido introducido");
                        }
                    } catch (Exception e) {
                        System.out.println("- - Dato no valido introducido");
                    }
                 }
                if((lipidos + hidratos + proteinas) > 100){
                    System.out.println("- - La suma de los lipidos, hidratos y proteinas no puede superar 100"); 
                }  
             }
             
             System.out.print("Contenido en minerales: ");
             String minerales = leer.cadena();
             while(!minerales.equals("A") && !minerales.equals("M") && !minerales.equals("B")){
                 System.out.println("- - Solo puedes introducir 'A', 'M' o 'B'");
                 System.out.print("Contenido en minerales: ");
                 minerales = leer.cadena();
             }
             
             System.out.print("Contenido en vitaminas: ");
             String vitaminas = leer.cadena();
             while(!vitaminas.equals("A") && !vitaminas.equals("M") && !vitaminas.equals("B")){
                 System.out.println("- - Solo puedes introducir 'A', 'M' o 'B'");
                 System.out.print("Contenido en vitaminas: ");
                 vitaminas = leer.cadena();
             }
             
             System.out.print("¿Es de origen animal?(S/N): ");
             String origAnimal = leer.cadena();
             while(!origAnimal.equals("S") && !origAnimal.equals("N")){
                 System.out.println("- - Solo puedes introducir 'S' o 'N'");
                 System.out.print("¿Es de origen animal?(S/N): ");
                 origAnimal = leer.cadena();
             }
             
             Alimento alimento = new Alimento(nombre, minerales, vitaminas, lipidos, hidratos, proteinas, origAnimal);
             System.out.println(alimento.mostrarAlimento());
         } catch (IOException ex) {
             System.out.println(ex.getMessage());
         }
        
        
    }
}
