/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author crisc
 */
public class Ejercicio_6 {
    public Ejercicio_6() throws Exception{
        List<Ejercicio_6_Vehiculo> vehiculos = new ArrayList<Ejercicio_6_Vehiculo>();
        Scanner leer = new Scanner(System.in);
        String modelo = "", cRuedas, potencia;
        while(!modelo.equals("Fin")){
            modelo = ""; cRuedas = ""; potencia = "";
            System.out.println("Introduce el modelo del vehiculo(Estribe 'Fin' para terminar): ");
            modelo = leer.nextLine();
            if(modelo.equals("Fin")){
                break;
            }
            System.out.println("¿Tiene traccion en las cuatro ruedas? s/n: ");
            cRuedas = leer.nextLine();
            
            System.out.println("Introduce la potencia: ");
            potencia = leer.nextLine();
            Ejercicio_6_Vehiculo vehiculo = new Ejercicio_6_Vehiculo(modelo, potencia, cRuedas);
            vehiculos.add(vehiculo);
        }
        
        for(Ejercicio_6_Vehiculo vehiculoX: vehiculos){
            System.out.print("Modelo: " + vehiculoX.getModelo() + ", potencia: " + vehiculoX.getPotencia());
            if(vehiculoX.iscRuedas()){
                System.out.println(" tiene traccion 4x4");
            }
            else{
                System.out.println(" no tiene traccion 4x4");
            }
        }
    }
}
