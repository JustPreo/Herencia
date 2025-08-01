package herencia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;

public class RegistrarF extends Frame {

    String imagen = "segimg.png";
    private JLabel titleLabel = new JLabel("Registrar Empleado", SwingConstants.CENTER);
    private JLabel codigoT, nombreT, salarioT, tipoEmpleadoT, extra1T, fechaFinT;
    private JTextField codigo, nombre, salario, extra1, fechaFin;
    private JButton crear, cerrar;
    private JComboBox<String> tipoEmpleado;

    private ArrayList<Empleado> empleados = new ArrayList<>();

    public RegistrarF() {
        FrameConFondo(this, cargarFondo(imagen));

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

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;

        codigoT = new JLabel("Código:");
        codigoT.setForeground(CREMA_SUAVE);
        getContentPane().add(codigoT, gbc);
        gbc.gridx = 1;
        codigo = new JTextField(15);
        getContentPane().add(codigo, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        nombreT = new JLabel("Nombre:");
        nombreT.setForeground(CREMA_SUAVE);
        getContentPane().add(nombreT, gbc);
        gbc.gridx = 1;
        nombre = new JTextField(15);
        getContentPane().add(nombre, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        salarioT = new JLabel("Salario Base Lps. :");
        salarioT.setForeground(CREMA_SUAVE);
        getContentPane().add(salarioT, gbc);
        gbc.gridx = 1;
        salario = new JTextField(15);
        getContentPane().add(salario, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        tipoEmpleadoT = new JLabel("Tipo de Empleado:");
        tipoEmpleadoT.setForeground(CREMA_SUAVE);
        getContentPane().add(tipoEmpleadoT, gbc);
        gbc.gridx = 1;
        String[] tipos = {"", "Empleado Estándar", "Empleado Temporal", "Empleado Ventas"};
        tipoEmpleado = new JComboBox<>(tipos);
        getContentPane().add(tipoEmpleado, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        extra1T = new JLabel("Tasa Comisión (%):");
        extra1T.setForeground(CREMA_SUAVE);
        extra1T.setVisible(false);
        getContentPane().add(extra1T, gbc);
        gbc.gridx = 1;
        extra1 = new JTextField(15);
        extra1.setVisible(false);
        getContentPane().add(extra1, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        fechaFinT = new JLabel("Fecha fin contrato (yyyy-mm-dd):");
        fechaFinT.setForeground(CREMA_SUAVE);
        fechaFinT.setVisible(false);
        getContentPane().add(fechaFinT, gbc);
        gbc.gridx = 1;
        fechaFin = new JTextField(15);
        fechaFin.setVisible(false);
        getContentPane().add(fechaFin, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        crear = new JButton("Crear Empleado");
        crear.setFont(new Font("Arial", Font.BOLD, 20));
        crear.setBackground(DORADO_METALICO);
        crear.setForeground(Color.WHITE);
        getContentPane().add(crear, gbc);

        gbc.gridy++;
        cerrar = new JButton("Cerrar");
        cerrar.setFont(new Font("Arial", Font.BOLD, 16));
        cerrar.setBackground(NEGRO_SUAVE);
        cerrar.setForeground(Color.WHITE);
        cerrar.setBorder(BorderFactory.createLineBorder(DORADO_METALICO, 2));
        getContentPane().add(cerrar, gbc);

        tipoEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String seleccionado = tipoEmpleado.getSelectedItem().toString();
                extra1.setVisible(false);
                extra1T.setVisible(false);
                fechaFin.setVisible(false);
                fechaFinT.setVisible(false);

                if (seleccionado.equals("Empleado Ventas")) {
                    extra1.setVisible(true);
                    extra1T.setVisible(true);
                } else if (seleccionado.equals("Empleado Temporal")) {
                    fechaFin.setVisible(true);
                    fechaFinT.setVisible(true);
                }
                repaint();
            }
        });

        crear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearEmpleado();
            }
        });

        cerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void crearEmpleado() {
        try {
            int cod = Integer.parseInt(codigo.getText());
            String nom = nombre.getText();
            double salBase = Double.parseDouble(salario.getText());
            String tipo = tipoEmpleado.getSelectedItem().toString();

            Empleado emp = null;

            switch (tipo) {
                case "Empleado Estándar":
                    emp = new Empleado(cod, nom, salBase);
                    break;
                case "Empleado Temporal":
                    String[] partes = fechaFin.getText().split("-");
                    Calendar fecha = Calendar.getInstance();
                    fecha.set(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]) - 1, Integer.parseInt(partes[2]));
                    emp = new EmpleadoTemporal(cod, nom, salBase, fecha);
                    break;
                case "Empleado Ventas":
                    double tasa = Double.parseDouble(extra1.getText());
                    emp = new EmpleadoVentas(cod, nom, salBase, tasa);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Seleccione un tipo de empleado válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }

            empleados.add(emp);

            JOptionPane.showMessageDialog(this, "Empleado creado:\n" + emp.mostrarInformacion(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al crear empleado:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        codigo.setText("");
        nombre.setText("");
        salario.setText("");
        extra1.setText("");
        fechaFin.setText("");
        tipoEmpleado.setSelectedIndex(0);
        extra1.setVisible(false);
        extra1T.setVisible(false);
        fechaFin.setVisible(false);
        fechaFinT.setVisible(false);
    }

    public static void main(String[] args) {
        new RegistrarF();
    }
}
