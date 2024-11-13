/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Actividad;

/**
 *
 * @author crisc
 */
public class ServletValidaActividad extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String nombre = request.getParameter("nombre");
        String lugar = request.getParameter("lugar");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String destinada = request.getParameter("destinada");
        String[] tipo = request.getParameterValues("tipo");
        String curso = request.getParameter("curso");
        String responsable = request.getParameter("responsable");
        String observaciones = request.getParameter("observaciones");
        
        String usuario = (String) contexto.getAttribute("usuario");
        
        boolean valido = true;
        
        if(!validarCadena(nombre)){
            valido = false;
        }
        
        if(!validarCadena(lugar)){
            valido = false;
        }
        
        if(!validarCadena(responsable)){
            valido = false;
        }
        
        if(!validarFecha(fecha)){
            valido = false;
        }
        
        if(!validaHora(hora)){
            valido = false;
        }
        
        if(tipo == null){
            valido = false;
        }
        
        
        if(valido){
            Actividad avtividad = new Actividad(nombre, lugar, fecha, hora, destinada, curso, responsable, observaciones, usuario, tipo);
            ArrayList<Actividad> actividades = (ArrayList<Actividad>) contexto.getAttribute("actividades");
            if(actividades == null){
                actividades = new ArrayList<Actividad>();
            }
            
            actividades.add(avtividad);
            contexto.setAttribute("actividades", actividades);
            rd = contexto.getRequestDispatcher("/formActividad.jsp");
            rd.forward(request, response);
        }else{
            rd = contexto.getRequestDispatcher("/formActividad.jsp");
            rd.forward(request, response);
        }
    }
    
    public boolean validarCadena(String cadena){
        for(int x = 0; x < cadena.length(); x++){
            if(!Character.isLetter(cadena.charAt(x))){
                return false;
            }
        }
        return true;
    }
    
    public boolean validarFecha(String fecha){
        String[] fechaSeparada = fecha.split("/");
        if(fechaSeparada.length != 3){
            return false;
        }
        if(fechaSeparada[1].length() == 1){
            fechaSeparada[1] = "0" + fechaSeparada[1];
        }
        if(fechaSeparada[0].length() == 1){
            fechaSeparada[0] = "0" + fechaSeparada[0];
        }
        
        String fechaCorregida = fechaSeparada[2] + "-" + fechaSeparada[1] + "-" + fechaSeparada[0];
        try {
            LocalDate.parse(fechaCorregida);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean validaHora (String hora){
        String[] horaSeparada = hora.split(":");
        if(horaSeparada.length != 2){
            return false;
        }
        
        try {
            int horas = Integer.parseInt(horaSeparada[0]);
            int minutos = Integer.parseInt(horaSeparada[1]);
            
            if(horas > 23 || horas < 0){
                return false;
            }else if(minutos > 59 || minutos < 0){
                return false;
            }
       
             return true;
        } catch (Exception e) {
            return false;
        }
    }
}
