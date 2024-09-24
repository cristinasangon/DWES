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
public class Ejercicio_7{
    public Ejercicio_7()throws Exception{
        Scanner leer = new Scanner(System.in);
        int num = 0;
        while(num < 10 || num > 30){
            System.out.print("Introduce un numero entre 10 y 30: ");
            num = leer.nextInt();
        }
        
        if((num%5) == 0){
            System.out.println("El numero " + num + " es divisible por 5");
        }else{
            System.out.println("El numero " + num + " no es divisible por 5");
        }
        
        System.out.print("Escribe tu nombre: ");
        String nombre = leer.next();
        System.out.println("Empieza por la letra: " + nombre.charAt(0));
        System.out.println("Termina por la letra: " + nombre.charAt(nombre.length() -1));
        System.out.println("Tu nombre en mayusculas: " + nombre.toUpperCase());
        System.out.println("Tu nombre en minusculas: " + nombre.toLowerCase());
        if(nombre.contains("p")){
            System.out.println("Tu nombre tiene la letra 'p'");
        }else{
            System.out.println("Tu nombre no tiene la letra 'p'");
        }
    }
}
