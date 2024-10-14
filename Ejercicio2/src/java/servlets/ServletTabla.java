/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author crisc
 */
public class ServletTabla extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String num = (String) getServletContext().getAttribute("numero_valido");
            int numero = Integer.parseInt(num);
            String col = (String) getServletContext().getAttribute("color_valido");
        
            out.print("<html>");
            out.print("<head>");
            out.print("<title> Aplicacion J2EE de Cristina Sanchez </title>");
            out.print("</head>");
            out.print("<body text="+col+">");
            out.print("<h1> Tabla de multiplicar del " + numero + " </b>");
            out.print("<table border=\"1\">");
            for (int i = 1; i <= 9; ++i) {
                out.print("<tr>");
                out.print("<td><b>" + numero + "</b></td>");
                out.print("<td><i> x" + i + " = </i></td>");
                out.print("<td><i> " + (numero * i) + "</i></td>");
                out.print("</tr>");
            }

            out.print("</body>");
            out.print("</html>");
        } catch (Exception e) {
        }finally {
            out.close();
        }

    }
}
