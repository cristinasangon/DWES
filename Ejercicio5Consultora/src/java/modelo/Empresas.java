/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author crisc
 */
public class Empresas {
    private ArrayList<Empresa> listadoEmpresas;

    public Empresas() {
        this.listadoEmpresas = new ArrayList<Empresa>();
    }
    
    public void addEmpresa(Empresa empresa){
        listadoEmpresas.add(empresa);
    }
    
    public ArrayList<Empresa> getListadoEmpresas() {
        return listadoEmpresas;
    }
    
    
}
