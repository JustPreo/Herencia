/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author saidn
 */
public class Frame extends JFrame{
    private static final Color NEGRO_SUAVE     = new Color(30, 30, 30);     
private static final Color DORADO_METALICO = new Color(212, 175, 55);   
private static final Color MADERA_CAFE     = new Color(92, 64, 51);     
private static final Color GRIS_PIZARRA    = new Color(60, 63, 65);     
private static final Color CREMA_SUAVE     = new Color(240, 234, 220);  


    public Frame(){
    
    }
    
    public  void FrameConFondo(JFrame frame, Image bg) {
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel bgPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (bg != null) {
                    g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        bgPanel.setLayout(new BorderLayout());
        frame.setContentPane(bgPanel);
        frame.getContentPane().setLayout(new GridBagLayout());
    }
    
     public  Image cargarFondo(String imagen) {
        try {
            return ImageIO.read(
                    Frame.class.getResource(imagen)
            );
        } catch (IOException | IllegalArgumentException ex) {
            System.err.println("No pude cargar el fondo: " + ex.getMessage());
            return null;
        }   
    }
     
     public  void titulo(JLabel titleLabel) {
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(DORADO_METALICO);
        titleLabel.setForeground(CREMA_SUAVE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(100, 0, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(titleLabel, gbc);
    }
     
     public void disBoton(JButton btn[] ){
    JPanel panel = new JPanel(new GridLayout(2, 2, 20, 20));
    panel.setOpaque(false);
    Font buttonFont = new Font("Arial", Font.BOLD, 32);
    Dimension buttonSize = new Dimension(200, 70);
    
   int length = btn.length;
        for (int i = 0 ; i< length;i++) {
            btn[i].setFont(buttonFont);
            btn[i].setPreferredSize(buttonSize);
            btn[i].setOpaque(true);
            btn[i].setContentAreaFilled(true);
            btn[i].setBorderPainted(true);
            btn[i].setBackground(CREMA_SUAVE);
            btn[i].setForeground(DORADO_METALICO);
            btn[i].setBorder(BorderFactory.createLineBorder(DORADO_METALICO, 2));
            panel.add(btn[i]);
        }
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(420, 0, 0, 0);
        getContentPane().add(panel, gbc);
        
        }
    
}
