package herencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegistrarF extends Frame {

    String imagen = "segimg.png";
    private JLabel titleLabel = new JLabel("Registrar Empleado", SwingConstants.CENTER);
    private JLabel codigoT, nombreT, salarioT, tipoEmpleadoT, extra1T, extra2T, fechaFinT;
    private JTextField codigo, nombre, salario, extra1, extra2, fechaFin;
    private JButton crear;
    private JComboBox<String> tipoEmpleado;

    public RegistrarF() {
        FrameConFondo(this, cargarFondo(imagen));
        titulo(titleLabel);

        codigo = new JTextField();
        codigo.setBounds(50, 100, 150, 25);
        add(codigo);

        codigoT = new JLabel("Código:");
        codigoT.setBounds(50, 80, 150, 20);
        add(codigoT);

        nombre = new JTextField();
        nombre.setBounds(50, 150, 150, 25);
        add(nombre);

        nombreT = new JLabel("Nombre:");
        nombreT.setBounds(50, 130, 150, 20);
        add(nombreT);

        salario = new JTextField();
        salario.setBounds(50, 200, 150, 25);
        add(salario);

        salarioT = new JLabel("Salario Base:");
        salarioT.setBounds(50, 180, 150, 20);
        add(salarioT);

        tipoEmpleadoT = new JLabel("Tipo de Empleado:");
        tipoEmpleadoT.setBounds(50, 230, 150, 20);
        add(tipoEmpleadoT);

        String[] tipos = {"", "Empleado Estándar", "Empleado Temporal", "Empleado Ventas"};
        tipoEmpleado = new JComboBox<>(tipos);
        tipoEmpleado.setBounds(50, 250, 200, 25);
        add(tipoEmpleado);

        extra1 = new JTextField();
        extra1.setBounds(50, 300, 150, 25);
        extra1.setVisible(false);
        add(extra1);

        extra1T = new JLabel();
        extra1T.setBounds(50, 280, 150, 20);
        extra1T.setVisible(false);
        add(extra1T);

        extra2 = new JTextField();
        extra2.setBounds(50, 350, 150, 25);
        extra2.setVisible(false);
        add(extra2);

        extra2T = new JLabel();
        extra2T.setBounds(50, 330, 150, 20);
        extra2T.setVisible(false);
        add(extra2T);

        fechaFin = new JTextField();
        fechaFin.setBounds(50, 400, 150, 25);
        fechaFin.setVisible(false);
        add(fechaFin);

        fechaFinT = new JLabel("Fecha fin contrato (yyyy-mm-dd):");
        fechaFinT.setBounds(50, 380, 200, 20);
        fechaFinT.setVisible(false);
        add(fechaFinT);

        crear = new JButton("Crear Empleado");
        crear.setBounds(50, 450, 150, 30);
        add(crear);

        tipoEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String seleccionado = tipoEmpleado.getSelectedItem().toString();
                extra1.setVisible(false);
                extra1T.setVisible(false);
                extra2.setVisible(false);
                extra2T.setVisible(false);
                fechaFin.setVisible(false);
                fechaFinT.setVisible(false);

                if (seleccionado.equals("Empleado Ventas")) {
                    extra1T.setText("Tasa Comisión (%):");
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
                    System.out.println("Seleccione un tipo de empleado válido.");
                    return;
            }

            System.out.println("Empleado creado con éxito:");
            System.out.println(emp.mostrarInformacion());

        } catch (Exception ex) {
            System.out.println("Error al crear empleado: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new RegistrarF();
    }
} 
