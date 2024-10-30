package principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import eventos.SistemaEventosGUI;
import clinica.SistemaClinicaGUI;
import restaurante.SistemaRestauranteGUI;

public class SistemaPrincipal {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Gerenciamento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Criar o painel para os botões
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        // Botões para escolher o sistema
        JButton btnRestaurante = new JButton("Gerenciamento de Restaurante");
        JButton btnClinica = new JButton("Gerenciamento de Clínica");
        JButton btnEventos = new JButton("Gerenciamento de Eventos");

        // Adicionar ação para cada botão
        btnRestaurante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SistemaRestauranteGUI().setVisible(true);
                frame.dispose();  // Fechar a janela atual
            }
        });

        btnClinica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SistemaClinicaGUI().setVisible(true);
                frame.dispose();
            }
        });

        btnEventos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SistemaEventosGUI().setVisible(true);
                frame.dispose();
            }
        });

        // Adicionar os botões ao painel
        panel.add(btnRestaurante);
        panel.add(btnClinica);
        panel.add(btnEventos);

        // Adicionar o painel à janela
        frame.add(panel);
        frame.setLocationRelativeTo(null);  // Centralizar a janela
        frame.setVisible(true);
    }
}
