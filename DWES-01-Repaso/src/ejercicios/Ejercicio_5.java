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
public class Ejercicio_5 {
    public Ejercicio_5() throws Exception{
        Scanner leer = new Scanner(System.in);
        System.out.print("Introduce el nombre: "); String nombre = leer.nextLine(); //"Maonolo";
        System.out.print("Introduce el no del alumno: "); String numAlumno = leer.nextLine(); //"156";
        System.out.println("\n------------------------------------------------------------------------------");
        
        Ejercicio_5_Alumno alumno = new Ejercicio_5_Alumno(nombre, numAlumno);
        
        System.out.print("Introduce la primera nota: "); String nota1 = leer.nextLine(); //"7,5";
        System.out.print("Introduce la segunda nota: "); String nota2 = leer.nextLine(); //"6";
        alumno.ponNota(nota1, nota2);
        
        System.out.println("\n------------------------------------------------------------------------------");
        System.out.println(alumno.muestraAlumno());
        
    }
}
