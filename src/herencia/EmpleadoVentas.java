/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencia;

/**
 *
 * @author user
 */
public class EmpleadoVentas extends Empleado {

    double ventasMensuales;//Ventas
    double tasaComision;//Tiene que pedirse de un porcentaje osea 5%?
    double ventasAnuales;
//a

    public EmpleadoVentas(int codigo, String nombre, double salarioBase, double tasaComision) {
        super(codigo, nombre, salarioBase);
        ventasMensuales = 0;
        this.tasaComision = tasaComision * 0.01;//5 * 0.01 = 0.05 osea 5%
    }

    public boolean registroVentas(double monto) {
        if (monto >= 0) {
            ventasMensuales += monto;
            ventasAnuales += monto;
            return true;
        }
        return false;//Monto negativo
    }

    public double calculoComision() {
        return ventasMensuales * tasaComision;
    }

    public double calculoPago() {
        double pagoPorHora = (salarioBase / 160);
        double pagoNeto = pagoPorHora * horasTrabajadas;
        return pagoNeto + calculoComision();
    }

    public double ventasAnuales() {
        return ventasAnuales;
    }

    public String mostrarInformacion() {
        return super.mostrarInformacion() + "\nTotal de ventas anuales: Lps." + ventasAnuales;
    }
    
    public double getTasaComision()
    {
    return tasaComision;
    }

}
