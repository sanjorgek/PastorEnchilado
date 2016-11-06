<%-- 
    Document   : consulta_personas
    Created on : 29-oct-2016, 0:52:34
    Author     : erick
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="control.SucursalProducto"%>
<%@page import="control.SucursalProducto"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <a href="../index.html">Inicio</a>        
        <h1>Consulta Menu por sucursal</h1>
        <%
            int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
            SucursalProducto sp = new SucursalProducto();
            ArrayList<SucursalProducto> sucProductos;

            sp.conecta();
            sucProductos = sp.getMenu(idSucursal);
            sp.desconecta();

            if (sucProductos.size() > 0) {
                for (int i = 0; i < sucProductos.size(); i++) {
                    int id = sucProductos.get(i).getProducto().getId();
                    int idSP = sucProductos.get(i).getId();
                    double precio = sucProductos.get(i).getPrecio();
                    String fecha = sucProductos.get(i).getFechaActualizacion();
                    boolean activo = sucProductos.get(i).isActivo();
                    String nombre = sucProductos.get(i).getProducto().getName();
                    String nombreCat = sucProductos.get(i).getProducto().getCategoria().getNombre();
                    out.write(i + 1 + " | " + id + "-" + idSP + " " + nombre + " " + precio + " " + activo + " " + fecha + " " + nombreCat + "<br>");
                }
            } else {
                out.write("No hay ordenes registradas para ese cliente");
            }
        %>
    </body>
</html>
