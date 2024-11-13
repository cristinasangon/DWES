/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

public class Actividades {
    private ArrayList<Actividad> listadoActividades;

    public Actividades() {
        this.listadoActividades = new ArrayList<>();
    }

    // Método para añadir una actividad
    public void addActividad(Actividad actividad) {
        listadoActividades.add(actividad);
    }

    // Método para obtener la lista de actividades
    public ArrayList<Actividad> getListadoActividades() {
        return listadoActividades;
    }
}

