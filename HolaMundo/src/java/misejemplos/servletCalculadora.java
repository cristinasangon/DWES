/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package misejemplos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author crisc
 */
public class servletCalculadora extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String oper1 = request.getParameter("oper1");
       String oper2 = request.getParameter("oper2");
       String tipoOper = request.getParameter("tipoOper");
       
       boolean esValido = true;
       double num1 = 0, num2 = 2;
       String msgError = "";
        try {
            num1 = Double.parseDouble(oper1);
            num2 = Double.parseDouble(oper2);
        } catch (Exception e) {
            esValido = false;
            msgError = "Has introducido uno o varios caracteres no numericos, ";
        }
       
        double resultado = 0;
        String tipo = "";
        if(tipoOper.equals("suma")){
            resultado = num1 + num2;
            tipo = "+";
        }else if(tipoOper.equals("resta")){
            resultado = num1 - num2;
            tipo = "-";
        }else if(tipoOper.equals("multiplicacion")){
            resultado = num1 * num2;
            tipo = "*";
        }else if(tipoOper.equals("division")){
            if(num2 == 0){
                msgError = "Se produce una indeterminacion";
                esValido = false;
            }else{
               resultado = num1 / num2;
               tipo = "/";
            }
        }else{
            msgError += "El tipo de operacion solo puede ser: suma, resta, multiplicacion o sivision, ";
            esValido = false;
        }
        
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       
       if(esValido){
            out.print("<html>");
            out.print("<head><title>RESULTADO</title></head>");
            out.print("<body>");
            out.print("<h1>RESULTADO</h1>");
            out.print("<h3>" + oper1 + " " + tipo + " " + oper2 + " = " + resultado + "</h3>");
            out.print("<a href='/HolaMundo/formCalculadora.html'> Hacer otra operacion </a>");
            out.print("</body>");
            out.print("</html>");
       }else{
            out.print("<html>");
            out.print("<head><title>RESULTADO</title></head>");
            out.print("<body>");
            out.print("<h1>RESULTADO</h1>");
            out.print("<h3> " + msgError + " </h3>");
            out.print("<a href='/HolaMundo/formCalculadora.html'> Volver al formulario </a>");
            out.print("</body>");
            out.print("</html>");    
       }
       
    }
}
