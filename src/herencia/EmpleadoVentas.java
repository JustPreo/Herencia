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
   
   public EmpleadoVentas(int codigo,String nombre,double salarioBase,double tasaComision)
   {
   super(codigo, nombre, salarioBase);
   ventasMensuales = 0;
   this.tasaComision = tasaComision;
   }
   
   public boolean registroVentas(double monto)
   {
   
   }
    
}
