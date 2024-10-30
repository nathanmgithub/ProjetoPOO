package restaurante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SistemaRestauranteGUI extends JFrame {
    private Mesa mesa;

    public SistemaRestauranteGUI() {
        setTitle("Gerenciamento de Pedidos - Restaurante");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        mesa = new Mesa(1); // Exemplo de mesa número 1

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 1));

        JButton btnAdicionarPedido = new JButton("Adicionar Pedido");
        JButton btnFecharConta = new JButton("Fechar Conta");

        painel.add(btnAdicionarPedido);
        painel.add(btnFecharConta);

        add(painel, BorderLayout.CENTER);

        // Ação para adicionar pedido
        btnAdicionarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeItem = JOptionPane.showInputDialog("Digite o nome do item:");
                double precoItem = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do item:"));
                int quantidadeItem = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade:"));

                ItemDoPedido item = new ItemDoPedido(nomeItem, precoItem, quantidadeItem);
                Pedido pedido = new Pedido();
                pedido.adicionarItem(item);
                mesa.adicionarPedido(pedido);

                JOptionPane.showMessageDialog(null, "Pedido adicionado com sucesso!");
            }
        });

        // Ação para fechar conta
        btnFecharConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mesa.fecharConta();
                JOptionPane.showMessageDialog(null, "Conta fechada.");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SistemaRestauranteGUI().setVisible(true);
            }
        });
    }
}

