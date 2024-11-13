<%-- 
    Document   : errorEmpresa
    Created on : 27 oct. 2024, 21:33:03
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
        <%  
            String error = (String) getServletContext().getAttribute("error");
        %>
        <h1>ERROR</h1>
        <p>el <% out.print(error); %> es incorrecto, por favor intentelo de nuevo </p>
    </body>
</html>
