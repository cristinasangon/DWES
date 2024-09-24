/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.util.Scanner;

/**
 *
 * @author crisc
 */
public class Ejercicio_4 {
    public Ejercicio_4(){
    //Escribir una aplicación que solicite los datos de una pelicula, genere un objeto DVD y muestre este en el formato 
    //del apartado segundo. Prueba igualmente los métodos esThriller y tieneResumen.
    Scanner leer = new Scanner(System.in);
    
    System.out.print("Titulo: "); String titulo = leer.nextLine(); //"UNA FINAL MADE IN HOLLYWOOD ( HOLLYWOOD ENDING)";
    System.out.print("Director: "); String director = leer.nextLine(); //"Woody Allen";
    System.out.print("Actores: "); String actores = leer.nextLine(); //"Woody Allen y George Hamilton";
    System.out.print("Genero: ");String genero = leer.nextLine(); //"Comedia";
    System.out.print("Duracion: ");String duracion = leer.nextLine(); //"114";
    System.out.print("Resumen: ");String resumen = leer.nextLine(); //"Los Oscars ganados en el pasado por o el ex-genio del cine Val Waxman . . .";
    
    Ejercicio_4_DVD DVDCine = new Ejercicio_4_DVD(titulo, actores, director, genero, duracion, resumen);
    
    System.out.println("\n------------------------------------------------------------------------------");
    System.out.println( DVDCine.muesraDVDcine());
    
    System.out.println("");
    
    if(DVDCine.esThriller()){
      System.out.println("Es Thriller");  
    }else{
        System.out.println("No es Thriller");
    }
     if(DVDCine.tieneResumen()){
      System.out.println("La ficha tiene resumen");  
    }else{
        System.out.println("La ficha no tiene resumen");
    }
    }
    
}
