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
        
        String importe = request.getParameter("importe");
        String entregado = request.getParameter("entregado");
        
        boolean valido = true;
        
        if(importe == "" || entregado == ""){
            valido = false;
        }else{
            try {
                double imp = Double.parseDouble(importe);
                double ent = Double.parseDouble(entregado);
            } catch (Exception e) {
                valido = false;
            }
        }
        
        if(valido){
            contexto.setAttribute("importe", importe);
            contexto.setAttribute("entregado", entregado);
            rd = contexto.getRequestDispatcher("/resultado.jsp");
            rd.forward(request, response);
        }else{
            rd = contexto.getRequestDispatcher("/error.html");
            rd.forward(request, response);
        }
    }
}
