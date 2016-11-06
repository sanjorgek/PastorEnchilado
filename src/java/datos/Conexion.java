/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import control.Persona;
import control.DetalleOrden;
import control.SucursalProducto;
import control.Producto;
import control.Proveedor;
import control.CategoriaProducto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Conexion {
    
    //Creamos nuestros objetos para la comunicacion y ejecucion de codigo SQL
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    
    //Constructor    
    public Conexion() {
        stmt = null;
        con = null;
        rs = null;
    }

    /*
     * Metodo que nos permite abrir la conexion con una base de datos 
     * especificada en el parametro de entrada del metodo que ha sido
     * invocado en la capa de Control
     * @author  Erick Matla
     * @version 1.0
     * @param   nombrebase - nombre de la base de datos a la cual nos 
     *          conectaremos
     */
    public void conectar()
            throws Exception {
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost;" +
                                    "database=pastorenchilado;" +
                                    "user=javaApp;" +
                                    "password=P4$$w0rd"; 
            con = DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("SQLException: " + e.getMessage() + " conectar =(");
        }
    }

    /*
     * Metodo que nos permite cerrar la conexion con una base de datos 
     * el metodo debe ser invocado en la capa de Control
     * @author  Erick Matla
     * @version 1.0
     * @param   sin parametros     
     */
    public void desconectar()
            throws SQLException {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage() + " desconectar =(");
        }
    }
    
    public ArrayList getPersonas() throws Exception {
        ArrayList personas = new ArrayList();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT nIdPersona, sApp, sNombre, dFechaNacimiento FROM persona;");
            while (rs.next()) {
                Persona p = new Persona();
                p.setId(rs.getInt(1));
                p.setApp(rs.getString(2));
                p.setNombre(rs.getString(3));
                p.setFecha_nac(rs.getString(4));
                personas.add(p);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage() + " getPersonas");
        }
        return personas;
    }
    
    public int setEstado(String estado) throws SQLException {
        int b = 0;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO CEstado(sestado) VALUES ('" + estado + "');");
            b = 1;
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage() + " getActivaSede =(");
        }
        return b;
    }
    
    public ArrayList getOrdenesByCliente(int idCliente){
        ArrayList detalleOrdenes = new ArrayList();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT C.nIdCliente, DO.bDomicilio, DO.nCantidad, DO.nIdDetalleOrden, O.dFecha, O.mTotal, O.nIdOrden\n" +
                "FROM (SELECT nIdCliente\n" +
                "	FROM Cliente\n" +
                "	WHERE nIdCliente=" + idCliente +") AS C\n" +
                "JOIN (SELECT nIdDetalleOrden, nCantidad, bDomicilio, nIdOrden, nIdCliente\n" +
                "	FROM DetalleOrden) AS DO\n" +
                "ON C.nIdCliente=DO.nIdCliente\n" +
                "JOIN (SELECT nIdOrden, mTotal, dFecha, nIdEmpleado\n" +
                "	FROM Orden) AS O\n" +
                "ON DO.nIdOrden=O.nIdOrden;");
            while (rs.next()) {
                DetalleOrden p = new DetalleOrden();
                p.setId(rs.getInt(1));
                p.setaDomicilio(rs.getBoolean(2));
                p.setCantidad(rs.getInt(3));
                p.setIdOrden(rs.getInt(4));
                p.setFecha(rs.getString(5));
                detalleOrdenes.add(p);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage() + " getOrdenesByCliente");
        }
        return detalleOrdenes;
    }
    
    public ArrayList<SucursalProducto> getMenu(int idSucursal){
        ArrayList<SucursalProducto> menu = new ArrayList<SucursalProducto>();
        SucursalProducto sp;
        Producto p;
        CategoriaProducto c;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT P.nIdProducto, nIdSucursalProducto, mPrecio, dFechaActualizacion, SP.bActivo, sProducto, nIdCategoria, sCategoria\n" +
                "FROM (SELECT nIdSucursal\n" +
                "	FROM Sucursal\n" +
                "	WHERE nIdSucursal=" + idSucursal + ") AS S\n" +
                "JOIN (Select *\n" +
                "	FROM Sucursal_Producto) AS SP\n" +
                "ON S.nIdSucursal=SP.nIdSucursal\n" +
                "JOIN (SELECT nIdProducto, sProducto, bActivo, CP.nIdCategoria, sCategoria\n" +
                "	FROM Producto\n" +
                "	JOIN CCategoria_Producto AS CP\n" +
                "	ON Producto.nIdCategoria=CP.nIdCategoria) AS P\n" +
                "ON P.nIdProducto=SP.nIdProducto;");
            while (rs.next()) {
                sp = new SucursalProducto();
                p = new Producto();
                c = new CategoriaProducto();
                p.setId(rs.getInt(1));
                sp.setId(rs.getInt(2));
                sp.setPrecio(rs.getInt(3));
                sp.setFechaActualizacion(rs.getString(4));
                p.setActivo(rs.getBoolean(5));
                p.setName(rs.getString(6));
                c.setId(rs.getInt(7));
                c.setNombre(rs.getString(8));
                p.setCategoria(c);
                sp.setProducto(p);
                menu.add(sp);
            }
            rs.close();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage() + " getOrdenesByCliente");
        }
        return menu;        
    }
    
    public ArrayList<Proveedor> getProveedoresPorSucursal(int idSucursal){
        ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
        
        return proveedores;
    }
}
