/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oneclickbreadcontrol;

import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static oneclickbreadcontrol.OneClickbreadControl.gestion;
/**
 *
 * @author Andres
 */
public class Jefe extends Persona implements Serializable{
   
   private Panaderia ChiomaBakery;
   private String codigoseguriadad; 
   
  
   

    public Jefe(Panaderia ChiomaBakery, String codigoseguriadad, String nombre, String ID, String ususario, String contrasena) {
        super(nombre, ID, ususario, contrasena);
        this.ChiomaBakery = ChiomaBakery;
        this.codigoseguriadad = codigoseguriadad;
        
    }
  
     
   
    public Panaderia getChiomaBakery() {
        return ChiomaBakery;
    }

    public void setChiomaBakery(Panaderia ChiomaBakery) {
        this.ChiomaBakery = ChiomaBakery;
    }

    public String getCodigoseguriadad() {
        return codigoseguriadad;
    }

    public void setCodigoseguriadad(String codigoseguriadad) {
        this.codigoseguriadad = codigoseguriadad;
    }

    
   
   
   
   
    
    public void contratar(String nombre,String cedula,String username,String contrasena,boolean codigoseguridad){
     
        try{// se hace la excepcion por si alguno de los de las operaciones da un error
             if (codigoseguridad) {  //se le añadira un codigo de segurar para que cualquier empleado no crree una cuenta
             Empleado empleado=new Empleado(0,nombre,cedula,username,contrasena);// crea un empleado y los mete en la lista que esta en la panaderia
             this.ChiomaBakery.getEmpleados().add(empleado);
             gestion.guardartodo(this);//guarda el empeado en el archivo de texto
        }else{
            JOptionPane.showMessageDialog(null,"codigo de seuridad incorrecto vuelva a intentarlo","error",JOptionPane.ERROR_MESSAGE);
        }
        }catch(NullPointerException b){
            JOptionPane.showMessageDialog(null,"HAz introducido alguno de los errores equivocadamente","error",JOptionPane.ERROR_MESSAGE);
        }
       
      
    
    
    
    }
  public void despedir(String id,boolean codigodeseguridad){
      if(codigodeseguridad){ // se asigna un codigo se seguridad para que caulquier empleado no pueda despedir 
          gestion.cargar(this); // a cualquier otro empleado// se carga para que toda la informacion del archivo de texto se pase al arrayList y manipular la informacion
      for (int i = 0; i <this.ChiomaBakery.getEmpleados().size(); i++) {// busca de todos los empleados de la panaderia que tengan igual numero de cedula
          if (this.ChiomaBakery.getEmpleados().get(i).getID().equals(id)) {
              this.ChiomaBakery.getEmpleados().remove(i);// lo elinimna del arraylist que esta en la panaderia, y consuguientemente lo guarda en el archivo de texto
          }
      }
  
      gestion.guardartodo(this);
      }else{
          JOptionPane.showMessageDialog(null,"codigo de seuridad incorrecto vuelva a intentarlo","error",JOptionPane.ERROR_MESSAGE);
      }
  
  }
  
 
  public void retirarFondo(int valor){
      
  }

   public boolean rectificarCodigoSeguridad(String codigo){
       
       if(codigo.equals(this.codigoseguriadad)){
           return true;
       }
       
       return false;
   }
   
   public String rectificarContrasena(String contrasena1,String contrasena){
       
       if(contrasena.equals(contrasena1)){
           return contrasena;
       }else{
           JOptionPane.showMessageDialog(null," las contraseñas no coinciden, por favor intenta de nuevo","Error",JOptionPane.ERROR_MESSAGE);
       }
       
       
       return null;
   }
   public boolean ingresar(String contrasena,String name){
       if (this.ususario.equals(name)&&this.contrasena.equals(contrasena)){
           return true;
       }else{
           return this.ChiomaBakery.ingresar(name, contrasena);
       }
   }

    







}
