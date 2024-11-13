<%-- 
    Document   : listado.jsp
    Created on : 27 oct. 2024, 23:44:21
    Author     : crisc
--%>

<%@page import="java.util.Collections"%>
<%@page import="modelo.Reserva"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>RESERVAS</h1>
        <table border="2px">
            <tr>
                <th>Nombre:</th>
                <th>Fecha de entrada:</th>
                <th>Fecha de salida:</th>
                <th>Regimen de alojamiento:</th>
                <th>Servicios contratados:</th>
                <th>Provincia:</th>
            </tr>
            
            <%
                ArrayList<Reserva> reservas = (ArrayList<Reserva>) getServletContext().getAttribute("reservas");
                String filtro = request.getParameter("filtro");
                if(reservas != null){
                    Collections.sort(reservas);
                    if(filtro == null){
                        for(Reserva reserva: reservas){
                            out.print("<tr>");
                            out.print("<td>" + reserva.getNombre() + "</td>");
                            out.print("<td>" + reserva.getEntrada() + "</td>");
                            out.print("<td>" + reserva.getSalida() + "</td>");
                            out.print("<td>" + reserva.getRegimen() + "</td>");
                            String servicios = "";
                            if(reserva.getServicios() != null){
                                for(int x = 0; x < reserva.getServicios().length; x++){
                                    if(x > 0){
                                        servicios += ", ";
                                    }
                                servicios += reserva.getServicios()[x];
                                }
                            }
                            
                            out.print("<td>" + servicios + "</td>");
                            out.print("<td>" + reserva.getProvincia() + "</td>");
                            out.print("</tr>");
                        }
                    }else if(filtro.equals("sinServicios")){
                        for(Reserva reserva: reservas){
                            if(reserva.getServicios() == null){
                            out.print("<tr>");
                            out.print("<td>" + reserva.getNombre() + "</td>");
                            out.print("<td>" + reserva.getEntrada() + "</td>");
                            out.print("<td>" + reserva.getSalida() + "</td>");
                            out.print("<td>" + reserva.getRegimen() + "</td>");
                            String servicios = "";
                            if(reserva.getServicios() != null){
                                for(int x = 0; x < reserva.getServicios().length; x++){
                                    if(x > 0){
                                        servicios += ", ";
                                    }
                                servicios += reserva.getServicios()[x];
                                }
                            }
                            
                            out.print("<td>" + servicios + "</td>");
                            out.print("<td>" + reserva.getProvincia() + "</td>");
                            out.print("</tr>");
                            }
                        }
                    }else{
                        for(Reserva reserva: reservas){
                            if(reserva.getRegimen().equals(filtro)){
                            out.print("<tr>");
                            out.print("<td>" + reserva.getNombre() + "</td>");
                            out.print("<td>" + reserva.getEntrada() + "</td>");
                            out.print("<td>" + reserva.getSalida() + "</td>");
                            out.print("<td>" + reserva.getRegimen() + "</td>");
                            String servicios = "";
                            if(reserva.getServicios() != null){
                                for(int x = 0; x < reserva.getServicios().length; x++){
                                    if(x > 0){
                                        servicios += ", ";
                                    }
                                servicios += reserva.getServicios()[x];
                                }
                            }
                            
                            out.print("<td>" + servicios + "</td>");
                            out.print("<td>" + reserva.getProvincia() + "</td>");
                            out.print("</tr>");
                            }
                        }
                    }
                }else{
                out.print("<tr>");
                out.print("<td> No hay reservas </td>");
                out.print("</tr>");
                }
            %>
        </table>
        
        <br>
        <a href="index.html"> <button> Seguir añadiendo reservas </button> </a>
        <a href="listado.jsp?filtro=completa"> <button> Ver reservas de pension completa </button> </a>
        <a href="listado.jsp?filtro=media"> <button> Ver reservas de media pension </button> </a>
        <a href="listado.jsp?filtro=sinServicios"> <button> Ver reservas sin servicios extras </button> </a>
        <a href="listado.jsp"> <button> Ver todas </button> </a>
    </body>
</html>
