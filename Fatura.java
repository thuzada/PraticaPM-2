import java.util.ArrayList;

public class Fatura {
    private ArrayList<Item> itens;

    public Fatura() {
        itens = new ArrayList<>();
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public double getValorTotal() {
        double total = 0;

        for (Item item : itens) {
            total += item.getValorTotal();
        }

        return total;
    }

    public void incluirItem(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            System.out.println("A quantidade deve ser maior que zero.");
            return;
        }

        // Se o produto já estiver na fatura, aumenta sua quantidade.
        for (Item item : itens) {
            if (item.getProduto().getCodigo() == produto.getCodigo()) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                System.out.println("Quantidade do item atualizada.");
                return;
            }
        }

        itens.add(new Item(produto, quantidade));
        System.out.println("Item adicionado à fatura.");
    }

    public boolean excluirItem(int indice) {
        if (indice >= 0 && indice < itens.size()) {
            itens.remove(indice);
            return true;
        }

        return false;
    }

    public boolean alterarItem(int indice, int novaQuantidade) {
        if (indice >= 0 && indice < itens.size()
                && novaQuantidade > 0) {

            itens.get(indice).alterarQuantidade(novaQuantidade);
            return true;
        }

        return false;
    }

    public void exibirFatura() {
        if (itens.isEmpty()) {
            System.out.println("\nA fatura está vazia.");
            return;
        }

        System.out.println("\n========== FATURA ==========");

        for (int i = 0; i < itens.size(); i++) {
            System.out.print((i + 1) + " - ");
            itens.get(i).exibirItem();
        }

        System.out.println("-----------------------------");
        System.out.printf("VALOR TOTAL: R$ %.2f%n", getValorTotal());
        System.out.println("=============================");
    }
}
