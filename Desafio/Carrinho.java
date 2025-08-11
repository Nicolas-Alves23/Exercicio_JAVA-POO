package Desafio;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Item> itens = new ArrayList<>();

    public void adicionarProduto(Produto produto, int quantidade) {
        // Se já existir, soma a quantidade
        for (Item item : itens) {
            if (item.getProduto().getNome().equalsIgnoreCase(produto.getNome())) {
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
            System.out.println(item.getProduto().getNome() + " - R$"
                    + String.format("%.2f", item.getProduto().getPreco()) +
                    " x " + item.getQuantidade());
        }
        System.out.println("Total: R$" + String.format("%.2f", calcularTotal()));
    }

    // Novo método para aplicar desconto em um produto pelo nome
    public void aplicarDesconto(String nomeProduto, double percentual) {
        for (Item item : itens) {
            if (item.getProduto().getNome().equalsIgnoreCase(nomeProduto)) {
                item.getProduto().aplicarDesconto(percentual);
                System.out.println("Desconto de " + percentual + "% aplicado em " + nomeProduto);
                return;
            }
        }
        System.out.println("Produto não encontrado no carrinho.");
    }

    // Classe interna para armazenar produto + quantidade
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
