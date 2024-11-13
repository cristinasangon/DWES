<%-- 
    Document   : actividadExtraescolas
    Created on : 15 oct. 2024, 10:43:15
    Author     : crisc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="/EjercicioJoseCabreraWeb/ServletValida">
            <p>Nombre de la actividad: <input type="text" maxlength="60" name="nombreActividad" required> </p>
            <p>Lugar de celebracion: <input type="text" maxlength="60" name="lugarActividad" required> </p>
            <p>Fecha: <input type="text" maxlength="10" name="fechaActividad" placeholder="DD/MM/AAAA" required> </p>
            <p>Hora: <input type="text" maxlength="5" name="horaActividad" placeholder="HH:MM" required> </p>

            <p>Destinada a:</p>
            <label>
                <input type="radio" name="destinada" value="alumnado" required> Alumnado
            </label>
            <label>
                <input type="radio" name="destinada" value="profesorado" required> Profesorado
            </label>
            <br><br>
            <p>Tipo de Actividad:</p>
            <label>
                <input type="checkbox" name="tipoActividad" value="academica"> Academica
            </label><br>
            <label>
                <input type="checkbox" name="tipoActividad" value="deportiva"> Deportiva
            </label><br>
            <label>
                <input type="checkbox" name="tipoActividad" value="cultural"> Cultural
            </label><br>
            <label>
                <input type="checkbox" name="tipoActividad" value="convivenvia"> Convivencia
            </label><br><br>
            
            <p>Curso:</p>
            <%
    String usuario = (String) getServletContext().getAttribute("usuario");
    if (usuario != null) {
        if (usuario.equals("eso")) {
%>
            <select name="curso">
                <option value="1">1º</option>
                <option value="2">2º</option>
                <option value="3">3º</option>
                <option value="4">4º</option>
            </select>
<%
        } else {
%>
            <select name="curso">
                <option value="1">1º</option>
                <option value="2">2º</option>
            </select>
<%
        }
    } else {
        out.println("<p>Error: Usuario no especificado.</p>");
    }
%>

            <br><br>
            
            <p>Profesor responsable: <input type="text" maxlength="5" name="profesor" required> </p>
            <p>Observaciones: <textarea name="observaciones"></textarea></p> 
            <input type="submit" value="Añadir solicitud">
            <input type="reset" value="Borrar solicitud">
        </form>
        <button name="botonListado" onclick="window.location.href='listado.jsp'">Listado de actividades</button>
    </body>
</html>
