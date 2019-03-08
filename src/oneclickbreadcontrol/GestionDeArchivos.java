/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oneclickbreadcontrol;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Andres
 */
public class GestionDeArchivos {
   
    
    private FileOutputStream registroDeInventario;  // se declaran los files donde se va a guargar los datos para
    private FileOutputStream flujoDeCaja;           // la persistencia
    private FileOutputStream datosEmpleados;
    
    private ObjectOutputStream escritorInventario;    // se declararon 3 por que ObjecoutputStream no tiene un metodo de cambiar el archivo
    private ObjectOutputStream escritorEmpleado;     // asi que cada arvhivo va a tener un objeto que la escriba
    private ObjectOutputStream escritorCaja; 
    
    private ObjectInputStream leedorInventario;  //   se declararon 3 por que ObjectinputStream no tiene un metodo de cambiar el archivo
    private  ObjectInputStream leedorEmpleado;      // asi que cada arvhivo va a tener un objeto que la lea
    private  ObjectInputStream leedorCaja;

    public GestionDeArchivos() throws FileNotFoundException, IOException {
        registroDeInventario=new FileOutputStream("datosEmpleados.txt");    // se libera espacio de memoria para que la serializacion
        flujoDeCaja=new FileOutputStream("flujoDecaja");                    //se realice.
        registroDeInventario=new FileOutputStream("registroDeInventario");
        this.escritorEmpleado=new ObjectOutputStream(datosEmpleados);
        this.escritorCaja=new ObjectOutputStream(flujoDeCaja);
        this.escritorInventario=new ObjectOutputStream(registroDeInventario);
    }
    /**
     * @deprecated esta funcion guarda toda la informacion que hay hasta el momento en cada una de las 
     * clases y lo guarda en un archivo txt mediante serializacion
     * @param jefe 
     */
    public void guardartodo(Jefe jefe){
     
        try{
            
            // se procede a guardar en el archivo de texto el jefe en primera ocacion y despues 
            //el arraylist de empleados que estan en panaderia.
            this.escritorEmpleado.writeObject(jefe);
            this.escritorEmpleado.writeObject(jefe.ChiomaBakery.getEmpleados());
            
            //se procede a guardar la caja mensual de la panaderia que es un acumulado de las cajas diarias de cada
            //uno de los emplaedos.
            // primero se guarda las cajas mensules 
            //y por ultimo todas las cajas diariarias
            this.escritorCaja.writeObject(jefe.ChiomaBakery.getCajasmensuales());
            this.escritorCaja.writeObject(jefe.ChiomaBakery.getCajasdiarias());
           
            // se procede a guardar la informacion del inventario
            this.escritorInventario.writeObject(jefe.ChiomaBakery.getInv());
        
        
        }catch( IOException a){
            
        }
    







    }
    
 /**
  * @deprecated esta funcion lee la informacion que estan en los archivos txt
  * y las almacena en los atrributos que estan en cada una de la clases.
  * @param jefe 
  */

    
     public void cargar(Jefe jefe){
         
         
         
         
     }



















}
