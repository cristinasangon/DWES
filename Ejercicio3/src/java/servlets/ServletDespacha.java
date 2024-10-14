package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDespacha extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String telefono = request.getParameter("telefono"); // Se maneja como cadena
            String ciudad = request.getParameter("ciudad");
            String sexo = request.getParameter("sexo");
            String pais = request.getParameter("pais");
            String areaTexto = request.getParameter("comentario"); 
            if (areaTexto.isEmpty()) {
                areaTexto = "No tengo ningún comentario que mostrar";
            }
            String[] actividades = request.getParameterValues("actividades");
            
            String col = "HotPink", textCol = "Pink", enlace = "mujer.html";
            if(sexo.equals("hombre")){
                col = "DodgerBlue";
                textCol = "MidnightBlue";
                enlace = "hombre.html";
            }

            out.print("<html>");
            out.print("<head><title>Datos Encuesta</title></head>");
            out.print("<body style='background-color:" + col + "'>");
            out.print("<h1 style='color: " + textCol + ";'>Hola " + nombre + "</h1>");
            out.print("<table border=\"1\">");
            out.print("<tr><td><b>Nombre</b></td><td><i>" + nombre + "</i></td></tr>");
            out.print("<tr><td><b>Apellidos</b></td><td><i>" + apellidos + "</i></td></tr>");
            out.print("<tr><td><b>Teléfono</b></td><td><i>" + telefono + "</i></td></tr>");
            out.print("<tr><td><b>Lugar de Nacimiento</b></td><td><i>" + ciudad + "</i></td></tr>");
            out.print("<tr><td><b>Sexo</b></td><td><i>" + sexo + "</i></td></tr>");
            out.print("<tr><td><b>País de Origen</b></td><td><i>" + pais + "</i></td></tr>");
            out.print("<tr><td><b>Comentarios</b></td><td><i>" + areaTexto + "</i></td></tr>");
            out.print("</table>");
            
            out.print("<h1 style='color: " + textCol + ";'>" + nombre + ", tus actividades preferidas son:</h1>");
            out.print("<table border=\"1\">");
            if (actividades == null || actividades.length == 0) {
                out.print("<p> No te gusta nada </p>");
            } else {
                // Agregar la cabecera de actividades
                out.print("<tr><td><b>Actividades</b></td></tr>");
                for (String actividad : actividades) {
                    out.print("<tr><td><i>" + actividad + "</i></td></tr>");
                }
            }
            out.print("</table>");
           
            out.print("<a href='" + enlace + "'>sorpresa</a>"); 
            out.print("</body></html>");
        } catch (Exception e) {
            rd = contexto.getRequestDispatcher("/ErrorDato.html");
            rd.forward(request, response);
        }
    }
}
