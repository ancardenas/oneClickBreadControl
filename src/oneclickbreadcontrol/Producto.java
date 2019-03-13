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
public class Producto implements Serializable{
    private String nombre;
    private String ID;
    private double precio;
    private int catidad;
    private String unidades;
    private String descripcion;
    private Provedor provedor;
    

    public Producto(String nombre, String ID, double precio, int catidad, String unidades) {
        this.nombre = nombre;
        this.ID = ID;
        this.precio = precio;
        this.catidad = catidad;
        this.unidades = unidades;
    }

    public Producto(String nombre, String ID, double precio, int catidad, String unidades, String descripcion) {
        this.nombre = nombre;
        this.ID = ID;
        this.precio = precio;
        this.catidad = catidad;
        this.unidades = unidades;
        this.descripcion = descripcion;
    }

    public Producto(String nombre, String ID, double precio, int catidad, String unidades, Provedor provedor) {
        this.nombre = nombre;
        this.ID = ID;
        this.precio = precio;
        this.catidad = catidad;
        this.unidades = unidades;
        this.provedor = provedor;
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

   

    public int getCatidad() {
        return catidad;
    }

    public void setCatidad(int catidad) {
        this.catidad = catidad;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }
    
    
    
    
    
    
}
