package oneclickbreadcontrol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Andres
 */
public class Panaderia implements Serializable{
 private Inventario inv= new Inventario();
 private String nombre;//Chioma Bakery
 private String direccion;//crr 51#134-90
 private int Telefono;//3043513484
 private ArrayList<Caja> cajasmensuales;
 private ArrayList<Caja> cajasdiarias;
 private ArrayList<Empleado> empleados; 


    public Panaderia(String nombre, String direccion, int Telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.Telefono = Telefono;
        this.empleados =new ArrayList<>();
        this.cajasdiarias = new ArrayList<>();
        this.cajasmensuales =new ArrayList<>();
    }

   

   public ArrayList<Caja> CrearCajaMensual(int dia,int mes,int Anno,int hora){
      Caja asignacion=new Caja(dia, mes, Anno, hora);
       for (Caja aux : cajasdiarias) {
           if(aux.getAnno()==Anno){
               if(aux.getMes()==mes){
                   if(aux.getDia()<=dia){
                       asignacion.getVentas().addAll(asignacion.getVentas().size(),aux.getVentas());
                   }
               }
           }
       }
   if(asignacion.getVentas().size()>0){
       this.cajasmensuales.add(asignacion);}
   return cajasmensuales;
           }


public boolean ingresar(String username,String contrasena){
    
    for (int i = 0; i <this.empleados.size(); i++) {
        if(this.empleados.get(i).getUsusario().equals(username)){
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
