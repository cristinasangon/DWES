<%-- 
    Document   : formActividad
    Created on : 27 oct. 2024, 17:41:48
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
        <h1>AÑADIR ACTIVIDAD</h1>
        <form action="/ActividadExtraescolar-PracticaExamen/ServletValidaActividad" method="post"> 
            <p> Nombre de la actividad: <input type="text" name="nombre" required> </p>
            <p> Lugar de celebracion: <input type="text" name="lugar" required> </p>
            <p> Fecha: <input type="text" name="fecha" placeholder="DD/MM/AAAA" required> </p>
            <p> Hora: <input type="text" name="hora" placeholder="HH:MM" required> </p>
            <p> Destinada a: 
                <input type="radio" name="destinada" value="alumnado" required> Alumnado
                <input type="radio" name="destinada" value="profesorado"> Profesorado
            </p>
            
            <p> Tipo de actividad: </p>
                <input type="checkbox" name="tipo" value="academica"> Academica <br>
                <input type="checkbox" name="tipo" value="deportiva"> Deportiva <br>
                <input type="checkbox" name="tipo" value="cultural"> Cultural <br>
                <input type="checkbox" name="tipo" value="convivencia"> Convivencia <br>
                
            <p> Curso: 
                
                    <%
                        String usuario = (String) getServletContext().getAttribute("usuario");
                        if(usuario.equals("eso")){
                        %>      
                            <select name="curso" required>
                                <option value="" disabled selected> Elige una opcion </option>
                                <option value="1"> 1º </option>
                                <option value="2"> 2º </option>
                                <option value="3"> 3º </option>
                                <option value="4"> 4º </option>
                            </select>
                        <%
                        }else{
                        %>      
                            <select name="curso" required>
                                <option value="" disabled selected> Elige una opcion </option>
                                <option value="1"> 1º </option>
                                <option value="2"> 2º </option>
                            </select>
                        <%
                        }
                    %>
                    
            <p> Profesor responsable: <input type="text" name="responsable" required> </p>        
            <p> Observaciones: <textarea name="observaciones"> </textarea> </p>
               
            <button type="submit"> Añadir actividad </button>
            <button type="reset"> Borrar actividad </button>
        </form>
            <br> <a href="listado.jsp"> <button> Listado de actividades </button> </a>
    </body>
</html>
