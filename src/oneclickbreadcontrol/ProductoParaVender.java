/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oneclickbreadcontrol;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class ProductoParaVender extends Producto implements Serializable{
    
    private ArrayList<MatPrima> matprima;

    public ProductoParaVender(ArrayList<MatPrima> matprima, String nombre, String ID, double precio, int catidad, String unidades) {
        super(nombre, ID, precio, catidad, unidades);
        this.matprima = matprima;
    }

    public ProductoParaVender(String nombre, String ID, double precio, int catidad, String unidades) {
        super(nombre, ID, precio, catidad, unidades);
    }

    

    public ArrayList<MatPrima> getMatprima() {
        return matprima;
    }

    public void setMatprima(ArrayList<MatPrima> matprima) {
        this.matprima = matprima;
    }
    
    
    
}
