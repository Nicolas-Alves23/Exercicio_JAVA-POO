package Desafio;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Item> itens = new ArrayList<>();

    public void adicionarProduto(Produto produto, int quantidade) {
        // Se já existir, soma a quantidade
        for (Item item : itens) {
            if (item.getProduto().getNome().equals(produto.getNome())) {
                item.adicionarQuantidade(quantidade);
                return;
            }
        }
        // Se não existir, adiciona um novo item
        itens.add(new Item(produto, quantidade));
    }

    public void removerProduto(String nomeProduto) {
        itens.removeIf(item -> item.getProduto().getNome().equalsIgnoreCase(nomeProduto));
    }

    public double calcularTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        return total;
    }

    public void mostrarResumo() {
        System.out.println("Resumo do Carrinho:");
        for (Item item : itens) {
            System.out.println(item.getProduto().getNome() + " - R$" + item.getProduto().getPreco() +
                    " x " + item.getQuantidade());
        }
        System.out.println("Total: R$" + calcularTotal());
    }

    private class Item {
        private Produto produto;
        private int quantidade;

        public Item(Produto produto, int quantidade) {
            this.produto = produto;
            this.quantidade = quantidade;
        }

        public Produto getProduto() {
            return produto;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void adicionarQuantidade(int qtd) {
            this.quantidade += qtd;
        }
    }
}

