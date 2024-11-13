<%-- 
    Document   : listado
    Created on : 17 oct. 2024, 8:53:09
    Author     : crisc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Actividades"%>
<%@page import="modelo.Actividad"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listado de Actividades</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Listado de Actividades</h1>
    <%
        // Obtener la lista de actividades del contexto
        Actividades actividades = (Actividades) application.getAttribute("actividades");
    %>
    
    <table>
        <thead>
            <tr>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Nombre de la actividad</th>
                <th>Lugar de celebracion</th>
                <th>Personal de destino</th>
                <th>Curso</th>
                <th>Tipo de Actividad</th>
                <th>Dpto que lo organiza</th>
                <th>Responsable</th>
                <th>Observaciones</th>
            </tr>
        </thead>
        <tbody>
            <tbody>
    <%
        if (actividades != null) {
            ArrayList<Actividad> listaActividades = actividades.getListadoActividades();
            String destino = request.getParameter("destino");
            boolean actividadesFiltradas = false; // Para controlar si hay actividades que mostrar
            
            for (Actividad actividad : listaActividades) {
                // Filtrar actividades según el destino
                if (destino == null || destino.isEmpty() || actividad.getDestinada().equals(destino)) {
                    out.println("<tr>");
                    out.println("<td>" + actividad.getFecha() + "</td>");
                    out.println("<td>" + actividad.getHora() + "</td>");
                    out.println("<td>" + actividad.getNombre() + "</td>");
                    out.println("<td>" + actividad.getLugar() + "</td>");
                    out.println("<td>" + actividad.getDestinada() + "</td>");
                    out.println("<td>" + actividad.getCurso() + "</td>");
                    out.println("<td>" + String.join(", ", actividad.getTipoActividad()) + "</td>"); // Unir los tipos en una sola cadena
                    String usuario = (String) getServletContext().getAttribute("usuario");
                    if (usuario.equals("eso")) {
                        out.println("<td>ESO</td>");
                    } else if (usuario.equals("sanidad")) {
                        out.println("<td>SANIDAD</td>");
                    } else if (usuario.equals("cocina")) {
                        out.println("<td>COCINA</td>");
                    } else if (usuario.equals("informatica")) {
                        out.println("<td>INFORMATICA</td>");
                    }
                    
                    out.println("<td>" + actividad.getProfesor() + "</td>");
                    out.println("<td>" + actividad.getObservaciones() + "</td>");
                    out.println("</tr>");
                    actividadesFiltradas = true; // Se encontró al menos una actividad
                }
            }
            
            if (!actividadesFiltradas) {
                out.println("<tr><td colspan='10'>No hay actividades registradas para el destino seleccionado.</td></tr>");
            }
        } else {
            out.println("<tr><td colspan='10'>No hay actividades registradas.</td></tr>");
        }
    %>
</tbody>

        </tbody>
    </table>
    
    <button name="botonVolver" onclick="window.location.href='actividadExtraescolas.jsp'">Seguir añadiendo actividades</button>
    <button name="botonVerProfesorado" onclick="window.location.href='listado.jsp'">Ver todas las actividades</button>
    <button name="botonVerAlumnado" onclick="window.location.href='listado.jsp?destino=alumnado'">Ver actividades del alumnado</button>
<button name="botonVerProfesorado" onclick="window.location.href='listado.jsp?destino=profesorado'">Ver actividades del profesorado</button>

</html>

