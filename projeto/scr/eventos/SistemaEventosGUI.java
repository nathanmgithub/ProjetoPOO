package eventos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaEventosGUI extends JFrame {
    private Evento evento;

    public SistemaEventosGUI() {
        setTitle("Gerenciamento de Eventos");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 1));

        JButton btnCadastrarEvento = new JButton("Cadastrar Evento");
        JButton btnRegistrarParticipante = new JButton("Registrar Participante");
        JButton btnVerificarLotacao = new JButton("Verificar Lotação");
        JButton btnGerarRelatorio = new JButton("Gerar Relatório");

        painel.add(btnCadastrarEvento);
        painel.add(btnRegistrarParticipante);
        painel.add(btnVerificarLotacao);
        painel.add(btnGerarRelatorio);

        add(painel, BorderLayout.CENTER);

        // Ação para cadastrar evento
        btnCadastrarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeEvento = JOptionPane.showInputDialog("Digite o nome do evento:");
                String dataEvento = JOptionPane.showInputDialog("Digite a data do evento:");
                String nomeLocal = JOptionPane.showInputDialog("Digite o nome do local:");
                String enderecoLocal = JOptionPane.showInputDialog("Digite o endereço do local:");
                int capacidadeEvento = Integer.parseInt(JOptionPane.showInputDialog("Digite a capacidade do evento:"));

                Local local = new Local(nomeLocal, enderecoLocal, capacidadeEvento); // Cria o objeto Local
                evento = new Evento(nomeEvento, dataEvento, local); // Cria o evento com o local

                JOptionPane.showMessageDialog(null, "Evento cadastrado com sucesso!");
            }
        });

        // Ação para registrar participante
        btnRegistrarParticipante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (evento != null) {
                    if (!evento.isLotado()) {
                        String nomeParticipante = JOptionPane.showInputDialog("Digite o nome do participante:");
                        String contatoParticipante = JOptionPane.showInputDialog("Digite o contato do participante:");
                        Participante participante = new Participante(nomeParticipante, contatoParticipante);
                        evento.adicionarParticipante(participante);

                        JOptionPane.showMessageDialog(null, "Participante registrado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Evento lotado. Não é possível registrar mais participantes.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum evento cadastrado.");
                }
            }
        });

        // Ação para verificar lotação do evento
        btnVerificarLotacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (evento != null) {
                    if (evento.isLotado()) {
                        JOptionPane.showMessageDialog(null, "O evento está lotado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ainda há vagas disponíveis.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum evento cadastrado.");
                }
            }
        });

        // Ação para gerar relatório de participantes
        btnGerarRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (evento != null) {
                    evento.gerarRelatorioParticipantes();
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum evento cadastrado.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SistemaEventosGUI().setVisible(true);
            }
        });
    }
}
