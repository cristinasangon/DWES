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
        
        //RECOGER DATOS
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
        String servicios[] = request.getParameterValues("servicios");
        
        //VALIDAR DATOS
        String errores = "";
        boolean valido = true;
        
        if(!validaCadenaSinNumeros(nombre)){
            valido = false;
            errores = errores + ", nombre";
        }
        
        if(!validaCadenaSinNumeros(apellidos)){
            valido = false;
            errores = errores + ", apellidos";
        }
        
        if(!validaDni(dni)){
            valido = false;
            errores = errores + ", dni";
        }
        
        if(!validaSs(ss)){
            valido = false;
            errores = errores + ", ss";
        }
        
        if(!validaTlf(telefono)){
            valido = false;
            errores = errores + ", telefono";
        }
        
        if(!email.equals("")){
            if(!validaEmail(email)){
            valido = false;
            errores = errores + ", email";
            }
        }

        if(!validaFechas(entrada, salida)){
            valido = false;
            errores = errores + ", fechas";
        }
        
        
        if(!valido){
            contexto.setAttribute("errores", errores);
            rd = contexto.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }else{
            Reserva reserva = new Reserva(nombre, apellidos, dni, ss, telefono, email, provincia, entrada, salida, regimen, servicios);
            ArrayList<Reserva> reservas = (ArrayList<Reserva>) contexto.getAttribute("reservas");
            if(reservas == null){
                reservas = new ArrayList<Reserva>();
                contexto.setAttribute("reservas", reservas);
            }
            reservas.add(reserva);
            rd = contexto.getRequestDispatcher("/index.html");
            rd.forward(request, response);
        }
    }
    
    private boolean validaCadenaSinNumeros(String cadena){
        for(int x = 0; x < cadena.length(); x++){
            if(Character.isDigit(cadena.charAt(x))){
                return false;
            }
        }
        return true;
    }
    
    private boolean validaDni(String dni){
        try {
            if(dni.length() != 9){
                return false;
            }
            String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E", "T"};
        
            String letra = "" + dni.charAt(dni.length() - 1);
            dni = dni.substring(0, dni.length() - 1);
            
            int numeros = Integer.parseInt(dni);
            
            numeros %= 23;
            if(!letras[numeros].equals(letra)){
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private boolean validaSs(String ss){
        if(ss.length() != 12){
            return false;
        }
        try {
            for(int y = 0; y < ss.length(); y++){
                int i = Integer.parseInt(Character.toString(ss.charAt(y)));
            }
            
            String[] codigos = { "01", "02", "03", "53", "54", "04", "05", "06", "07", "57", "08", "58", "59", "60", "61", "62", "63", "64", "09", "10", "11", "72", "12", "13", "14", "56", "15", "70", "16", "17", "55", "18", "19", "20", "71", "21", "22", "23", "24", "25", "26", "27", "28", "78", "79", "80", "81", "82", "83", "84", "85", "29", "92", "93", "30", "73", "31", "32", "33", "74", "34", "35", "76", "36", "94", "37", "38", "75", "39", "40", "41", "91", "42", "43", "77", "44", "45", "46", "96", "97", "98", "47", "48", "95", "49", "50", "99", "51" , "52"};
            String cp = ss.substring(0, 2);
            boolean encontrado = false;
            
            for(int x = 0; x < codigos.length; x++){
                if(codigos[x].equals(cp)){
                    encontrado = true;
                }
            }
            
            if(!encontrado){
                return false;
            }
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private boolean validaTlf(String tlf){
        try {
            if(tlf.substring(0,1).equals("+")){
                String[] codigos = { "01", "02", "03", "53", "54", "04", "05", "06", "07", "57", "08", "58", "59", "60", "61", "62", "63", "64", "09", "10", "11", "72", "12", "13", "14", "56", "15", "70", "16", "17", "55", "18", "19", "20", "71", "21", "22", "23", "24", "25", "26", "27", "28", "78", "79", "80", "81", "82", "83", "84", "85", "29", "92", "93", "30", "73", "31", "32", "33", "74", "34", "35", "76", "36", "94", "37", "38", "75", "39", "40", "41", "91", "42", "43", "77", "44", "45", "46", "96", "97", "98", "47", "48", "95", "49", "50", "99", "51" , "52"};
                String cod = tlf.substring(1,3);
                
                boolean encontrado = false;
                for(int x = 0; x < codigos.length; x++){
                    if(codigos[x].equals(cod)){
                        encontrado = true;
                    }
                }
                
                if(!encontrado){
                    return false;
                }
                
                String numTlf = tlf.substring(3, tlf.length());
                if(numTlf.length() != 9){
                    return false;
                }
                
                int pruebaDig = Integer.parseInt(numTlf);
            }else{
                if(tlf.length() != 9){
                    return false;
                }
                
                int pruebaDig = Integer.parseInt(tlf);
            }
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private boolean validaEmail(String email){
        String[] arroba = email.split("@");
        if(arroba.length != 2){
            return false;
        }
        
        String[] punto = email.split("\\.");
        if(punto.length < 2){
            return false;
        }
        return true;
    }
    
    private boolean validaFechas(String entrada, String salida){
        LocalDate entradaFecha = LocalDate.parse(entrada);
        LocalDate salidaFecha = LocalDate.parse(salida);
        if(salidaFecha.isBefore(entradaFecha)){
            return false;
        }
        
        long diferencia = ChronoUnit.DAYS.between(entradaFecha, salidaFecha);
        if(diferencia > 7){
            return false;
        }
        return true;
    }
}
