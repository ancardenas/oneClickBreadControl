/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oneclickbreadcontrol;

import java.io.Serializable;

/**
 *
 * @author Andres
 */
public class Persona implements Serializable{
    
    protected String nombre;
    protected String ID;
    protected String ususario;
    protected String contrasena;

    public Persona(String nombre, String ID, String ususario, String contrasena) {
        this.nombre = nombre;
        this.ID = ID;
        this.ususario = ususario;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsusario() {
        return ususario;
    }

    public void setUsusario(String ususario) {
        this.ususario = ususario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
            
    
    
}
