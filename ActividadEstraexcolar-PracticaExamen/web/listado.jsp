<%-- 
    Document   : listado
    Created on : 27 oct. 2024, 18:41:52
    Author     : crisc
--%>

<%@page import="java.util.Collections"%>
<%@page import="modelo.Actividad"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LISTA DE ACTIVIDADES</h1>
        <table border="2px">
            <tr>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Nombre de la Actividad</th>
                <th>Lucar de celebracion</th>
                <th>Personal de destino</th>
                <th>Curso</th>
                <th>Tipo de actividad</th>
                <th>Dpto que lo organiza</th>
                <th>Responsable</th>
                <th>Observaciones</th>
            </tr>
            
            <%
                ArrayList<Actividad> actividades = (ArrayList<Actividad>) getServletContext().getAttribute("actividades");
                
                String filtro = request.getParameter("filtro");
                if(actividades != null){
                Collections.sort(actividades);
                    if(filtro == null){
                        for(Actividad actividad: actividades){
                            out.print("<tr>");
                            out.print("<td>" + actividad.getFecha() + "</td>");
                            out.print("<td>" + actividad.getHora() + "</td>");
                            out.print("<td>" + actividad.getNombre() + "</td>");
                            out.print("<td>" + actividad.getLugar() + "</td>");
                            out.print("<td>" + actividad.getDestinada() + "</td>");
                            out.print("<td>" + actividad.getCurso() + "</td>");
                            String tipo = "";
                            for(int x = 0; x < actividad.getTipo().length; x++){
                                if(x > 0){
                                    tipo += ", ";
                                }
                                tipo += actividad.getTipo()[x];
                            }
                            out.print("<td>" + tipo + "</td>");
                            out.print("<td>" + actividad.getDepartamento() + "</td>");
                            out.print("<td>" + actividad.getProfesor() + "</td>");
                            out.print("<td>" + actividad.getObservaciones() + "</td>");
                            out.print("<tr>");
                        }
                    }else{
                        for(Actividad actividad: actividades){
                        if(filtro.equals(actividad.getDestinada())){
out.print("<tr>");
                                out.print("<td>" + actividad.getFecha() + "</td>");
                                out.print("<td>" + actividad.getHora() + "</td>");
                                out.print("<td>" + actividad.getNombre() + "</td>");
                                out.print("<td>" + actividad.getLugar() + "</td>");
                                out.print("<td>" + actividad.getDestinada() + "</td>");
                                out.print("<td>" + actividad.getCurso() + "</td>");
                                String tipo = "";
                                for(int x = 0; x < actividad.getTipo().length; x++){
                                    if(x > 0){
                                        tipo += ", ";
                                    }
                                    tipo += actividad.getTipo()[x];
                                }
                                out.print("<td>" + tipo + "</td>");
                                out.print("<td>" + actividad.getDepartamento() + "</td>");
                                out.print("<td>" + actividad.getProfesor() + "</td>");
                                out.print("<td>" + actividad.getObservaciones() + "</td>");
                                out.print("<tr>");
                        }
                                
                            }
                        }
                }else{
                    out.print("<tr> <td> No hay actividades </td> </tr>");
                }
            %>
        </table>
        
        <br>
        <a href="formActividad.jsp"> <button> Seguir añadiendo actividades </button> </a>
        <a href="listado.jsp"> <button> Ver todas las actividades </button> </a>
        <a href="listado.jsp?filtro=alumnado"> <button> Ver actividades del alumnado </button> </a>
        <a href="listado.jsp?filtro=profesorado"> <button> Ver actividades del profesorado </button> </a>
    </body>
</html>
