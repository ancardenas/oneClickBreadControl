package oneclickbreadcontrol;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class Caja implements Serializable {
private double dinero;
private int dia;
private int mes;
private int anno;
private int hora;
private ArrayList<Venta> ventas;
private Empleado empleado;

    public Caja(int dia, int mes, int anno, int hora, Empleado empleado) {
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
        this.hora = hora;
        this.empleado = empleado;
    }

    public Caja(int dia, int mes, int anno, int hora) {
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
        this.hora = hora;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}

