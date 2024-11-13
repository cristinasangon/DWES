/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Actividad;
import modelo.Actividades;

/**
 *
 * @author crisc
 */
public class ServletValida extends HttpServlet {
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ServletContext contexto = getServletContext();
    RequestDispatcher rd;

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    String usuario = (String) contexto.getAttribute("usuario");

    String nombreActividad = request.getParameter("nombreActividad");
    String lugarActividad = request.getParameter("lugarActividad");
    String fechaActividad = request.getParameter("fechaActividad");
    String horaActividad = request.getParameter("horaActividad");
    String destinada = request.getParameter("destinada");
    String[] tipoActividad = request.getParameterValues("tipoActividad");
    String curso = request.getParameter("curso");
    String profesor = request.getParameter("profesor");
    String observaciones = request.getParameter("observaciones");

    boolean valido = true;
        for(int x = 0; x < nombreActividad.length(); x++){
            if(!Character.isLetter(nombreActividad.charAt(x))){
                valido = false;
            }
        }
        
        for(int x = 0; x < lugarActividad.length(); x++){
            if(!Character.isLetter(lugarActividad.charAt(x))){
                valido = false;
            }
        }
        
        for(int x = 0; x < profesor.length(); x++){
            if(!Character.isLetter(profesor.charAt(x))){
                valido = false;
            }
        }
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha = formato.parse(fechaActividad);
        } catch (ParseException e) {
            valido = false;
        }
        
        String[]horaArray = horaActividad.split(":");
        if(horaArray.length == 2){
            try {
                int horas = Integer.parseInt(horaArray[0]);
                int minutos = Integer.parseInt(horaArray[1]);
                if(horas > 23 || horas < 0){
                    valido = false;
                }
                if(minutos > 59 || minutos < 0){
                    valido = false;
                }
            } catch (Exception e) {
                valido = false;
            }
        }else{
            valido = false;
        }
        
        if(tipoActividad == null){
            valido = false;
        }

    if (valido) {
        Actividades actividades = (Actividades) contexto.getAttribute("actividades");
            if (actividades == null) {
                actividades = new Actividades();
                contexto.setAttribute("actividades", actividades);
            }
        contexto.setAttribute("usuario", usuario);
        Actividad actividad = new Actividad(nombreActividad, lugarActividad, fechaActividad, horaActividad, destinada, tipoActividad, curso, profesor, observaciones);
        actividades.addActividad(actividad);        
        rd = contexto.getRequestDispatcher("/actividadExtraescolas.jsp");
        rd.forward(request, response);
    } else {
        rd = contexto.getRequestDispatcher("/actividadExtraescolas.jsp");
        rd.forward(request, response);
    }
}
}
