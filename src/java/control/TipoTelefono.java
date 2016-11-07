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
public class TipoTelefono extends Control {
    int id;
    String tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public ArrayList<TipoTelefono> getTipos(){
        ArrayList<TipoTelefono> tts = new ArrayList<TipoTelefono>();
        try{
            tts = conexionBD.getTipos();
        }catch(Exception ex){
            System.out.println("No se pudieron recuperar los tipos de telefonos " + ex.getMessage());
        }
        return tts;
    }
    
}
