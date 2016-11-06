/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.Producto;
import control.Sucursal;
import java.util.Objects;
import java.util.ArrayList;

/**
 *
 * @author Professional
 */
public class SucursalProducto extends Control {
    int id;
    double precio;
    String fechaActualizacion;
    boolean activo;
    Sucursal sucursal;
    Producto producto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.fechaActualizacion);
        hash = 97 * hash + (this.activo ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.sucursal);
        hash = 97 * hash + Objects.hashCode(this.producto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SucursalProducto other = (SucursalProducto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (this.activo != other.activo) {
            return false;
        }
        if (!Objects.equals(this.fechaActualizacion, other.fechaActualizacion)) {
            return false;
        }
        if (!Objects.equals(this.sucursal, other.sucursal)) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SucursalProducto{" + "id=" + id + ", precio=" + precio + ", fechaActualizacion=" + fechaActualizacion + ", activo=" + activo + ", sucursal=" + sucursal + ", producto=" + producto + '}';
    }

    public ArrayList<SucursalProducto> getMenu(int idSucursal){
        ArrayList<SucursalProducto> menu = new ArrayList<SucursalProducto>();
        try{
            menu = conexionBD.getMenu(idSucursal);
        }catch(Exception ex){
            System.out.println("No se pudieron recuperar las personas " + ex.getMessage());
        }
        return menu;
    }

    
    
}
