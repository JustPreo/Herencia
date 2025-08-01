/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencia;

/**
 *
 * @author user
 */
public class Buscar extends Frame
{
    
    String imagen = "segimg.png";
    
    
    public Buscar()
    {
    FrameConFondo(this, cargarFondo(imagen));
    
    }
    
    
    public static void main(String[] args) {
        System.out.println("");
        Buscar buscar = new Buscar();
        buscar.setVisible(true);
    }
    
}
