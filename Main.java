import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Produtos cadastrados pela loja
        ArrayList<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Teclado", 101, 89.90));
        produtos.add(new Produto("Mouse", 102, 49.90));
        produtos.add(new Produto("Monitor", 103, 799.90));

        Fatura fatura = new Fatura();

        int opcao;

        do {
            System.out.println("\n========== LOJA ==========");
            System.out.println("1 - Comprar");
            System.out.println("2 - Ver Fatura");
            System.out.println("3 - Excluir item");
            System.out.println("4 - Alterar item");
            System.out.println("5 - Finalizar");
            System.out.println("==========================");

            opcao = lerInteiro(scanner, "Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    comprar(scanner, produtos, fatura);
                    break;

                case 2:
                    fatura.exibirFatura();
                    break;

                case 3:
                    excluirItem(scanner, fatura);
                    break;

                case 4:
                    alterarItem(scanner, fatura);
                    break;

                case 5:
                    System.out.println("\nCompra finalizada!");
                    fatura.exibirFatura();
                    System.out.printf(
                        "Valor final da compra: R$ %.2f%n",
                        fatura.getValorTotal()
                    );
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 5);

        scanner.close();
    }

    // Menu de compra
    public static void comprar(
            Scanner scanner,
            ArrayList<Produto> produtos,
            Fatura fatura) {

        System.out.println("\n========== PRODUTOS ==========");

        for (Produto produto : produtos) {
            produto.exibirProduto();
        }

        System.out.println("0 - Voltar");

        int codigo = lerInteiro(
            scanner,
            "Digite o código do produto: "
        );

        if (codigo == 0) {
            return;
        }

        Produto produtoEncontrado = null;

        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                produtoEncontrado = produto;
                break;
            }
        }

        if (produtoEncontrado == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        int quantidade = lerInteiro(
            scanner,
            "Digite a quantidade: "
        );

        if (quantidade <= 0) {
            System.out.println("Quantidade inválida.");
            return;
        }

        fatura.incluirItem(produtoEncontrado, quantidade);
    }

    // Menu de exclusão
    public static void excluirItem(
            Scanner scanner,
            Fatura fatura) {

        if (fatura.getItens().isEmpty()) {
            System.out.println("\nA fatura está vazia.");
            return;
        }

        System.out.println("\n========== EXCLUIR ITEM ==========");

        for (int i = 0; i < fatura.getItens().size(); i++) {
            System.out.print((i + 1) + " - ");
            fatura.getItens().get(i).exibirItem();
        }

        System.out.println("0 - Voltar");

        int opcao = lerInteiro(
            scanner,
            "Escolha o item que deseja excluir: "
        );

        if (opcao == 0) {
            return;
        }

        if (fatura.excluirItem(opcao - 1)) {
            System.out.println("Item excluído com sucesso.");
        } else {
            System.out.println("Item inválido.");
        }
    }

    // Menu de alteração
    public static void alterarItem(
            Scanner scanner,
            Fatura fatura) {

        if (fatura.getItens().isEmpty()) {
            System.out.println("\nA fatura está vazia.");
            return;
        }

        System.out.println("\n========== ALTERAR ITEM ==========");

        for (int i = 0; i < fatura.getItens().size(); i++) {
            System.out.print((i + 1) + " - ");
            fatura.getItens().get(i).exibirItem();
        }

        System.out.println("0 - Voltar");

        int opcao = lerInteiro(
            scanner,
            "Escolha o item que deseja alterar: "
        );

        if (opcao == 0) {
            return;
        }

        int novaQuantidade = lerInteiro(
            scanner,
            "Digite a nova quantidade: "
        );

        if (fatura.alterarItem(opcao - 1, novaQuantidade)) {
            System.out.println("Item alterado com sucesso.");
        } else {
            System.out.println(
                "Item inválido ou quantidade incorreta."
            );
        }
    }

    // Método auxiliar para leitura de inteiros
    public static int lerInteiro(
            Scanner scanner,
            String mensagem) {

        while (true) {
            System.out.print(mensagem);

            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(
                    "Digite um número inteiro válido."
                );
            }
        }
    }
}
