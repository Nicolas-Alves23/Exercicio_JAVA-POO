package Desafio;

public class Main {
    public static void main(String[] args) {
        // Criar cliente
        Cliente cliente = new Cliente("Maria Silva", "maria@email.com");
        cliente.mostrarDados();

        // Criar produtos
        Produto p1 = new Produto("Camiseta", 50);
        Produto p2 = new Produto("Calça", 120);
        Produto p3 = new Produto("Tênis", 200);

        // Criar carrinho e adicionar produtos
        Carrinho carrinho = new Carrinho();
        carrinho.adicionarProduto(p1, 2);
        carrinho.adicionarProduto(p2, 1);
        carrinho.adicionarProduto(p3, 1);

        // Mostrar resumo antes do desconto
        carrinho.mostrarResumo();

        // Aplicar desconto em um produto (exemplo: 10% em "Calça")
        p2.aplicarDesconto(10);

        System.out.println("\nDepois do desconto:");

        // Mostrar resumo depois do desconto
        carrinho.mostrarResumo();

        // Remover produto pelo nome (exemplo: remover "Camiseta")
        carrinho.removerProduto("Camiseta");

        System.out.println("\nDepois de remover a Camiseta:");
        carrinho.mostrarResumo();
    }
}

