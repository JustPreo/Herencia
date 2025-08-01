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
    setLayout(null);
    
    //Crear botones
    buscar = new JButton("Buscar");
    buscar.setBounds(10,10,100,30);
    getContentPane().add(buscar);
    
    calcularPagos = new JButton("Calcular Pagos");
    calcularPagos.setBounds(10,60,150,30);
    getContentPane().add(calcularPagos);
    
    modificarInformacion = new JButton("Modificar Informacion");
    modificarInformacion.setBounds(10,110,170,30);
    getContentPane().add(modificarInformacion);
    
    //JLabel
    codigoT = new JLabel("Codigo:");
    codigoT.setBounds(50,60,150,30);
    getContentPane().add(codigoT);
    
    
    
    
    
    
    
    
    }
    
    
    public static void main(String[] args) {
        System.out.println("");
        Buscar buscar = new Buscar();
        buscar.setVisible(true);
    }
    
}
