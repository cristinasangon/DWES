/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author crisc
 */
public class Ejercicio_8 {
   public Ejercicio_8() throws Exception {
        Scanner leer = new Scanner(System.in);
        List<Ejercicio_5_Alumno> alumnos = new ArrayList<>();
        int numAlumno;

        while (true) {
            System.out.print("Número de matrícula (<0 para finalizar): ");
            String numAl = leer.next();
            numAlumno = Integer.parseInt(numAl);
            if (numAlumno <= 0) {
                break; // Salir del bucle si se introduce un número menor o igual a 0
            }

            // Comprobar si el número de matrícula ya existe
            boolean numAlRepetido = false;
            for (Ejercicio_5_Alumno alumnoX : alumnos) {
                if (("" + alumnoX.getNumAlumno()).equals(numAl)) {
                    numAlRepetido = true;
                    System.out.println("El alumno con ese número de matrícula ya existe, introduce uno nuevo");
                    break; // Salir del bucle si se encuentra un número duplicado
                }
            }

            // Si no es un número duplicado, pedir los otros datos
            if (!numAlRepetido) {
                System.out.print("Introduce el nombre: ");
                String nombre = leer.next();
                System.out.print("Primera nota: ");
                String nota1 = leer.next();
                System.out.print("Segunda nota: ");
                String nota2 = leer.next();
                Ejercicio_5_Alumno alumno = new Ejercicio_5_Alumno(nombre, numAl, nota1, nota2);
                alumnos.add(alumno);
            }
        }

        // Calcular y mostrar la media
        double medias = 0;
        if (!alumnos.isEmpty()) {
            for (Ejercicio_5_Alumno alumnoX : alumnos) {
                System.out.println(alumnoX.getNumAlumno() + " " + alumnoX.getNombre() + " nota media: " + alumnoX.dameMedia());
                medias += alumnoX.dameMedia();
            }

            medias /= alumnos.size();
            System.out.println("La media es: " + medias);
        } else {
            System.out.println("No se registraron alumnos.");
        }
    }
}