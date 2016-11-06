<%-- 
    Document   : consulta_personas
    Created on : 29-oct-2016, 0:52:34
    Author     : erick
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="control.DetalleOrden"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <a href="../index.html">Inicio</a>        
        <h1>Consulta Ordenes Por Cliente</h1>
        <%
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            DetalleOrden od = new DetalleOrden();
            ArrayList detalleOrdenes = new ArrayList();

            od.conecta();
            detalleOrdenes = od.getOrdenesByCliente(idCliente);
            od.desconecta();

            if (detalleOrdenes.size() > 0) {
                for (int i = 0; i < detalleOrdenes.size(); i++) {
                    int id = ((DetalleOrden) detalleOrdenes.get(i)).getId();                    
                    int idOrden = ((DetalleOrden) detalleOrdenes.get(i)).getIdOrden();
                    int cantidad = ((DetalleOrden) detalleOrdenes.get(i)).getCantidad();
                    String aDomicilio = "No";
                    if(((DetalleOrden) detalleOrdenes.get(i)).isaDomicilio()) aDomicilio = "Si";
                    String fecha = ((DetalleOrden) detalleOrdenes.get(i)).getFecha();
                    out.write(i + 1 + " | " + id + " " + idOrden + " " + cantidad + " " + aDomicilio +" " + fecha + "<br>");
                }
            } else {
                out.write("No hay ordenes registradas para ese cliente");
            }
        %>
    </body>
</html>
