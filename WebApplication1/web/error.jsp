<%-- 
    Document   : error
    Created on : 27 oct. 2024, 12:43:49
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
        <h1>ERROR!</h1>
        <%
            String errores = (String) getServletContext().getAttribute("errores");
        %>
        <p>
            Los siguientes datos son erroneos:
            <% out.print(errores);                 %>
        </p>
        <a href="index.html"> <button> Volver a rellenar datos </button> </a>
    </body>
</html>
