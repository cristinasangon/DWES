<%-- 
    Document   : resultado
    Created on : 7 nov. 2024, 10:34:14
    Author     : crisc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RESULTADO</title>
    </head>
    <body>
        <% 
            double[] billetes = {100, 50, 20, 10, 5};
            double[] monedas = {2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
            
            double importe = Double.parseDouble((String) getServletContext().getAttribute("importe"));
            double entregado = Double.parseDouble((String) getServletContext().getAttribute("entregado"));
            
            int[] billetesUsados = {0, 0, 0, 0, 0};
            int[] monedasUsadas = {0, 0, 0, 0, 0, 0, 0, 0};
            
            double devolver = entregado - importe;
            int x = 0;
            while(devolver > 4 && x < billetes.length){
                if(devolver >= billetes[x]){
                    devolver -= billetes[x];
                    billetesUsados[x]++;
                }else{
                    x++;
                }
            }
            
            x = 0;
            while(devolver >= 0 && x < monedas.length){
                if(devolver >= monedas[x]){
                    devolver -= monedas[x];
                    monedasUsadas[x]++;
                }else{
                    x++;
                }
                devolver = Math.round(devolver * 100.0) / 100.0;
            }
        %>
        <h1>Datos de entrada</h1>
        <p>Importe de venta: <% out.print(importe); %></p>
        <p>Cantidad entregada: <% out.print(entregado); %></p>
        
        <h1>Datos de salida</h1>
        <%
            if(entregado > importe){
                for(int y = 0; y < billetes.length; y++){
                    if(billetesUsados[y] == 1){
                        out.print(billetesUsados[y] + " billete de " + billetes[y] + "€ <br><br>");
                    }else if(billetesUsados[y] > 1){
                        out.print(billetesUsados[y] + " billetes de " + billetes[y] + "€ <br><br>");
                    }
                }

                for(int y = 0; y < monedas.length; y++){
                    if(monedasUsadas[y] == 1){
                        out.print(monedasUsadas[y] + " moneda de " + monedas[y] + "€ <br><br>");
                    }else if(monedasUsadas[y] > 1){
                        out.print(monedasUsadas[y] + " monedas de " + monedas[y] + "€ <br><br>");
                    }
                }
            }else{
                out.print("La cantidad entregada debe ser mayor");
            }
            
        %>
    </body>
</html>
