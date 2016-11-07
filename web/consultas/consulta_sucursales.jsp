<%-- 
    Document   : consulta_personas
    Created on : 29-oct-2016, 0:52:34
    Author     : erick
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="control.Sucursal"%>
<%@page import="control.Telefono"%>
<%@page import="control.Direccion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <a href="../index.html">Inicio</a>        
        <h1>Consulta Sucursales</h1>
        <%
            Sucursal s = new Sucursal();
            ArrayList<Sucursal> sucursales;

            s.conecta();
            sucursales = s.getSucursales();
            s.desconecta();

            if (sucursales.size() > 0) {
                for (int i = 0; i < sucursales.size(); i++) {
                    s = sucursales.get(i);
                    int id = s.getId();
                    String nombre = s.getNombre();
                    String sActiva = "InActiva";
                    if(s.isActivo()) sActiva = "Activa";
                    String entregas = "Sin entregas";
                    if(s.isServicioADomicilio()) entregas = "Con entregas";
                    String tipo = s.getTipoSucursal();
                    String telefono = s.getTelefono().getTelefono();
                    String calle = s.getDireccion().getCalle();
                    String colonia = s.getDireccion().getColonia();
                    String cp = s.getDireccion().getCp();
                    String obs = s.getDireccion().getObservaciones();
                    String municipio = s.getDireccion().getMunicipio();
                    String estado = s.getDireccion().getEstado();
                    out.write(i + 1 + " | " + id + " " + nombre+ " | " +sActiva+ " | " +entregas+ " | " +tipo+ " | " +telefono+ " | " +calle+ " | " +colonia+ " | " +cp+ " | " +obs+ " | " +municipio+ " | " +estado + "<br>");
                }
            } else {
                out.write("No hay sucrsales registradas");
            }
        %>
    </body>
</html>
