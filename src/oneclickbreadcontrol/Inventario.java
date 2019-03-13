/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oneclickbreadcontrol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.swing.JOptionPane;
import static oneclickbreadcontrol.OneClickbreadControl.gestion;

/**
 *
 * @author Andres
 */
public class Inventario implements Serializable {
    
    private ArrayList movimientos=new ArrayList();
     private Calendar calendario=new GregorianCalendar();
     private ArrayList<Producto> Productosymaterias=new ArrayList();

   /**
    * @deprecated  es ta funcion quita productos del inventario
    * @param id
    * @param catidad
    * @param jefe 
    */
     
     public void quitar(String id,int catidad,Jefe jefe){
        
         for (int i = 0; i < this.Productosymaterias.size(); i++) {
           // busca primero si el producto que se va a encontrar esta en el inventario
             if(id.equals(this.Productosymaterias.get(i).getID())) {
                
                 if (catidad==this.Productosymaterias.get(i).getCatidad()) {// revisas so la cantidad que se va a retirar  no excede la cantidad que hay
           String traza="Se retiron "+this.Productosymaterias.get(i).getCatidad()+" "+this.Productosymaterias.get(i).getUnidades()+" de "+this.Productosymaterias.get(i).getNombre()+" con codigo deproducto "
                   +this.Productosymaterias.get(i).getID()+" en la fecha "+calendario.getTime();
               this.movimientos.add(traza);       
           this.Productosymaterias.remove(i);                      // si la cantidad es igual a la pedida lo quita del inventario
                    gestion.guardartodo(jefe);
                 }else if (this.Productosymaterias.get(i).getCatidad()>catidad) {// revisas so la cantidad que se va a retirar  no excede la cantidad que hay
                 String traza="Se retiron "+this.Productosymaterias.get(i).getCatidad()+" "+this.Productosymaterias.get(i).getUnidades()+" de "+this.Productosymaterias.get(i).getNombre()+" con codigo deproducto "
                   +this.Productosymaterias.get(i).getID()+" en la fecha "+calendario.getTime();
                      this.movimientos.add(traza); 
                 int catidadp=this.Productosymaterias.get(i).getCatidad();          // si es menor la que piden entonces quita la cantidad del inventario.
                        this.Productosymaterias.get(i).setCatidad(catidadp-catidad);
               gestion.guardartodo(jefe);
                 }else{
                    JOptionPane.showMessageDialog(null,"No existe la cantidad solicitada, por favor agrege mas elementos","error",JOptionPane.ERROR_MESSAGE);
                   
                }}else{
                 
                 JOptionPane.showMessageDialog(null,"No se encontro el producto solicitado","error",JOptionPane.ERROR_MESSAGE);
             }
         
         
         }
   }
     
     
     public void anadir(String nombre,String id, int cantidad, double precio, String unidades,Provedor provedor,Jefe jefe){
        
         boolean existencia=false;
         int posicion=0;
         for (int i = 0; i <this.Productosymaterias.size(); i++) {
            
             if (this.Productosymaterias.get(i).getID().equals(id)) {
                 existencia=true;
                 posicion=i;
             }
   
          
         }
             
             if (existencia) {
             int cantidadp= this.Productosymaterias.get(posicion).getCatidad();
              this.Productosymaterias.get(posicion).setCatidad(cantidad+cantidadp);
              gestion.guardartodo(jefe);
              
          }else{
              // se a crear un objeto tipo producto con el fin de igresar toda su informacion
         Producto producto=new Producto(nombre,id,precio,cantidad,unidades,provedor);
         // se añade al arraylist qie esta en el inventario
         this.Productosymaterias.add(producto);
         //se crea las hitoria y se añade  a todas las historias de el inventario
         String traza="Se añadieron "+cantidad+" "+unidades+" de "+nombre+" con codigo deproducto "
                   +id+" en la fecha "+calendario.getTime();
         
         this.movimientos.add(traza);
         // se guardan los cambios que se hicieron en el inventario
         gestion.guardartodo(jefe);
          }
         
        
         
        

         
         
     }
     
     
     public long precioInventario(){
         
         
         return 0;
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     public Calendar getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendar calendario) {
        this.calendario = calendario;
    }

    public ArrayList<Producto> getProductosymaterias() {
        return Productosymaterias;
    }

    public void setProductosymaterias(ArrayList<Producto> Productosymaterias) {
        this.Productosymaterias = Productosymaterias;
    }
     
     
     
   
}
