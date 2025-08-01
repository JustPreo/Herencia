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
public class EmpleadoTemporal extends Empleado {

    Calendar fechaFinContrato;

    public EmpleadoTemporal(int codigo, String nombre, double salarioBase, Calendar fechaFinContrato) {
        super(codigo, nombre, salarioBase);
        this.fechaFinContrato = fechaFinContrato;
    }

    public double calculoPago()//WIP
    {
        /*
        Si la fecha actual es anterior o igual a la fecha de fin de contrato, 
        se calcula el salario proporcional según las horas trabajadas.
        
        Si la fecha actual es posterior a la fecha de fin de 
        contrato, el pago es igual a cero.
         */
        Calendar hoy = Calendar.getInstance();
        if (hoy.before(fechaFinContrato)) {
            double pagoPorHora = (salarioBase / 160);
            double pagoNeto = pagoPorHora * horasTrabajadas;
            return pagoNeto;
        } else //if (hoy.after(fechaFinContrato))
        {
            //Por si es posterior a la fecha
            return 0;

        }
    }

    public boolean actualizarFinContrato(Calendar fechaNueva) {
        if (fechaNueva.after(fechaFinContrato)) {

            fechaFinContrato = fechaNueva;
            return true;
        } else {

            return false;
        }

    }

    public String mostrarInformacion() {
        return super.mostrarInformacion()
                + "\nFecha fin contrato:" + fechaFinContrato.get((Calendar.MONTH)+1)
                + "/" + fechaFinContrato.get(Calendar.DAY_OF_MONTH)
                + "/" + fechaFinContrato.get(Calendar.YEAR);
    }
    
    public Calendar getFechaFinContrato()
    {
    return fechaFinContrato;
    }

}
