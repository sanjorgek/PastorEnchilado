<%-- 
    Document   : alta_estado
    Created on : 29-oct-2016, 1:26:53
    Author     : erick
--%>
<%@page import="control.TipoTelefono"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alta Cliente</h1>
        <form action="alta_cliente_proceso.jsp" method="post">
            Nombre/s de Cliente a registrar  <input type="text" required="true" name="nombre">
            <br>
            Apellido Paterno de Cliente a registrar  <input type="text" required="true" name="app">
            <br>
            Apellido Materno de Cliente a registrar  <input type="text" required="true" name="apm">
            <br>
            Año de nacimiento de Cliente a registrar  <select name="ano">
                <% for(int i = 1910; i<2004 ; i++){ 
                    out.print("<option value=\""+ i +"\">"+i+"</option>");
                } %>
            </select>
            <br>
            Mes de nacimiento de Cliente a registrar  <select name="mes">
                <option value="1">Enero</option>
                <option value="2">Febrero</option>
                <option value="3">Marzo</option>
                <option value="4">Abril</option>
                <option value="5">Mayo</option>
                <option value="6">Junio</option>
                <option value="7">Julio</option>
                <option value="8">Agosto</option>
                <option value="9">Septiembre</option>
                <option value="10">Octubre</option>
                <option value="11">Noviembre</option>
                <option value="12">Diciembre</option>
            </select>
            <br>
            Dia de nacimiento de Cliente a registrar  <select name="dia">
                <% for(int j = 1; j<31 ; j++){ 
                    out.print("<option value=\""+ j +"\">"+j+"</option>");
                } %>
            </select>
            <br>
            Correo del Cliente a registrar <input type="text" required="true" name="correo">
            <br>
            Tipo de telefono de Cliente a registrar  <select name="tipo">
                <%
                    TipoTelefono tt = new TipoTelefono();
                    tt.conecta();
                    ArrayList<TipoTelefono> tts = tt.getTipos();
                    tt.desconecta();
                    for(int i = 0; i<tts.size(); i++){
                        tt = tts.get(i);
                        out.print("<option value=\""+ tt.getId() +"\">"+tt.getTipos()+"</option>");
                    }
                %>
            </select>
            <br>
            Telefono de Cliente a registrar  <input type="text" required="true" name="telefono">
            <br>
            <input type="submit" value="Registrar">
        </form>
    </body>
</html>
