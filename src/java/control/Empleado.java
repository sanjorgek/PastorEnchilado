/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Objects;
import java.util.ArrayList;


/**
 *
 * @author Professional
 */
public class Empleado extends Control {
    int id;
    String fechaContratacion;
    String rfc;
    boolean activo;
    Sucursal sucursal;
    String tipoEmpleado;
    Persona persona;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
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

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.fechaContratacion);
        hash = 71 * hash + Objects.hashCode(this.rfc);
        hash = 71 * hash + (this.activo ? 1 : 0);
        hash = 71 * hash + Objects.hashCode(this.sucursal);
        hash = 71 * hash + Objects.hashCode(this.tipoEmpleado);
        hash = 71 * hash + Objects.hashCode(this.persona);
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
        final Empleado other = (Empleado) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.activo != other.activo) {
            return false;
        }
        if (!Objects.equals(this.fechaContratacion, other.fechaContratacion)) {
            return false;
        }
        if (!Objects.equals(this.rfc, other.rfc)) {
            return false;
        }
        if (!Objects.equals(this.tipoEmpleado, other.tipoEmpleado)) {
            return false;
        }
        if (!Objects.equals(this.sucursal, other.sucursal)) {
            return false;
        }
        if (!Objects.equals(this.persona, other.persona)) {
            return false;
        }
        return true;
    }
    
    public ArrayList<Empleado> getEmpleados(){
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        try{
            empleados = conexionBD.getEmpleados();
        }catch(Exception ex){
            System.out.println("No se pudo obtener los empleados" + ex.getMessage());
        }
        return empleados;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", fechaContratacion=" + fechaContratacion + ", rfc=" + rfc + ", activo=" + activo + ", sucursal=" + sucursal + ", tipoEmpleado=" + tipoEmpleado + ", persona=" + persona + '}';
    }
    
}
