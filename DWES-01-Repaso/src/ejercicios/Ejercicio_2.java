/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

/**
 *
 * @author crisc
 */
public class Ejercicio_2 {
    public Ejercicio_2(){
       //Realizar un programa que muestre todos los números primos menores de 15.
       for(int x=0; x<15; x++){
       if(esPrimo(x)){
           System.out.print(x + ", ");
       }
    }
    }
    
    public static boolean esPrimo(int num){
        boolean primo = true;
        int x = 2;
        
        if(num == 0){
            return false;
        }
        
        while(primo && x < num){
            if((num%x)==0){
                primo = false;
            }
            x++;
        }
        return primo;
    }
}
