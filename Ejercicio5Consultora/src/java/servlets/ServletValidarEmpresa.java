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
import modelo.Empresas;

/**
 *
 * @author crisc
 */
public class ServletValidarEmpresa extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String nombreEmpresa = request.getParameter("nombreEmpresa");
        String cif = request.getParameter("cif");
        String representanteEmpresa = request.getParameter("representanteEmpresa");
        String nif = request.getParameter("nif");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String volumen = request.getParameter("volumen");
        String observaciones = request.getParameter("observaciones");
        String sector = request.getParameter("sector");

        if(!combruebaDni(nif)){
            rd = contexto.getRequestDispatcher("/errorNif.html");
            rd.forward(request, response);
        }
        
        if(!compruebaCif(cif)){
            rd = contexto.getRequestDispatcher("/errorCif.html");
            rd.forward(request, response);
        }
        
        if(!compruebaTelefono(telefono)){
            rd = contexto.getRequestDispatcher("/errorTlf.html");
            rd.forward(request, response);
        }
        
        Empresa empresa = new Empresa(nombreEmpresa, cif, representanteEmpresa, nif, telefono, email, volumen, observaciones, sector);
        
        ArrayList<Empresa> empresas = (ArrayList<Empresa>) contexto.getAttribute("lista");

        if (empresas == null) {
            empresas = new ArrayList<Empresa>();
            contexto.setAttribute("lista", empresas);
        }

        empresas.add(empresa);
        response.sendRedirect("listadoEmpresas.jsp");
    }
    
    private boolean combruebaDni(String dni){  
        try {
            String letraDni = dni.substring(dni.length()-1);
            int numDni = Integer.parseInt(dni.substring(0, dni.length()-1));
            String[] letras = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E", "T" };
            numDni %= 23;
            if(letras[numDni].equals(letraDni)){
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    private boolean compruebaCif(String cif){
        if(cif.length() != 9){
            return false;
        }
        String[] tipoOrgLetras = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R","S", "U", "V", "W"};
        String tipoOrg = "" + cif.charAt(0);
        boolean encontrada = false;
        for(int x = 0; x < tipoOrgLetras.length; x++){
            if(tipoOrgLetras[x].equals(tipoOrg)){
                encontrada = true;
                break;
            }
        }
        if(!encontrada){
            return false;
        }
        
        encontrada = false;
        String[] provinciaArray = { "01", "02", "03", "53", "54", "04", "05", "06", "07", "57", "08", "58", "59", "60", "61", "62", "63", "64", "09", "10", "11", "72", "12", "13", "14", "56", "15", "70", "16", "17", "55", "18", "19", "20", "71", "21", "22", "23", "24", "25", "26", "27", "28", "78", "79", "80", "81", "82", "83", "84", "85", "29", "92", "93", "30", "73", "31", "32", "33", "74", "34", "35", "76", "36", "94", "37", "38", "75", "39", "40", "41", "91", "42", "43", "77", "44", "45", "46", "96", "97", "98", "47", "48", "95", "49", "50", "99", "51" , "52"};
        String provincia = cif.substring(1, 3);
        for(int x = 0; x < provinciaArray.length; x++){
            if(provinciaArray[x].equals(provincia)){
                encontrada = true;
                break;
            }
        }
        if(!encontrada){
            return false;
        }
        
        String numCorr = cif.substring(3, 8);
        try {
            double temp = Double.parseDouble(numCorr);
        } catch (Exception e) {
            return false;
        }
        
        char control= cif.charAt(cif.length()-1);
        
        if(tipoOrg.equals("K") || tipoOrg.equals("P") || tipoOrg.equals("Q") || tipoOrg.equals("S")){
            if(!Character.isLetter(control)){
                return false;
            }
        }else if(tipoOrg.equals("A") || tipoOrg.equals("B") || tipoOrg.equals("E") || tipoOrg.equals("H")){
            if(!Character.isDigit(control)){
                return false;
            }
        }
        
        return true;
    }
    
    boolean compruebaTelefono(String tlf){
        if(tlf.length() != 9){
            return false;
        }
        try {
            double temp = Double.parseDouble(tlf);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

