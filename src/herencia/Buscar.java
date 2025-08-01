/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencia;
import javax.swing.*;

/**
 *
 * @author user
 */
public class Buscar extends Frame
{
    JButton buscar , calcularPagos , modificarInformacion;
    JLabel codigoT , registrarVentasT,modificarInformacionT,calcularPagosT;
    JTextField codigo , registrarVentas;
    
    
    String imagen = "segimg.png";
    
    
    public Buscar()
    {
    FrameConFondo(this, cargarFondo(imagen));
    
    //Crear botones
    buscar = new JButton("Buscar");
    buscar.setBounds(10,10,50,50);
    getContentPane().add(buscar);
    
    calcularPagos = new JButton("Calcular pagos");
    calcularPagos.setBounds(10,60,50,50);
    getContentPane().add(calcularPagos);
    
    
    
    }
    
    
    public static void main(String[] args) {
        System.out.println("");
        Buscar buscar = new Buscar();
        buscar.setVisible(true);
    }
    
}
