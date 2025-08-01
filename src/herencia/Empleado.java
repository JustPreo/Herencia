/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencia;

import java.util.Calendar;

/**
 *
 * @author user
 */
public class Empleado {

    protected int codigo;
    protected String nombre;
    protected Calendar fechaContratacion;
    protected double salarioBase;
    protected double horasTrabajadas;

    public Empleado(int codigo, String nombre, double salarioBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaContratacion = Calendar.getInstance();
        this.salarioBase = salarioBase;
        this.horasTrabajadas = 0;

    }

    public boolean registrarHoras(int horas) {
        if (horas >= 0) {
            horasTrabajadas += horas;
            return true;
        }
        System.out.println("No se pueden poner horas negativas");
        return false;
    }

    public double calculoPago()//WIP
    {
        double pagoPorHora = (salarioBase / 160);
        double pagoNeto = pagoPorHora * horasTrabajadas;
        return pagoNeto- (pagoNeto*0.035);
    }

    public String mostrarInformacion() {
        //Devuelve una cadena que incluye el código, el nombre y la fecha de contratación del empleado.
        return "Codigo:"+codigo
                +"\nNombre completo:"+nombre+""
                + "\nFecha Contratacion:"+fechaContratacion;
    }

}
