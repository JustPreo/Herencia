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

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
