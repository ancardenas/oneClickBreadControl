package oneclickbreadcontrol;



import java.io.IOException;
import javax.swing.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author Andres
 */
public class OneClickbreadControl  {
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       
        GestionDeArchivos gestion=new GestionDeArchivos();
        Panaderia panaderia=new Panaderia("ChiomaBakery","bogota",311670);
        Jefe jefe=new Jefe(panaderia,"velentine",gestion,"desarrolladores","1520","deserrolladores","1520");// este es el supercontrol maestor como entran los programadores
                                                                                                            //ya que el jefe es un empleado con la clave maestra
      
                                                                                                            
        venRegistroEmpleado registro=new venRegistroEmpleado(jefe);
        venIngresar ingresar=new venIngresar(jefe);
        ingresar.show();
        
        
        
    }

    
    
}
