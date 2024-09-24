/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

/**
 *
 * @author crisc
 */
public class Ejercicio_3 {
    public Ejercicio_3(){
    //Realizar un programa que muestre todos los números enteros entre 100 y 150, que sean divisibles entre 3 y 7, 
    //mostrar igualmente la suma de todos los números que cumplan la condición anterior.
    System.out.println("Números divisibles por 3 y 7 entre 100 y 150:");
    int suma = 0;
    for(int x=100; x<=150; x++){
      if((x%3) == 0 && (x%7) == 0){
          System.out.print(x + ", ");
          suma += x;
      }
    }
        System.out.println("");
    System.out.println("La suma es:" + suma);
    }
}
