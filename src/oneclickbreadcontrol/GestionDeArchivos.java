/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oneclickbreadcontrol;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class GestionDeArchivos {
   
    
    private FileOutputStream registroDeInventario;  // se declaran los files donde se va a guargar los datos para
    private FileOutputStream flujoDeCaja;           // la persistencia
    private FileOutputStream datosEmpleados;
    private FileOutputStream flujoDEcajaMensual;
    
    private FileInputStream inregistroDeInventario;  // se declaran los files donde se va a guargar los datos para
    private FileInputStream influjoDeCaja;           // la persistencia
    private FileInputStream indatosEmpleados;
    private FileInputStream influjoDEcajaMensual;
    
    private ObjectOutputStream escritorInventario;    // se declararon 3 por que ObjecoutputStream no tiene un metodo de cambiar el archivo
    private ObjectOutputStream escritorEmpleado;     // asi que cada arvhivo va a tener un objeto que la escriba
    private ObjectOutputStream escritorCaja; 
    private ObjectOutputStream escritorCajaMensual;
    
    private ObjectInputStream leedorInventario;  //   se declararon 3 por que ObjectinputStream no tiene un metodo de cambiar el archivo
    private  ObjectInputStream leedorEmpleado;      // asi que cada arvhivo va a tener un objeto que la lea
    private  ObjectInputStream leedorCaja;
    private ObjectInputStream  leerdorCajaMensual;
    
    
    public GestionDeArchivos() throws FileNotFoundException, IOException {
        this.datosEmpleados=new FileOutputStream("datosEmpleados.txt");    // se libera espacio de memoria para que la serializacion
        flujoDeCaja=new FileOutputStream("flujoDecaja");                    //se realice.
        registroDeInventario=new FileOutputStream("registroDeInventario");
        flujoDEcajaMensual=new FileOutputStream("flujoDeCajaMensual.txt");
        
        indatosEmpleados=new FileInputStream("datosEmpleados.txt");    // se libera espacio de memoria para que la serializacion
        influjoDeCaja=new FileInputStream("flujoDecaja");                    //se realice.
        inregistroDeInventario=new FileInputStream("registroDeInventario");
        influjoDEcajaMensual=new FileInputStream("flujoDeCajaMensual.txt");
        
        this.escritorEmpleado=new ObjectOutputStream(datosEmpleados);
        this.escritorCaja=new ObjectOutputStream(flujoDeCaja);
        this.escritorInventario=new ObjectOutputStream(registroDeInventario);
        this.escritorCajaMensual=new ObjectOutputStream(flujoDEcajaMensual);
        
        this.leedorCaja=new ObjectInputStream(influjoDeCaja);
        this.leedorEmpleado=new ObjectInputStream(indatosEmpleados);
        this.leedorInventario=new ObjectInputStream(inregistroDeInventario);
        this.leerdorCajaMensual=new ObjectInputStream(influjoDEcajaMensual);
    }
    /**
     * @deprecated esta funcion guarda toda la informacion que hay hasta el momento en cada una de las 
     * clases y lo guarda en un archivo txt mediante serializacion
     * @param jefe 
     */
    public void guardartodo(Jefe jefe){
     
        try{
            //se asignan las memoria dinamicas que nos peromitiran ver lo que esta en el archivo de texto antes de guardar la infomacion
            ArrayList<Empleado> empleados=new ArrayList();
            ArrayList<Caja> cajadiaria=new ArrayList();
            ArrayList<Caja> cajamensual=new ArrayList();
            ArrayList<Producto> productosinventario=new ArrayList();
            
            //  lo qe esta a cntinuacion se hace con el fin de no guardar lo que ya esta guardado en el archivo de texto
            //si lo que esta en ele archivo de texto, es igual a lo que se va a guardar entonces  no lo guarda.
             try{
          while(true){
                 Empleado aux=(Empleado)this.leedorEmpleado.readObject(); 
                    empleados.add(aux);}                                                 
         }
          catch(ClassNotFoundException a){}
          catch(EOFException b){}
          catch(IOException c){}
             // se procede a guardar en el archivo de texto el jefe en primera ocacion y despues 
            //el arraylist de empleados que estan en panaderia.
         if(!empleados.equals(jefe.getChiomaBakery().getEmpleados())){
                 this.escritorEmpleado.writeObject(jefe);
            this.escritorEmpleado.writeObject(jefe.getChiomaBakery().getEmpleados());
            }
            
         
         //  lo qe esta a cntinuacion se hace con el fin de no guardar lo que ya esta guardado en el archivo de texto
            //si lo que esta en ele archivo de texto, es igual a lo que se va a guardar entonces  no lo guarda.
             try{
          while(true){
                Caja aux=(Caja)this.leedorCaja.readObject(); 
                    cajadiaria.add(aux);}                                                 
         }
          catch(ClassNotFoundException a){}
          catch(EOFException b){}
          catch(IOException c){}
           //se eprocede a guardar las cajas diariarias de cada uno de los empleados en la panaderia
          // si esta informacion ya esta en le archivo de texto entonces no la vuenve a guardar
            if(!cajadiaria.equals(jefe.getChiomaBakery().getCajasdiarias())){
                this.escritorCaja.writeObject(jefe.getChiomaBakery().getCajasdiarias());
            }
           
            //  lo qe esta a cntinuacion se hace con el fin de no guardar lo que ya esta guardado en el archivo de texto
            //si lo que esta en ele archivo de texto, es igual a lo que se va a guardar entonces  no lo guarda.
             try{
          while(true){
                Caja aux=(Caja)this.leerdorCajaMensual.readObject(); 
                    cajamensual.add(aux);}                                                 
         }
          catch(ClassNotFoundException a){}
          catch(EOFException b){}
          catch(IOException c){} 
             //se procede a guardar la caja mensual de la panaderia que es un acumulado de las cajas diarias de cada
            //uno de los emplaedos.
            if (!cajamensual.equals(jefe.getChiomaBakery().getCajasmensuales())) {
                 this.escritorCaja.writeObject(jefe.getChiomaBakery().getCajasmensuales());
            }

              //  lo qe esta a cntinuacion se hace con el fin de no guardar lo que ya esta guardado en el archivo de texto
            //si lo que esta en ele archivo de texto, es igual a lo que se va a guardar entonces  no lo guarda.
             try{
          while(true){
                Producto aux=(Producto)this.leedorInventario.readObject(); 
                    productosinventario.add(aux);}                                                 
         }
          catch(ClassNotFoundException a){}
          catch(EOFException b){}
          catch(IOException c){} 

           // se procede a guardar la informacion del inventario
            
            if (!productosinventario.equals(jefe.getChiomaBakery().getInv().getProductosymaterias())) {
                this.escritorInventario.writeObject(jefe.getChiomaBakery().getInv());
            }

        
        
        }catch( IOException a){
            
        }
    }
  
    
    
    /**
  * @deprecated esta funcion lee la informacion que estan en los archivos txt
  * y las almacena en los atrributos que estan en cada una de la clases.
  * @param jefe 
  */
public void cargar(Jefe jefe){
         
         try{
             while(true){
                 Empleado aux=(Empleado)this.leedorEmpleado.readObject(); // lee el archivo de texto hasta que se genere un error 
                 jefe.getChiomaBakery().getEmpleados().add(aux); // cada uno de los objetos los va guardando en el arraylist de empleados en panaderia
             }                                                  // un jefe en un empleado pero con una clave mestra.
         }catch(ClassNotFoundException a){}
         catch(EOFException b){}
         catch(IOException c){}
         
           try{
             while(true){
                 Producto aux=(Producto)this.leedorInventario.readObject(); // lee el archivo de texto hasta que se genere un error 
                 jefe.getChiomaBakery().getInv().getProductosymaterias().add(aux); // cada uno de los objetos los va guardando en el arraylist de empleados en panaderia
             }                                                  // un jefe en un empleado pero con una clave mestra.
         }catch(ClassNotFoundException a){}
         catch(EOFException b){}
         catch(IOException c){}
         
         
         
     }



















}
