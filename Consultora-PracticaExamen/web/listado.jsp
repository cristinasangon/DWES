<%-- 
    Document   : listado
    Created on : 27 oct. 2024, 22:00:07
    Author     : crisc
--%>

<%@page import="java.util.Collections"%>
<%@page import="modelo.Empresa"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LISTA DE EMPRESAS</h1>
        <table border="2px" >
            <tr>
                <th>Empresa</th>
                <th>CIF</th>
                <th>Representante</th>
                <th>NIF</th>
                <th>Sector</th>
                <th>Telefono</th>
                <th>E-mail</th>
                <th>Volumen de ventas anuales</th>
            </tr>
            <%
                ArrayList<Empresa> empresas = (ArrayList<Empresa>) getServletContext().getAttribute("empresas");
                String filtro = request.getParameter("filtro");
                if(empresas != null){
                    Collections.sort(empresas);
                    if(filtro == null){
                        for(Empresa empresa: empresas){
                            out.print("<tr>");
                            out.print("<td>" + empresa.getNombre() + "</td>");
                            out.print("<td>" + empresa.getCif() + "</td>");
                            out.print("<td>" + empresa.getRepresentante() + "</td>");
                            out.print("<td>" + empresa.getNif() + "</td>");
                            out.print("<td>" + empresa.getSector() + "</td>");
                            out.print("<td>" + empresa.getTelefono() + "</td>");
                            out.print("<td>" + empresa.getEmail() + "</td>");
                            out.print("<td>" + empresa.getVolumen() + "</td>");
                            out.print("</tr>");
                        }
                    }else{
                    for(Empresa empresa: empresas){
                    if(filtro.equals(empresa.getSector())){
                        out.print("<tr>");
                            out.print("<td>" + empresa.getNombre() + "</td>");
                            out.print("<td>" + empresa.getCif() + "</td>");
                            out.print("<td>" + empresa.getRepresentante() + "</td>");
                            out.print("<td>" + empresa.getNif() + "</td>");
                            out.print("<td>" + empresa.getSector() + "</td>");
                            out.print("<td>" + empresa.getTelefono() + "</td>");
                            out.print("<td>" + empresa.getEmail() + "</td>");
                            out.print("<td>" + empresa.getVolumen() + "</td>");
                            out.print("</tr>");
                    }
                            
                        }
                    }
                }else{
                    out.print("<tr>");
                    out.print("<td> No hay empresas </td>");
                    out.print("</tr>");
                }
            %>
            
        </table>
        
        <a href="formEmpresa.html"> <button> Seguir añadiendo empresas</button> </a>
        <a href="listado.jsp?filtro=alimentacion"> <button> Ver empresas alimenticias</button> </a>
        <a href="listado.jsp?filtro=textil"> <button> Ver empresas textiles</button> </a>
        <a href="listado.jsp?filtro=transporte"> <button> Ver empresas de transporte</button> </a>
        <a href="listado.jsp?filtro=medicina"> <button> Ver empresas de salud</button> </a>
        <a href="listado.jsp"> <button> Ver todas</button> </a>
    </body>
</html>
