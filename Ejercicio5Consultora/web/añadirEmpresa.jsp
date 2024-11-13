<%-- 
    Document   : añadirEmpresa
    Created on : 17 oct. 2024, 11:09:44
    Author     : crisc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Añadir empresa</title>
        <style>
        .radio-option {
            display: inline-block;
            margin-right: 15px; /* Espacio entre cada opción */
        }
    </style>
    </head>
    <body>
        <form method="post" action="/Ejercicio5Consultora/ServletValidarEmpresa">
            <p>Nombre de la empresa <input type="text" name="nombreEmpresa" required> CIF <input type="text" name="cif" required></p>
            <p>Representante legal de la empresa <input type="text" name="representanteEmpresa" required> NIF <input type="text" name="nif" required></p>
            <p class="radio-option">
                Sector:
                <span class="radio-option">
                    <input type="radio" id="alimentacion" name="sector" value="alimentacion" required>
                    <label for="alimentacion">Alimentación</label>
                </span>
                <span class="radio-option">
                    <input type="radio" id="textil" name="sector" value="textil" required>
                    <label for="textil">Textil</label>
                </span>
                <span class="radio-option">
                    <input type="radio" id="transporte" name="sector" value="transporte" required>
                    <label for="transporte">Transporte</label>
                </span>
                <span class="radio-option">
                    <input type="radio" id="medicina" name="sector" value="medicina" required>
                    <label for="medicina">Medicina</label>
                </span>
            </p>
            <p>Telefono: <input type="text" name="telefono" required> Email: <input type="text" name="email" required></p>
            <p>Volumen de ventas anuales: <input type="text" name="volumen" required></p>
            <p>Observaciones:</p>
            <textarea name="observaciones"></textarea><br><br>
            <input type="submit" value="Añadir empresa">
            <input type="reset" value="Borrar empresa">
            <button name="listado" onclick="window.location.href='listadoEmpresas.jsp'">Listado de empresas</button>
        </form> 
        
    </body>
</html>
