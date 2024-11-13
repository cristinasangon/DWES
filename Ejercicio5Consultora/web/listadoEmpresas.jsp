<%-- 
    Document   : listadoEmpresass
    Created on : 22 oct. 2024, 9:44:15
    Author     : crisc
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Empresa"%>
<%@page import="modelo.Empresas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de empresas</title>
    </head>
    <body>
        <h1>Empresas</h1>
        <% 
            ArrayList<Empresa> empresas = (ArrayList<Empresa>) application.getAttribute("lista");
            String filtro = request.getParameter("filtro");
        %>
        <table border="2px">
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
            if(empresas != null){
                for(Empresa emp: empresas){
                    boolean mostrar = true;
                    if(filtro != null){
                        mostrar = false;
                        if(emp.getSector().equals(filtro)){
                            mostrar = true;
                        }
                    }
                    if(mostrar){
                        out.println("<tr>");
                        out.println("<td> " + emp.getNombre() + "</td>");
                        out.println("<td> " + emp.getCif() + "</td>");
                        out.println("<td> " + emp.getRepresentante() + "</td>");
                        out.println("<td> " + emp.getNif() + "</td>");
                        out.println("<td> " + emp.getSector() + "</td>");
                        out.println("<td> " + emp.getTelefono() + "</td>");
                        out.println("<td> " + emp.getEmail() + "</td>");
                        out.println("<td> " + emp.getVolVentas() + "</td>");
                        out.println("</tr>");
                    }  
                }
            }else{
                out.println("<tr>");
                    out.println("<td> No se han encontrado registros </td>");
                out.println("</tr>");
            }
        %>
        </table>
        <br>
        <p> 
            <a href="listadoEmpresas.jsp?filtro=alimenticia"> <button> Ver empresas alimenticias </button> </a>
            <a href="listadoEmpresas.jsp?filtro=textil"> <button> Ver empresas textil </button> </a>
            <a href="listadoEmpresas.jsp?filtro=transporte"> <button> Ver empresas de transporte </button> </a>
            <a href="listadoEmpresas.jsp?filtro=medicina"> <button> Ver empresas de salud </button> </a>
            <a href="listadoEmpresas.jsp"> <button> Ver todas </button> </a>
        </p>

    </body>
</html>
