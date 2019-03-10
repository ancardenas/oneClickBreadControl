/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oneclickbreadcontrol;

import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class Panaderia {
 private Inventario inv= new Inventario();
 private String nombre;
 private String direccion;
 private int Telefono;
 private ArrayList<Caja> cajasmensuales=new ArrayList();
 private ArrayList<Caja> cajasdiarias=new ArrayList();
private ArrayList<Empleado> empleados=new ArrayList(); 

    public Panaderia(String nombre, String direccion, int Telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.Telefono = Telefono;
    }

   

public boolean ingresar(String username,String contrasena){
    
    for (int i = 0; i <this.empleados.size(); i++) {
        if(this.empleados.get(i).getUsusario().equals(username)&&
                this.empleados.get(i).getContrasena().equals(contrasena)){
             return true;
        }
    }
    return false;
}








public Inventario getInv() {
        return inv;
    }

    public void setInv(Inventario inv) {
        this.inv = inv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Caja> getCajasmensuales() {
        return cajasmensuales;
    }

    public void setCajasmensuales(ArrayList<Caja> cajasmensuales) {
        this.cajasmensuales = cajasmensuales;
    }

    public ArrayList<Caja> getCajasdiarias() {
        return cajasdiarias;
    }

    public void setCajasdiarias(ArrayList<Caja> cajasdiarias) {
        this.cajasdiarias = cajasdiarias;
    }

    
    
    
 
















}
