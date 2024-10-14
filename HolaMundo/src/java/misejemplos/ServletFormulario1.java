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
@WebServlet(name = "ServletFormulario1", urlPatterns = {"/ServletFormulario1"})
public class ServletFormulario1 extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String nom = request.getParameter("nombre");
       String tef = request.getParameter("telefono");
       String lugNaci = request.getParameter("lugar de nacimiento");
       
       response.setContentType("text/html");
       
       PrintWriter out = response.getWriter();
       
       out.print("<html>");
       out.print("<head><title>Datosintroducidos por Formulario1</title></head>");
       out.print("<body>");
       out.print("<h1>DATOS INTRODUCIDOS</h1>");
       out.print("<table border=\"5\">");
       out.print("<tr><td><b>NOMBRE:</b></td> <td><i>" + nom + "</i></td>");
       out.print("<tr><td><b>TELEFONO:</b></td> <td><i>" + tef + "</i></td>");
       out.print("<tr><td><b>LUGAR DE NACIMIENTO:</b></td> <td><i>" + lugNaci + "</i></td>");
       out.print("</table><p>");
       out.print("</body>");
       out.print("</html>");
   }


}
