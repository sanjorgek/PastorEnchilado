<%-- 
    Document   : consulta_personas
    Created on : 29-oct-2016, 0:52:34
    Author     : sanjorgek
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="control.Empleado"%>
<%@page import="control.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <a href="../index.html">Inicio</a>        
        <h1>Consulta Empleados</h1>
        <%
            Empleado e = new Empleado();
            Persona p = new Persona();
            ArrayList<Empleado> empleados;

            e.conecta();
            empleados = e.getEmpleados();
            e.desconecta();

            if (empleados.size() > 0) {
                for (int i = 0; i < empleados.size(); i++) {
                    e = empleados.get(i);
                    p = e.getPersona();
                    int idE = e.getId();
                    int idP = e.getPersona().getId();
                    String nombre = p.getNombre();
                    String fechaNacimiento = p.getFecha_nac();
                    String correo = p.getCorreo();
                    String fechaContratacion = e.getFechaContratacion();
                    String rfc = e.getRfc();
                    String activo = "No";
                    if(e.isActivo()) activo = "Si";
                    String tipo = e.getTipoEmpleado();
                    String sucursal = e.getSucursal().getNombre();
                    out.write(i + 1 + " | " + idE + " " + idP + " " + nombre + " " + fechaNacimiento + " " + correo + " " + fechaContratacion + " " + rfc + " " + activo + " " + tipo + " " + sucursal +  "<br>");
                }
            } else {
                out.write("No hay personas registradas");
            }
        %>
    </body>
</html>
