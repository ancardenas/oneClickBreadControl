package oneclickbreadcontrol;



import java.io.IOException;
import java.io.Serializable;
import javax.swing.*;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author Andres
 */
public class OneClickbreadControl  implements Serializable{
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static GestionDeArchivos gestion=new GestionDeArchivos();
    public static   Panaderia panaderia=new Panaderia("ChiomaBakery","bogota",311670);
    public static Jefe jefe = new Jefe(panaderia,"123","Andres","1234","123","123");
    public static void main(String[] args) throws IOException {
        /**
         * El bolque siguiente hace set del estilo en eeste caso quaqua
         */
        gestion.cargar(jefe);
        
        try {
            UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel15");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
        
        //Jefe jefe=new Jefe(panaderia,"velentine",gestion,"desarrolladores","1520","123","123");// este es el supercontrol maestor como entran los programadores
                                                                                                            //ya que el jefe es un empleado con la clave maestra
      
        venIngresar ing = new venIngresar();
        ing.show();
       
        /*venRegistroEmpleado registro=new venRegistroEmpleado(jefe);
        venIngresar ingresar=new venIngresar(jefe);
        ingresar.show();*/
        
        
        
    }

    
    
}
