/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empresa;

/**
 *
 * @author crisc
 */
public class ServletEmpresa extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String nombre = request.getParameter("nombre");
        String cif = request.getParameter("cif");
        String representante = request.getParameter("representante");
        String nif = request.getParameter("nif");
        String sector = request.getParameter("sector");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String volumen = request.getParameter("volumen");
        String observaciones = request.getParameter("observaciones");
        
        String error = "";
        boolean valido = true;
        if(!validaCif(cif)){
            valido = false;
            error = "CIF";
            contexto.setAttribute("error", error);
            rd = contexto.getRequestDispatcher("/errorEmpresa.jsp");
            rd.forward(request, response);
        }
        
        if(!validaDni(nif)){
            valido = false;
            error = "NIF";
            contexto.setAttribute("error", error);
            rd = contexto.getRequestDispatcher("/errorEmpresa.jsp");
            rd.forward(request, response);
        }
        
        if(!validaTelefono(telefono)){
            valido = false;
            error = "Telefono";
            contexto.setAttribute("error", error);
            rd = contexto.getRequestDispatcher("/errorEmpresa.jsp");
            rd.forward(request, response);
        }
        
        if(valido){
            Empresa empresa = new Empresa(nombre, cif, representante, nif, sector, telefono, email, volumen, observaciones);
            ArrayList<Empresa> empresas = (ArrayList<Empresa>) contexto.getAttribute("empresas");
            if(empresas == null){
                empresas = new ArrayList<Empresa>();
                contexto.setAttribute("empresas", empresas);
            }
            
            empresas.add(empresa);
            rd = contexto.getRequestDispatcher("/formEmpresa.html");
            rd.forward(request, response);
        }
        
    }
    
    public boolean validaCif(String cif){
        if(cif.length() != 9){
            return false;
        }
        
        String o = cif.substring(0, 1);
        String p = cif.substring(1, 3);
        String n = cif.substring(3, 8);
        char c = cif.charAt(cif.length() - 1);
        
        boolean encontrada = false;
        String[] oLetras = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R","S", "U", "V", "W"};
        for(int x = 0; x < oLetras.length; x++){
            if(oLetras[x].equals(o)){
                encontrada = true;
            }
        }
        
        if(!encontrada){
            return false;
        }
        
        encontrada = false;
        String[] pNums = { "01", "02", "03", "53", "54", "04", "05", "06", "07", "57", "08", "58", "59", "60", "61", "62", "63", "64", "09", "10", "11", "72", "12", "13", "14", "56", "15", "70", "16", "17", "55", "18", "19", "20", "71", "21", "22", "23", "24", "25", "26", "27", "28", "78", "79", "80", "81", "82", "83", "84", "85", "29", "92", "93", "30", "73", "31", "32", "33", "74", "34", "35", "76", "36", "94", "37", "38", "75", "39", "40", "41", "91", "42", "43", "77", "44", "45", "46", "96", "97", "98", "47", "48", "95", "49", "50", "99", "51" , "52"};
        for(int x = 0; x < pNums.length; x++){
            if(pNums[x].equals(p)){
                encontrada = true;
            }
        }
        
        if(!encontrada){
            return false;
        }
        
        try {
            int temp = Integer.parseInt(n);
            
            if(o.equals("K") || o.equals("P") || o.equals("Q") || o.equals("S")){
                if(!Character.isLetter(c)){
                    return false;
                }
            }else if(o.equals("A") || o.equals("B") || o.equals("E") || o.equals("H")){
                if(!Character.isDigit(c)){
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    private boolean validaDni(String dni){
        String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E", "T"};
        if(dni.length() != 9){
            return false;
        }
        try {
            String letra = dni.substring(8, 9);
            int numeros = Integer.parseInt(dni.substring(0, 8));
            if(letras[numeros % 23].equals(letra)){
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean validaTelefono (String tlf){
        if(tlf.length() != 9){
            return false;
        }
        
        try {
            int temp = Integer.parseInt(tlf);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
