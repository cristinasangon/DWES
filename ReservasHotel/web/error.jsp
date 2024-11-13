<%-- 
    Document   : error
    Created on : 28 oct. 2024, 0:31:51
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
        <h1>ERROR</h1>
        <p>Los siguientes datos son erroneos: <% String errores = (String) getServletContext().getAttribute("errores"); out.print(errores); %></p>
    </body>
</html>
