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
public class ServletUsuario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String usuario = request.getParameter("usuario");
        String contra = request.getParameter("contra");
        
        boolean valido = true;
        if(!contra.equals("trebujena")){
            valido = false;
            rd = contexto.getRequestDispatcher("/errorUsuario.html");
            rd.forward(request, response);
        }
        
        if(!validaDni(usuario)){
            valido = false;
            rd = contexto.getRequestDispatcher("/errorUsuario.html");
            rd.forward(request, response);
        }
        
        if(valido){
            rd = contexto.getRequestDispatcher("/formEmpresa.html");
            rd.forward(request, response);
        }
        
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
}
