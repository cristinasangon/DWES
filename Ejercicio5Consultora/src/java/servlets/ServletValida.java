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
public class ServletValida extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        boolean validUser = true;
        
        if(!combruebaDni(usuario)){
            validUser = false;
        }
        
        if(!password.equals("trebujena")){
            validUser = false;
        }
        
        if(validUser){
            contexto.setAttribute("usuario", usuario);
            rd = contexto.getRequestDispatcher("/añadirEmpresa.jsp");
            rd.forward(request, response);
        }else{
            rd = contexto.getRequestDispatcher("/errorDatos.html");
            rd.forward(request, response);
        }
        
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
}
