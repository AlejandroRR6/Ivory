package gui;

import javax.swing.*;
import java.awt.*;

import codigo.manicurista;

public class MenuManicuristaUI extends JFrame {
    private manicurista manicuristaActual;

    public MenuManicuristaUI(manicurista manicuristaActual) {
        this.manicuristaActual = manicuristaActual;

        setTitle("Menú del Manicurista");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnVerCitas = new JButton("Ver citas asignadas");
        JButton btnGestionarDisponibilidad = new JButton("Gestionar disponibilidad");
        JButton btnSalir = new JButton("Salir al menú principal");

        add(btnVerCitas);
        add(btnGestionarDisponibilidad);
        add(btnSalir);

        btnVerCitas.addActionListener(e -> {
            // Mensaje simulado
            JOptionPane.showMessageDialog(this,
                "Simulación:\n- Cita 1: Cliente Ana, 2024-05-21, 10:00 AM\n- Cita 2: Cliente Luis, 2024-05-22, 2:00 PM",
                "Citas asignadas", JOptionPane.INFORMATION_MESSAGE);
        });

        btnGestionarDisponibilidad.addActionListener(e -> {
            // Mensaje simulado
            JOptionPane.showMessageDialog(this,
                "Simulación:\nPuedes modificar tu disponibilidad desde la opción correspondiente.",
                "Gestionar disponibilidad", JOptionPane.INFORMATION_MESSAGE);
        });

        btnSalir.addActionListener(e -> {
            dispose(); // Cierra la ventana actual
            new MenuUI().setVisible(true); // Vuelve al menú principal
        });
    }
}
