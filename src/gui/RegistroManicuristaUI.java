package gui;

import javax.swing.*;
import java.awt.*;
import codigo.manicurista;

public class RegistroManicuristaUI extends JDialog {
    private JTextField txtId, txtNombre, txtTelefono;
    private manicurista nuevoManicurista;

    public RegistroManicuristaUI(JFrame parent) {
        super(parent, "Registro de Manicurista", true);
        setSize(350, 250);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("ID:"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        add(txtTelefono);

        JButton btnRegistrar = new JButton("Registrar");
        JButton btnCancelar = new JButton("Cancelar");
        add(btnRegistrar);
        add(btnCancelar);

        btnRegistrar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText().trim());
                String nombre = txtNombre.getText().trim();
                String telefono = txtTelefono.getText().trim();

                if (!nombre.isEmpty() && !telefono.isEmpty()) {
                    nuevoManicurista = new manicurista(id, nombre, telefono);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Complete todos los campos.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El ID debe ser un número.");
            }
        });

        btnCancelar.addActionListener(e -> {
            nuevoManicurista = null;
            dispose();
        });
    }

    public manicurista getManicuristaRegistrado() {
        return nuevoManicurista;
    }
}
