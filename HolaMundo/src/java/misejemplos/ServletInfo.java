/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package misejemplos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author crisc
 */
public class ServletInfo extends HttpServlet {
    @Override
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
       out.print("</br>");
       out.print("<table border=\"5\">");
       out.print("<tr><td><b>Protocolo de la peticion:</b></td> <td><i>" + request.getProtocol() + "</i></td>");
       out.print("<tr><td><b>Nombre del cliente:</b></td> <td><i>" + request.getRemoteAddr() + "</i></td>");
       out.print("<tr><td><b>Direccion ip del cliente:</b></td> <td><i>" + request.getRemoteAddr() + "</i></td>");
       out.print("<tr><td><b>Clave del usuario que realiza la peticion:</b></td> <td><i>" + null + "</i></td>");
       out.print("<tr><td><b>Tipo de peticion:</b></td> <td><i>" + request.getMethod() + "</i></td>");
       out.print("<tr><td><b>Tipo MIME usado por el cliente:</b></td> <td><i>" + request.getContentType() + "</i></td>");
       out.print("<tr><td><b>Cadena de parametros de la peticion:</b></td> <td><i>" + null + "</i></td>");
       out.print("<tr><td><b>URI de la peticion:</b></td> <td><i>" + request.getRequestURI() + "</i></td>");
       out.print("<tr><td><b>URL de la peticion:</b></td> <td><i>" + request.getRequestURL() + "</i></td>");
       out.print("<tr><td><b>Ruta URI del Servlet:</b></td> <td><i>" + request.getServletPath() + "</i></td>");
       out.print("<tr><td><b>Nombre del servidor web que recibe la peticion:</b></td> <td><i>" + request.getServerName() + "</i></td>");
       out.print("<tr><td><b>Nombre del puerto en el que el servidor acepta la conexion del cliente:</b></td> <td><i>" + request.getLocalPort() + "</i></td>");
       out.print("</table><p>");
       out.print("</br>");
       out.print("<table border=\"5\">");
       out.print("<tr><td><b>host:</b></td> <td><i>" + request.getServerName() + ":" + request.getLocalPort() + "</i></td>");
       out.print("<tr><td><b>user-agent:</b></td> <td><i>" + request.getHeader("user-agent") + "</i></td>");
       out.print("<tr><td><b>accept:</b></td> <td><i>" + request.getHeader("accept") + "</i></td>");
       out.print("<tr><td><b>accept-language:</b></td> <td><i>" + request.getHeader("accept-language") + "</i></td>");
       out.print("<tr><td><b>accept-encoding:</b></td> <td><i>" + request.getHeader("accept-encoding") + "</i></td>");
       out.print("<tr><td><b>accept-charset:</b></td> <td><i>" + request.getHeader("Accept-Charset") + "</i></td>");
       out.print("<tr><td><b>keep-alive:</b></td> <td><i>" + request.getHeader("Keep-Alive") + "</i></td>");
       out.print("<tr><td><b>connection:</b></td> <td><i>" + request.getRequestURI() + "</i></td>");
       out.print("<tr><td><b>referer:</b></td> <td><i>" + request.getHeader("Referer") + "</i></td>");
       out.print("<tr><td><b>content-type:</b></td> <td><i>" + request.getContentType() + "</i></td>");
       out.print("<tr><td><b>content-length:</b></td> <td><i>" + request.getContentLength() + "</i></td>");
       out.print("</table><p>");
       out.println("<table border=\"4\">");
       out.println("Headers optimizado<hr/>");

       Enumeration<String> encabezados = request.getHeaderNames();
       while (encabezados.hasMoreElements()) {
           String nom_encabezado = encabezados.nextElement();
           out.print("<tr><td>" + nom_encabezado + "</td>");
           String valor_cabecera = request.getHeader(nom_encabezado);
           out.print("<td>" + valor_cabecera + "</td></tr>");
       }
       out.println("</table>");
       out.print("</body>");
       out.print("</html>");
    }
}
