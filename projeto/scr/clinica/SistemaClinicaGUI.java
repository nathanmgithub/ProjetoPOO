package clinica;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class SistemaClinicaGUI extends JFrame {
    private ArrayList<Paciente> pacientes;
    private ArrayList<Medico> medicos;

    public SistemaClinicaGUI() {
        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();

        // Configuração básica da janela
        setTitle("Sistema de Gerenciamento de Clínica");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        // Botão para cadastrar pacientes
        JButton btnCadastrarPaciente = new JButton("Cadastrar Paciente");
        btnCadastrarPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarPaciente();
            }
        });

        // Botão para cadastrar médicos
        JButton btnCadastrarMedico = new JButton("Cadastrar Médico");
        btnCadastrarMedico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarMedico();
            }
        });

        // Botão para exibir pacientes e médicos
        JButton btnExibirDados = new JButton("Exibir Pacientes e Médicos");
        btnExibirDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirDados();
            }
        });


        JButton btnAgendarConsulta = new JButton("Agendar Consulta");
        btnAgendarConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agendarConsulta();
            }
        });
        


        
        // Adiciona os botões ao layout da janela
        add(btnCadastrarPaciente);
        add(btnCadastrarMedico);
        add(btnExibirDados);
        add(btnAgendarConsulta);
    }

    // Método para cadastrar um paciente
    private void cadastrarPaciente() {
        String nomePaciente = JOptionPane.showInputDialog("Digite o nome do paciente:");
        String contatoPaciente = JOptionPane.showInputDialog("Digite o contato do paciente:");
        String cpfPaciente = JOptionPane.showInputDialog("Digite o CPF do paciente:");
        int idadePaciente = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do paciente:"));

        Paciente paciente = new Paciente(nomePaciente, contatoPaciente, cpfPaciente, idadePaciente);
        pacientes.add(paciente);

        JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
    }

    // Método para cadastrar um médico
    private void cadastrarMedico() {
        String nomeMedico = JOptionPane.showInputDialog("Digite o nome do médico:");
        String especialidadeMedico = JOptionPane.showInputDialog("Digite a especialidade do médico:");
        String crmMedico = JOptionPane.showInputDialog("Digite o CRM do médico:");
        boolean disponivel = JOptionPane.showConfirmDialog(null, "Médico está disponível?") == JOptionPane.YES_OPTION;

        Medico medico = new Medico(nomeMedico, especialidadeMedico, crmMedico, disponivel);
        medicos.add(medico);

        JOptionPane.showMessageDialog(null, "Médico cadastrado com sucesso!");
    }



    private void agendarConsulta() {
        // Verifica se há pacientes e médicos cadastrados
        if (pacientes.isEmpty() || medicos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum paciente ou médico cadastrado.");
            return;
        }
    
        // Seleciona paciente entre os já cadastrados
        String nomePaciente = JOptionPane.showInputDialog("Nome do Paciente para agendar a consulta:");
        Paciente pacienteSelecionado = null;
        for (Paciente p : pacientes) {
            if (p.getNome().equalsIgnoreCase(nomePaciente)) {
                pacienteSelecionado = p;
                break;
            }
        }
    
        // Se não encontrar o paciente
        if (pacienteSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Paciente não encontrado.");
            return;
        }
    
        // Seleciona médico entre os já cadastrados
        String crmMedico = JOptionPane.showInputDialog("CRM do Médico para agendar a consulta:");
        Medico medicoSelecionado = null;
        for (Medico m : medicos) {
            if (m.getCrm().equalsIgnoreCase(crmMedico)) {
                medicoSelecionado = m;
                break;
            }
        }
    
        // Se não encontrar o médico
        if (medicoSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Médico não encontrado.");
            return;
        }
    
        // Define a data da consulta (exemplo: data atual)
        Date dataConsulta = new Date();
        Consulta consulta = new Consulta(pacienteSelecionado, medicoSelecionado, dataConsulta);
    
        // Adiciona a consulta à lista de consultas
        consulta.add(consulta);
    
        JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso!");
    }
    
    

    // Método para exibir os dados dos pacientes e médicos
    private void exibirDados() {
        StringBuilder dadosPacientes = new StringBuilder("Pacientes cadastrados:\n");
        for (Paciente paciente : pacientes) {
            dadosPacientes.append("Nome: ").append(paciente.getNome()).append(", ")
                          .append("Contato: ").append(paciente.getContato()).append(", ")
                          .append("CPF: ").append(paciente.getCpf()).append(", ")
                          .append("Idade: ").append(paciente.getIdade()).append("\n");
        }

        StringBuilder dadosMedicos = new StringBuilder("Médicos cadastrados:\n");
        for (Medico medico : medicos) {
            dadosMedicos.append("Nome: ").append(medico.getNome()).append(", ")
                        .append("Especialidade: ").append(medico.getEspecialidade()).append(", ")
                        .append("CRM: ").append(medico.getCrm()).append(", ")
                        .append("Disponível: ").append(medico.isDisponivel() ? "Sim" : "Não").append("\n");
        }

        JOptionPane.showMessageDialog(null, dadosPacientes.toString() + "\n" + dadosMedicos.toString());
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SistemaClinicaGUI gui = new SistemaClinicaGUI();
                gui.setVisible(true);
            }
        });
    }
}
