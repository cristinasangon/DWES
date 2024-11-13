/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author crisc
 */
public class ServletLogin extends HttpServlet {
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ServletContext contexto = getServletContext();
    RequestDispatcher rd;

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    String usuario = request.getParameter("usuario");
    String contraseña = request.getParameter("password");
    String dpto = "";
    boolean valido = true;
    
    // Validación del usuario y contraseña
    if(usuario.equals("eso")){
        if(contraseña.equals("cdpjosecabreraeso")){
            dpto = "ESO";
        }else{
            valido = false;
        }
    }else if(usuario.equals("sanidad")){
        if(contraseña.equals("cdpjosecabrerasanidad")){
            dpto = "SANIDAD";
        }else{
            valido = false;
        }
    }else if(usuario.equals("cocina")){
        if(contraseña.equals("cdpjosecabreracocina")){
            dpto = "COCINA";
        }else{
            valido = false;
        }
    }else if(usuario.equals("informatica")){
        if(contraseña.equals("cdpjosecabrerainformatica")){
            dpto = "INFORMATICA";
        }else{
            valido = false;
        }
    }else{
       valido = false; 
    }
    
    if(valido){
        // Aquí guardamos el usuario en el contexto
        contexto.setAttribute("usuario", usuario); // Cambiamos request.setAttribute() por contexto.setAttribute()
        
        // Redirigir a la JSP de actividades extraescolares
        rd = contexto.getRequestDispatcher("/actividadExtraescolas.jsp");
        rd.forward(request, response);
    }else{
        // Redirigir a la página de error si los datos no son válidos
        rd = contexto.getRequestDispatcher("/error.html");
        rd.forward(request, response);
    }
}

}
