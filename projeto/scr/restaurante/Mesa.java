package restaurante;

import java.util.ArrayList;

public class Mesa {
    private int numero;
    private boolean ocupada;
    private ArrayList<Pedido> pedidos;

    public Mesa(int numero) {
        this.numero = numero;
        this.ocupada = false;
        this.pedidos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void adicionarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public double calcularTotal() {
        double total = 0;
        for (Pedido pedido : pedidos) {
            total += pedido.calcularTotal();
        }
        return total;
    }

    public void fecharConta() {
        System.out.println("Total a pagar para a Mesa " + numero + ": R$" + calcularTotal());
        pedidos.clear();
        setOcupada(false);
    }
}
