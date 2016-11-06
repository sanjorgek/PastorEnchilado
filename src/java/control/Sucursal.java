/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Objects;

/**
 *
 * @author Professional
 */
public class Sucursal extends Control{
    int id;
    String nombre;
    boolean servicioADomicilio;
    boolean activo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isServicioADomicilio() {
        return servicioADomicilio;
    }

    public void setServicioADomicilio(boolean servicioADomicilio) {
        this.servicioADomicilio = servicioADomicilio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "id=" + id + ", nombre=" + nombre + ", servicioADomicilio=" + servicioADomicilio + ", activo=" + activo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + (this.servicioADomicilio ? 1 : 0);
        hash = 37 * hash + (this.activo ? 1 : 0);
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
        final Sucursal other = (Sucursal) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.servicioADomicilio != other.servicioADomicilio) {
            return false;
        }
        if (this.activo != other.activo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    
}
