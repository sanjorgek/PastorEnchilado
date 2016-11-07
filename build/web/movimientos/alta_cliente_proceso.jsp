<%-- 
    Document   : alta_estado_proceso
    Created on : 29-oct-2016, 1:30:29
    Author     : erick
--%>

<%@page import="control.Cliente"%>
<%@page import="control.Persona"%>
<%@page import="control.Telefono"%>
<%
    Persona p = new Persona();
    Cliente c = new Cliente();
    Telefono t = new Telefono();
    String nombre = request.getParameter("nombre");
    String app = request.getParameter("app");
    String apm = request.getParameter("apm");
    String correo = request.getParameter("correo");
    String nacimiento = request.getParameter("ano")+"-"+request.getParameter("mes")+"-"+request.getParameter("dia");
    String sTelefono = request.getParameter("tlefono");
    int tipo = Integer.parseInt(request.getParameter("tipo"));
    p.conecta();
    Persona pCliente = p.guardaPersona(app, apm, nombre, nacimiento, correo);
    p.desconecta();
    c.conecta();
    Cliente clienteP = c.guardaCliente(pCliente.getId());
    c.desconecta();
    t.conecta();
    Telefono telefono = t.guardaTelefono(sTelefono, tipo, pCliente.getId());
    t.desconecta();
    if(pCliente != null && clienteP != null && telefono != null && pCliente.asignaTelefono(telefono, tipo)){
        out.write("Cliente Registrado");
    }else{
        out.write("No se Registró el Cliente");
    }
%>