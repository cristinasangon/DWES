/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Reserva;

/**
 *
 * @author crisc
 */
public class ServletValida extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String dni = request.getParameter("dni");
        String ss = request.getParameter("ss");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String provincia = request.getParameter("provincia");
        String entrada = request.getParameter("entrada");
        String salida = request.getParameter("salida");
        String regimen = request.getParameter("regimen");
        String[] serviciosExtra = request.getParameterValues("servicios");
        
        String errores = "";
        boolean valido = true;
        
        if(!validaCadena(nombre)){
            errores += ", nombre";
            valido = false;
        }
        
        if(!validaCadena(apellidos)){
            errores += ", apellidos";
            valido = false;
        }
        
        if(!validaDni(dni)){
            errores += ", dni";
            valido = false;
        }
        
        if(!validaSs(ss)){
            errores += ", ss";
            valido = false;
        }
        
        if(!validaTelefono(telefono)){
            errores += ", telefono";
            valido = false;
        }
        
        if(!email.equals("")){
            if(!validaEmail(email)){
                errores += ", email";
                valido = false;
            }
        }
        
        if(!validaFechas(entrada, salida)){
            errores += ", fecha de alojamiento";
            valido = false;
        }
        
        if(valido){
            Reserva reserva = new Reserva(nombre, apellidos, dni, ss, telefono, email, provincia, entrada, salida, regimen, serviciosExtra);
            ArrayList<Reserva> reservas = (ArrayList<Reserva>) contexto.getAttribute("reservas");
            if(reservas == null){
                reservas = new ArrayList<Reserva>();
            }
            
            reservas.add(reserva);
            contexto.setAttribute("reservas", reservas);
            rd = contexto.getRequestDispatcher("/index.html");
            rd.forward(request, response);
            
        }else{
            contexto.setAttribute("errores", errores);
            rd = contexto.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
        
        
    }
    
    public boolean validaCadena(String cadena){
        for(int x = 0; x < cadena.length(); x++){
            if(Character.isDigit(cadena.charAt(x))){
                return false;
            }
        }
        return true;
    }
    
    public boolean validaDni(String dni){
        if(dni.length() != 9){
            return false;
        }
        
        String letra = "" + dni.charAt(dni.length() - 1);
        String numeros = dni.substring(0, 8);
        String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E", "T"};
        
        try {
            int temp = Integer.parseInt(numeros);
            temp %= 23;
            
            if(letras[temp].equals(letra)){
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
    
    public boolean validaSs(String ss){
        String[] numeros = { "01", "02", "03", "53", "54", "04", "05", "06", "07", "57", "08", "58", "59", "60", "61", "62", "63", "64", "09", "10", "11", "72", "12", "13", "14", "56", "15", "70", "16", "17", "55", "18", "19", "20",  "71", "21", "22", "23", "24", "25", "26", "27", "28", "78", "79", "80", "81", "82", "83", "84", "85",  "29", "92", "93", "30", "73", "31", "32", "33", "74", "34", "35", "76", "36", "94", "37", "38", "75",  "39", "40", "41", "91", "42", "43", "77", "44", "45", "46", "96", "97", "98", "47", "48", "95", "49",  "50", "99", "51" , "52"};
        
        if(ss.length() != 12){
            return false;
        }
        
        String ns = ss.substring(0, 2);
        String nums = ss.substring(2, 12);
        
        try {
            for(int x = 0; x < nums.length(); x++){
                int temp = Integer.parseInt(Character.toString(nums.charAt(x)));
            }
            
        } catch (Exception e) {
            return false;
        }
        
        for(int x = 0; x < numeros.length; x++){
            if(ns.equals(numeros[x])){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean validaTelefono (String tlf){
        String num = "";
        if(Character.toString(tlf.charAt(0)).equals("+")){
            String prefIn = tlf.substring(1, 3);
            num = tlf.substring(3, tlf.length());
            
            String[] numeros = { "01", "02", "03", "53", "54", "04", "05", "06", "07", "57", "08", "58", "59", "60", "61", "62", "63", "64", "09", "10", "11", "72", "12", "13", "14", "56", "15", "70", "16", "17", "55", "18", "19", "20",  "71", "21", "22", "23", "24", "25", "26", "27", "28", "78", "79", "80", "81", "82", "83", "84", "85",  "29", "92", "93", "30", "73", "31", "32", "33", "74", "34", "35", "76", "36", "94", "37", "38", "75",  "39", "40", "41", "91", "42", "43", "77", "44", "45", "46", "96", "97", "98", "47", "48", "95", "49",  "50", "99", "51" , "52"};
            
            boolean encontrado = false;
            for(int x = 0; x < numeros.length; x++){
                if(prefIn.equals(numeros[x])){
                    encontrado = true;
                }
            }
            
            if(!encontrado){
                return false;
            }
        }else{
            num = tlf;
        }
        
        
        if(num.length() != 9){
            return false;
        }
        
        try {
            int temp = Integer.parseInt(num);
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }

    public boolean validaEmail(String email){
        String[] arroba = email.split("@");
        String[] punto = email.split("\\.");
        
        if(arroba.length != 2){
            return false;
        }
        
        if(punto.length < 2){
            return false;
        }
        return true;
    }
    
    public boolean validaFechas(String entrada, String salida){
        LocalDate entradaDate = LocalDate.parse(entrada);
        LocalDate salidaDate = LocalDate.parse(salida);
        
        if(salidaDate.isBefore(entradaDate)){
            return false;
        }
        
        long diferencia = ChronoUnit.DAYS.between(entradaDate, salidaDate);
        if(diferencia > 7){
            return false;
        }
        
        return true;
    }
}
