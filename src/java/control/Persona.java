/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;

/**
 *
 * @author erick
 */
public class Persona extends Control{

    int id;
    String app;
    String apm;
    String nombre;
    String fecha_nac;
    String correo;
    
    public Persona guardaPersona(String app, String apm, String nombre, String fecha_nac, String correo){
        try{
            if(conexionBD.guardaPersona(app, apm, nombre, fecha_nac, correo)==1){
                return conexionBD.getPersona(correo);
            }else{
                throw new Exception("No se pudo crear el usuario");
            }
        }catch(Exception ex){
            System.out.println("No se pudo crear la personas " + ex.getMessage());
        }
        return null;
    }

    public String getCorreo() {
        return correo;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }    

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
          
    public ArrayList getPersonas() throws Exception{
        ArrayList personas = new ArrayList();
        try{
            personas = conexionBD.getPersonas();
        }catch(Exception ex){
            System.out.println("No se pudieron recuperar las personas " + ex.getMessage());
        }
        return personas;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", app=" + app + ", nombre=" + nombre + ", fecha_nac=" + fecha_nac + ", correo=" + correo + '}';
    }
    
    public boolean asignaTelefono(Telefono telefono, int tipo){
        try{
            return conexionBD.asignaTelefono(this.getId(), telefono.getId(), tipo);
        }catch(Exception ex){
            System.out.println("No se pudo asignar el telefono" + ex.getMessage());
        }
        return false;
    }
}
