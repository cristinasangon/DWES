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
public class ServletDespacha extends HttpServlet {
     public boolean esValidoColor(String colour) {
        String[] colores = {"red", "yellow", "green", "blue", "pink", "black", "orange"};
        boolean encontrado = false;
        for (int i = 0; i < colores.length && !encontrado; ++i) {
            if (colores[i].equalsIgnoreCase(colour)) 
                encontrado = true;
        }
        return encontrado;
    }
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        try {
            String numero = request.getParameter("numero");
            String color = request.getParameter("color");
            
            int num = Integer.parseInt(numero);
            if(num >= 1 && num <= 9 && esValidoColor(color)){
                contexto.setAttribute("numero_valido", numero);
                contexto.setAttribute("color_valido", color);
                rd = contexto.getRequestDispatcher("/ServletTabla");
                rd.forward(request, response);
            }else{
                if(!esValidoColor(color)){
                    rd = contexto.getRequestDispatcher("/ErrorColor.html");
                }else{
                    rd = contexto.getRequestDispatcher("/ErrorNumero.html");
                }
                rd.forward(request, response);
            }
        } catch (Exception e) {
            rd = contexto.getRequestDispatcher("/ErrorNumero.html");
            rd.forward(request, response);
        }finally{
            
        }
    }
}
