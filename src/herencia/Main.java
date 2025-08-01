/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencia;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

/**
 *
 * @author saidn
 */
public class Main extends Frame {

    private JButton btnReportes = new JButton("Reportes");
    private JButton btnBuscarEmp = new JButton("Empleados");
    private JButton btnRegistrar = new JButton("Registrar");
    private JButton btnCerrar = new JButton("Cerrar");
    private String imagen = "main-img.png";

    public Main() {
        JButton btn[] = new JButton[]{btnBuscarEmp, btnRegistrar,btnReportes, btnCerrar};
        FrameConFondo(this, cargarFondo(imagen));
        disBoton(btn);
        botones();

    }
private void botones(){
    
     btnReportes.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new Reportes().setVisible(true));
            dispose();
        });
      btnBuscarEmp.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new Buscar().setVisible(true));
            dispose();
        });
       btnRegistrar.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new RegistrarF().setVisible(true));
            dispose();
        });
btnCerrar.addActionListener(e -> System.exit(0));
}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
