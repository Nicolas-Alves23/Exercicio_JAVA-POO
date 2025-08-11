package Desafio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Criar cliente
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = sc.nextLine();
        System.out.print("Digite o e-mail do cliente: ");
        String emailCliente = sc.nextLine();

        Cliente cliente = new Cliente(nomeCliente, emailCliente);
        cliente.mostrarDados();

        // Criar carrinho
        Carrinho carrinho = new Carrinho();

        // Adicionar produtos
        System.out.print("\nQuantos produtos deseja adicionar? ");
        int qtdProdutos = sc.nextInt();
        sc.nextLine(); // limpar quebra de linha

        for (int i = 1; i <= qtdProdutos; i++) {
            System.out.println("\nProduto " + i + ":");
            System.out.print("Nome: ");
            String nomeProduto = sc.nextLine();
            System.out.print("Preço: ");
            double preco = sc.nextDouble();
            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();
            sc.nextLine(); // limpar quebra de linha

            Produto produto = new Produto(nomeProduto, preco);
            carrinho.adicionarProduto(produto, quantidade);
        }

        // Mostrar resumo antes do desconto
        System.out.println("\nResumo do carrinho (antes do desconto):");
        carrinho.mostrarResumo();

        // Aplicar desconto
        System.out.print("\nDigite o nome do produto para aplicar desconto: ");
        String nomeDesconto = sc.nextLine();
        System.out.print("Digite o percentual de desconto: ");
        double percentual = sc.nextDouble();
        sc.nextLine();

        // Aplicando desconto no produto correspondente
        carrinho.aplicarDesconto(nomeDesconto, percentual);

        System.out.println("\nDepois do desconto:");
        carrinho.mostrarResumo();

        // Remover produto
        System.out.print("\nDigite o nome do produto para remover: ");
        String nomeRemover = sc.nextLine();
        carrinho.removerProduto(nomeRemover);

        System.out.println("\nDepois de remover o produto:");
        carrinho.mostrarResumo();

        sc.close();
    }
}
