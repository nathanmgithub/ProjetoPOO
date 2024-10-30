package restaurante;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<ItemDoPedido> itens;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemDoPedido item) {
        this.itens.add(item);
    }

    public ArrayList<ItemDoPedido> getItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemDoPedido item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }
}
