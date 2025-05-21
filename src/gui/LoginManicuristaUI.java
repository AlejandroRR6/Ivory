package gui;

import javax.swing.*;
import java.awt.*;
import codigo.manicurista;
import codigo.manicuristaDAO;

public class LoginManicuristaUI extends JFrame {
    private JTextField txtId;

    public LoginManicuristaUI() {
        setTitle("Login Manicurista");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("ID Manicurista:"));
        txtId = new JTextField(15);
        panel.add(txtId);
        add(panel);

        JButton btnLogin = new JButton("Ingresar");
        add(btnLogin);

        btnLogin.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText().trim());
                manicurista m = manicuristaDAO.autenticarManicurista(id);

                if (m != null) {
                    JOptionPane.showMessageDialog(this, "Bienvenido, " + m.getNombre());
                    new MenuManicuristaUI(m).setVisible(true);
                    dispose();
                } else {
                    int opcion = JOptionPane.showConfirmDialog(this,
                            "No se encontró el manicurista. ¿Desea registrarse?",
                            "Manicurista no encontrado",
                            JOptionPane.YES_NO_OPTION);
                    if (opcion == JOptionPane.YES_OPTION) {
                        RegistroManicuristaUI registro = new RegistroManicuristaUI(this);
                        registro.setVisible(true);
                        manicurista nuevo = registro.getManicuristaRegistrado();
                        if (nuevo != null) {
                            manicuristaDAO.insertarManicurista(nuevo);
                            JOptionPane.showMessageDialog(this, "¡Registro exitoso!");
                        }
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.");
            }
        });
    }
}
