/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

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
                    System.out.print("Denominacion de un alimento('Fin' para terminar): ");
                    nombre = Leer.cadena();
                }
                if(nombre.equals("Fin")){
                    break;
                }
                
                double proteinas = 100, lipidos = 100, hidratos = 100;
                while((proteinas + hidratos + lipidos) > 100){
                    boolean seguir = true;
                    while(seguir){
                        try {
                            System.out.print("Contenido en % de proteinas: ");
                            proteinas = Double.parseDouble(Leer.cadena());
                            if((proteinas < 0) || (proteinas > 100)){
                                System.out.println("- - Un porcentaje debe estar entre 0 y 100");
                            }else{
                                seguir = false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    
                    seguir = true;
                    while(seguir){
                        try {
                            System.out.print("Contenido en % de lipidos: ");
                            lipidos = Double.parseDouble(Leer.cadena());
                            if((lipidos < 0) || (lipidos > 100)){
                                System.out.println("- - Un porcentaje debe estar entre 0 y 100");
                            }else{
                                seguir = false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    
                    seguir = true;
                    while(seguir){
                        try {
                            System.out.print("Contenido en % de hidratos: ");
                            hidratos = Double.parseDouble(Leer.cadena());
                            if((hidratos < 0) || (hidratos > 100)){
                                System.out.println("- - Un porcentaje debe estar entre 0 y 100");
                            }else{
                                seguir = false;
                            }
                        } catch (Exception e) {
                        }
                    }
                    
                    if((proteinas + hidratos + lipidos) > 100){
                        System.out.println("- - La suma de proteinas, lipidos e hidratos no puede superar 100");
                    }
                }
                
                String minerales = "";
                while((!minerales.equals("A")) && (!minerales.equals("M")) && (!minerales.equals("B"))){
                    System.out.print("Contenido en minerales ('A', 'M' o 'B'): ");
                    minerales = Leer.cadena();
                }
                
                String vitaminas = "";
                while((!vitaminas.equals("A")) && (!vitaminas.equals("M")) && (!vitaminas.equals("B"))){
                    System.out.print("Contenido en vitaminas ('A', 'M' o 'B'): ");
                    vitaminas = Leer.cadena();
                }
                
                String animal = "";
                while((!animal.equals("S")) && (!animal.equals("N"))){
                    System.out.print("¿Es de origen animal? (S/N): ");
                    animal = Leer.cadena();
                }
                
                Alimento alimento = new Alimento(nombre, lipidos, hidratos, proteinas, animal, minerales, vitaminas);
                alimentos.add(alimento);
            }
            
            for(Alimento alim: alimentos){
                System.out.println(alim.mostrarAlimento());
            }
        } catch (Exception e) {
        }
    }
    
}
