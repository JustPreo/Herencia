package herencia;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Buscar extends Frame {

    // Lista de empleados pasada al constructor
    private ArrayList<Empleado> empleados = RegistrarF.empleados;

    JButton buscar, calcularPagos, modificarInformacion, registrarVentaBtn;
    JLabel codigoL, nombreL, salarioL, tipoL, fechaFinL, tasaComisionL, registrarVentaL;
    JTextField codigoT, nombreT, salarioT, tasaComisionT, registrarVentaT;
    JDateChooser fechaFinChooser;

    Empleado empleadoEncontrado = null;

    String imagen = "segimg.png";

    public Buscar() {

        FrameConFondo(this, cargarFondo(imagen));
        setLayout(null);

        // Campo para ingresar código a buscar
        codigoL = new JLabel("Código empleado:");
        codigoL.setBounds(20, 10, 120, 30);
        getContentPane().add(codigoL);

        codigoT = new JTextField();
        codigoT.setBounds(140, 10, 100, 30);
        getContentPane().add(codigoT);

        buscar = new JButton("Buscar");
        buscar.setBounds(250, 10, 100, 30);
        getContentPane().add(buscar);

        // Campos para mostrar/modificar info empleado
        nombreL = new JLabel("Nombre:");
        nombreL.setBounds(20, 60, 120, 30);
        getContentPane().add(nombreL);

        nombreT = new JTextField();
        nombreT.setBounds(140, 60, 200, 30);
        nombreT.setEnabled(true);
        getContentPane().add(nombreT);

        salarioL = new JLabel("Salario Base:");
        salarioL.setBounds(20, 100, 120, 30);
        getContentPane().add(salarioL);

        salarioT = new JTextField();
        salarioT.setBounds(140, 100, 100, 30);
        salarioT.setEnabled(true);
        getContentPane().add(salarioT);

        tipoL = new JLabel("Tipo Empleado:");
        tipoL.setBounds(20, 140, 120, 30);
        getContentPane().add(tipoL);

        // Mostrar solo el tipo (no modificar)
        JTextField tipoT = new JTextField();
        tipoT.setBounds(140, 140, 150, 30);
        tipoT.setEnabled(true);
        getContentPane().add(tipoT);

        // Campo para fecha fin contrato (solo temporal)
        fechaFinL = new JLabel("Fecha fin contrato:");
        fechaFinL.setBounds(20, 180, 120, 30);
        fechaFinL.setVisible(false);
        getContentPane().add(fechaFinL);

        fechaFinChooser = new JDateChooser();
        fechaFinChooser.setBounds(140, 180, 150, 30);
        fechaFinChooser.setDateFormatString("yyyy-MM-dd");
        fechaFinChooser.setVisible(false);
        getContentPane().add(fechaFinChooser);

        // Campo para tasa comisión (solo ventas)
        tasaComisionL = new JLabel("Tasa Comisión (%):");
        tasaComisionL.setBounds(20, 220, 120, 30);
        tasaComisionL.setVisible(false);
        getContentPane().add(tasaComisionL);

        tasaComisionT = new JTextField();
        tasaComisionT.setBounds(140, 220, 100, 30);
        tasaComisionT.setVisible(false);
        getContentPane().add(tasaComisionT);

        // Registrar ventas (solo ventas)
        registrarVentaL = new JLabel("Registrar venta Lps.:");
        registrarVentaL.setBounds(20, 260, 120, 30);
        registrarVentaL.setVisible(false);
        getContentPane().add(registrarVentaL);

        registrarVentaT = new JTextField();
        registrarVentaT.setBounds(140, 260, 100, 30);
        registrarVentaT.setVisible(false);
        getContentPane().add(registrarVentaT);

        registrarVentaBtn = new JButton("Registrar Venta");
        registrarVentaBtn.setBounds(250, 260, 130, 30);
        registrarVentaBtn.setVisible(false);
        getContentPane().add(registrarVentaBtn);

        // Botones
        modificarInformacion = new JButton("Modificar Información");
        modificarInformacion.setBounds(20, 310, 180, 30);
        modificarInformacion.setEnabled(true);
        getContentPane().add(modificarInformacion);

        calcularPagos = new JButton("Calcular Pago");
        calcularPagos.setBounds(220, 310, 150, 30);
        calcularPagos.setEnabled(true);
        getContentPane().add(calcularPagos);
        setVisible(true);

        // Listeners

        buscar.addActionListener(e -> {
            empleadoEncontrado = null;
            modificarInformacion.setEnabled(true);
            calcularPagos.setEnabled(true);
            registrarVentaBtn.setVisible(false);
            registrarVentaT.setVisible(false);
            registrarVentaL.setVisible(false);
            tasaComisionL.setVisible(false);
            tasaComisionT.setVisible(false);
            fechaFinChooser.setVisible(false);
            fechaFinL.setVisible(false);

            String codigoStr = codigoT.getText();
            if (codigoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese un código para buscar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int codigo;
            try {
                codigo = Integer.parseInt(codigoStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Código inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Buscar empleado
            for (Empleado emp : empleados) {
                if (emp.getCodigo() == codigo) {
                    empleadoEncontrado = emp;
                    break;
                }
            }
            if (empleadoEncontrado == null) {
                JOptionPane.showMessageDialog(this, "Empleado no encontrado.", "Info", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                return;
            }
            // Mostrar datos en campos
            nombreT.setText(empleadoEncontrado.getNombre());
            salarioT.setText(String.valueOf(empleadoEncontrado.getSalario()));
            tipoT.setText(empleadoEncontrado.getClass().getSimpleName());

            // Mostrar campos extra según tipo
            if (empleadoEncontrado instanceof EmpleadoTemporal) {
                fechaFinL.setVisible(true);
                fechaFinChooser.setVisible(true);
                fechaFinChooser.setDate(((EmpleadoTemporal) empleadoEncontrado).getFechaFinContrato().getTime());
                tasaComisionL.setVisible(false);
                tasaComisionT.setVisible(false);
                registrarVentaBtn.setVisible(false);
                registrarVentaT.setVisible(false);
                registrarVentaL.setVisible(false);
            } else if (empleadoEncontrado instanceof EmpleadoVentas) {
                tasaComisionL.setVisible(true);
                tasaComisionT.setVisible(true);
                tasaComisionT.setText(String.valueOf(((EmpleadoVentas) empleadoEncontrado).getTasaComision() * 100));
                registrarVentaBtn.setVisible(true);
                registrarVentaT.setVisible(true);
                registrarVentaL.setVisible(true);
                fechaFinChooser.setVisible(false);
                fechaFinL.setVisible(false);
            } else {
                // Empleado estándar
                tasaComisionL.setVisible(false);
                tasaComisionT.setVisible(false);
                registrarVentaBtn.setVisible(false);
                registrarVentaT.setVisible(false);
                registrarVentaL.setVisible(false);
                fechaFinChooser.setVisible(false);
                fechaFinL.setVisible(false);
            }

            modificarInformacion.setEnabled(true);
            calcularPagos.setEnabled(true);
        });

        modificarInformacion.addActionListener(e -> {
            if (empleadoEncontrado == null) return;

            // Modificar nombre y salario base
            String nuevoNombre = nombreT.getText().trim();
            String nuevoSalarioStr = salarioT.getText().trim();

            if (nuevoNombre.isEmpty() || nuevoSalarioStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nombre y salario no pueden estar vacíos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double nuevoSalario;
            try {
                nuevoSalario = Double.parseDouble(nuevoSalarioStr);
                if (nuevoSalario <= 0) {
                    JOptionPane.showMessageDialog(this, "Salario debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Salario inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            empleadoEncontrado.nombre = (nuevoNombre);
            empleadoEncontrado.salarioBase = (nuevoSalario);

            // Si es temporal, actualizar fecha fin contrato
            if (empleadoEncontrado instanceof EmpleadoTemporal) {
                Calendar nuevaFecha = Calendar.getInstance();
                if (fechaFinChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(this, "Seleccione una fecha válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                nuevaFecha.setTime(fechaFinChooser.getDate());

                if (!((EmpleadoTemporal) empleadoEncontrado).actualizarFinContrato(nuevaFecha)) {
                    JOptionPane.showMessageDialog(this, "La nueva fecha debe ser posterior a la anterior.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Si es ventas, actualizar tasa comisión
            if (empleadoEncontrado instanceof EmpleadoVentas) {
                String tasaStr = tasaComisionT.getText().trim();
                if (tasaStr.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingrese una tasa de comisión válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    double nuevaTasa = Double.parseDouble(tasaStr);
                    if (nuevaTasa <= 0) {
                        JOptionPane.showMessageDialog(this, "La tasa debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    ((EmpleadoVentas) empleadoEncontrado).tasaComision = nuevaTasa * 0.01; // porcentaje a decimal
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Tasa inválida.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "Información modificada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        });

        registrarVentaBtn.addActionListener(e -> {
            if (empleadoEncontrado == null) return;
            if (!(empleadoEncontrado instanceof EmpleadoVentas)) return;

            String montoStr = registrarVentaT.getText().trim();
            if (montoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese un monto de venta válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double monto;
            try {
                monto = Double.parseDouble(montoStr);
                if (monto < 0) {
                    JOptionPane.showMessageDialog(this, "Monto debe ser positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Monto inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean exito = ((EmpleadoVentas) empleadoEncontrado).registroVentas(monto);
            if (exito) {
                JOptionPane.showMessageDialog(this, "Venta registrada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                registrarVentaT.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar venta.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        calcularPagos.addActionListener(e -> {
            if (empleadoEncontrado == null) return;
            double pago = empleadoEncontrado.calculoPago();
            JOptionPane.showMessageDialog(this, "Pago calculado: Lps. " + pago, "Pago", JOptionPane.INFORMATION_MESSAGE);
        });

    }

    private void limpiarCampos() {
        nombreT.setText("");
        salarioT.setText("");
        tasaComisionT.setText("");
        registrarVentaT.setText("");
        fechaFinChooser.setDate(null);
        nombreT.setEnabled(false);
        salarioT.setEnabled(false);
        tasaComisionT.setEnabled(false);
        registrarVentaT.setEnabled(false);
        fechaFinChooser.setVisible(false);
        fechaFinL.setVisible(false);
        tasaComisionL.setVisible(false);
        registrarVentaL.setVisible(false);
        registrarVentaT.setVisible(false);
    }

    public static void main(String[] args) {

        

        
    }

}
