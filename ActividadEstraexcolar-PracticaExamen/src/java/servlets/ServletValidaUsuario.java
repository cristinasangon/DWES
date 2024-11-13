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
public class ServletValidaUsuario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String usuario = request.getParameter("usuario");
        String contra = request.getParameter("contra");
        
        boolean valid = true;
        if(!validaUsuario(usuario)){
            valid = false;
            rd = contexto.getRequestDispatcher("/errorUsuario.html");
            rd.forward(request, response);
        }
        
        if(!validaContraseña(contra, usuario)){
            valid = false;
            rd = contexto.getRequestDispatcher("/errorUsuario.html");
            rd.forward(request, response);
        }
        
        if(valid){
            contexto.setAttribute("usuario", usuario);
            rd = contexto.getRequestDispatcher("/formActividad.jsp");
            rd.forward(request, response);
        }
    }
    
    private boolean validaUsuario(String usuario){
        if(usuario.equals("eso") ||  usuario.equals("sanidad") ||usuario.equals("cocina") ||usuario.equals("informatica")){
            return true;
        }
        return false;
    }
    
    private boolean validaContraseña(String contra, String usuario){
        if(usuario.equals("eso")){
            if(contra.equals("cdpeso")){
                return true;
            }
        }else if(usuario.equals("sanidad")){
            if(contra.equals("cdpsanidad")){
                return true;
            }
        }else if(usuario.equals("cocina")){
            if(contra.equals("cdpcocina")){
                return true;
            }
        }else if(usuario.equals("informatica")){
            if(contra.equals("cdpinformatica")){
                return true;
            }
        }
        return false;
    }
}
