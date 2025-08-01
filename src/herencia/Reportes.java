/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencia;

import static herencia.Frame.CREMA_SUAVE;
import static herencia.Frame.DORADO_METALICO;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author saidn
 */
public class Reportes extends Frame {
    private JLabel titleLabel = new JLabel("Reportes", SwingConstants.CENTER);
    private JButton btnVentas = new JButton("Estandar");
    private JButton btnEstandar = new JButton("Ventas");
    private JButton btnTemporal = new JButton("Temporal");
    private JButton btnRegresar = new JButton("Regresar");
    public Reportes(){
        
    JButton btn[] = new JButton[]{btnVentas, btnEstandar,btnTemporal, btnRegresar};
    String imagen = "segimg.png";
    FrameConFondo(this, cargarFondo(imagen));
    disBoton(btn);
    botones();
    this.setVisible(true);
    
          titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(DORADO_METALICO);
        titleLabel.setForeground(CREMA_SUAVE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(60, 10, 40, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(titleLabel, gbc);
        
    }
    
    public void botones(){
    btnTemporal.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new Reportes().setVisible(true));
            dispose();
        });
      btnVentas.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new Buscar().setVisible(true));
            dispose();
        });
       btnEstandar.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new RegistrarF().setVisible(true));
            dispose();
        });
       btnRegresar.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> new Main().setVisible(true));
            dispose();
        });
}
    
    public static void main(String[] args) {
        new Reportes();
    }
    }
    

