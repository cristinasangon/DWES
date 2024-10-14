/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package misejemplos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author crisc
 */
@WebServlet(name = "ServletEnlace", urlPatterns = {"/ServletEnlace"})
public class ServletEnlace extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        out.print("<html>");
        out.print("<head><title>Servlet enlace</title></head>");
        out.print("<body bgcolor= \"yellow\">");
        out.print("<h2>Vienes de pulsar el enlace \"pulsame\"</h2>");
        out.print("<table border=\"5\">");
        out.print("<img src='/servlets-examples/tomcat.gif\'>");
        out.print("</body>");
        out.print("</html>");
    }

}
