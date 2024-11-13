<%-- 
    Document   : listado.jsp
    Created on : 27 oct. 2024, 13:56:55
    Author     : crisc
--%>

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
        <h1>RESERVAS HOTEL</h1>
        <table border="2px">
            <tr>
                <th>Nombre</th>
                <th>Fecha de Entrada</th>
                <th>Fecha de Salida</th>
                <th>Regimen de alojamiento</th>
                <th>Servicios contratados</th>
                <th>Provincia</th>
            </tr>
            <%
                ArrayList<Reserva> reservas = (ArrayList<Reserva>) getServletContext().getAttribute("reservas");
                if(reservas == null){
            %>
            <tr>
                <td>No hay reservas</td>
            </tr>
            <%
                }else{
                    String filtro = request.getParameter("filtro");
                    if(filtro == null){
                        for(Reserva res: reservas){
                            out.print("<tr>");
                            out.print("<td>" + res.getNombre() + "</td>");
                            out.print("<td>" + res.getEntrada() + "</td>");
                            out.print("<td>" + res.getSalida()+ "</td>");
                            out.print("<td>" + res.getRegimen() + "</td>");
                            String servicios = "";
                            if(res.getServicios() == null){
                                out.print("<td> sin servicios</td>");
                            }else{
                                for(int x = 0; x < res.getServicios().length; x++){
                                    if(x >0){
                                        servicios += ", ";
                                    }
                                    servicios += res.getServicios()[x];
                                }
                            }

                            if(!servicios.equals("")){
                                out.print("<td>" + servicios + "</td>");
                            }

                            out.print("<td>" + res.getProvincia() + "</td>");
                            out.print("</tr>");
                        }
                    }else if(filtro.equals("completa") || filtro.equals("media")){
                        for(Reserva res: reservas){
                            if(res.getRegimen().equals(filtro)){
                            out.print("<tr>");
                            out.print("<td>" + res.getNombre() + "</td>");
                            out.print("<td>" + res.getEntrada() + "</td>");
                            out.print("<td>" + res.getSalida()+ "</td>");
                            out.print("<td>" + res.getRegimen() + "</td>");
                            String servicios = "";
                            if(res.getServicios() == null){
                                out.print("<td> sin servicios</td>");
                            }else{
                                for(int x = 0; x < res.getServicios().length; x++){
                                    if(x >0){
                                        servicios += ", ";
                                    }
                                    servicios += res.getServicios()[x];
                                }
                            }

                            if(!servicios.equals("")){
                                out.print("<td>" + servicios + "</td>");
                            }

                            out.print("<td>" + res.getProvincia() + "</td>");
                            out.print("</tr>");
                            }
                        }
                    }else if(filtro.equals("sinServicios")){
                            for(Reserva res: reservas){
                            if(res.getServicios() == null){
                            out.print("<tr>");
                            out.print("<td>" + res.getNombre() + "</td>");
                            out.print("<td>" + res.getEntrada() + "</td>");
                            out.print("<td>" + res.getSalida()+ "</td>");
                            out.print("<td>" + res.getRegimen() + "</td>");
                            String servicios = "";
                            if(res.getServicios() == null){
                                out.print("<td> sin servicios</td>");
                            }else{
                                for(int x = 0; x < res.getServicios().length; x++){
                                    if(x >0){
                                        servicios += ", ";
                                    }
                                    servicios += res.getServicios()[x];
                                }
                            }

                            if(!servicios.equals("")){
                                out.print("<td>" + servicios + "</td>");
                            }

                            out.print("<td>" + res.getProvincia() + "</td>");
                            out.print("</tr>");
                            }
                        }
                    }
                    
                }
            %>
        </table>
        <a href="index.html"> <button> Seguir añadiendo reservas </button> </a>
        <a href="listado.jsp?filtro=completa"> <button> Ver reservas de pension completa </button> </a>
        <a href="listado.jsp?filtro=media"> <button> Ver reservas de media pension </button> </a>
        <a href="listado.jsp?filtro=sinServicios"> <button> Ver reservas sin servicios extra </button> </a>
        <a href="listado.jsp"> <button> Ver todas </button> </a>
    </body>
</html>
