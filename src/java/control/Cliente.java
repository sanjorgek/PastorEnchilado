/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.UUID;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 *
 * @author Professional
 */
public class Cliente extends Control{
    int id;
    String monedero;
    Double saldo;
    String fechaRegistro;
    boolean activo;
    Persona persona;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonedero() {
        return monedero;
    }

    public void setMonedero(String monedero) {
        this.monedero = monedero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public Cliente guardaCliente(int idPersona){
        try{
            String uuid = UUID.randomUUID().toString();
            TimeZone tz = TimeZone.getTimeZone("UTC");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setTimeZone(tz);
            String creacion = df.format(new Date());
            if(conexionBD.guardaCliente(uuid, 0.0, creacion, idPersona)==1){
                return conexionBD.getCliente(uuid);
            }else{
                throw new Exception("No se pudo crear el cliente");
            }
        }catch(Exception ex){
            System.out.println("No se pudo crear el cliente " + ex.getMessage());
        }
        return null;
    }
}
