package gui;

import javax.swing.*;
import java.awt.*;
import codigo.*;

public class LoginManicuristaUI extends JFrame {

    public LoginManicuristaUI() {
        setTitle("Login Manicurista");
        setSize(300, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));

        JLabel lblTitulo = new JLabel("Ingrese su ID de Manicurista:");
        JTextField txtId = new JTextField();
        JButton btnLogin = new JButton("Ingresar");
        JButton btnVolver = new JButton("Volver al Menú");

        add(lblTitulo);
        add(txtId);
        add(btnLogin);
        add(btnVolver);

        btnLogin.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText().trim());
                manicurista m = manicuristaDAO.autenticarManicurista(id);

                if (m != null) {
                    JOptionPane.showMessageDialog(this, "¡Bienvenida, " + m.getNombre() + "!");
                    dispose();
                    new MenuManicuristaUI(m).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "ID inválido. Intente nuevamente.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese un número válido.");
            }
        });

        btnVolver.addActionListener(e -> {
            dispose();
            new MenuUI().setVisible(true);
        });
    }
}
