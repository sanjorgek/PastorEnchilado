/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;

/**
 *
 * @author Professional
 */
public class DetalleOrden extends Control{
    
    int id;
    int idOrden;
    int cantidad;
    double total;
    boolean aDomicilio;
    String fecha;

    @Override
    public String toString() {
        return "DetalleOrden{" + "id=" + id + ", idOrden=" + idOrden + ", cantidad=" + cantidad + ", total=" + total + ", aDomicilio=" + aDomicilio + ", fecha=" + fecha + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isaDomicilio() {
        return aDomicilio;
    }

    public void setaDomicilio(boolean aDomicilio) {
        this.aDomicilio = aDomicilio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public ArrayList getOrdenesByCliente(int idCliente) throws Exception{
        ArrayList detalleOrdenes = new ArrayList();
        try{
            detalleOrdenes = conexionBD.getOrdenesByCliente(idCliente);
        }catch(Exception ex){
            System.out.println("No se pudieron recuperar los detalles de las ordenes para ese cliente " + ex.getMessage());
        }
        return detalleOrdenes;
    }
}
