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
public class Empleado extends Persona implements Serializable{
    
   private int salario;

    

    public Empleado(int salario, String nombre, String ID, String ususario, String contrasena) {
        super(nombre, ID, ususario, contrasena);
        this.salario = salario;
    }

   
        
    
    
    
    
}
