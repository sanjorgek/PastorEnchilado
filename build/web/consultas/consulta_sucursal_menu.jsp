<%-- 
    Document   : consulta_detalle_orden_cliente
    Created on : 05-nov-2016, 22:32:33
    Author     : Professional
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="../index.html">Inicio</a>        
        <h1>Consulta el Menu por Sucursal</h1>
        <form action="consulta_sucursal_menu_proceso.jsp" method="post">
            Identificador de la Sucursal  <input type="text" required="true" name="idSucursal">
            <input type="submit" value="Buscar">
        </form>
    </body>
</html>
