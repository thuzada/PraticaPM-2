public class Item {
    private Produto produto;
    private int quantidade;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return produto.getPreco() * quantidade;
    }

    public void alterarQuantidade(int novaQuantidade) {
        if (novaQuantidade > 0) {
            this.quantidade = novaQuantidade;
        }
    }

    public void exibirItem() {
        System.out.printf(
            "Código: %d | Produto: %s | Quantidade: %d | " +
            "Preço unitário: R$ %.2f | Total: R$ %.2f%n",
            produto.getCodigo(),
            produto.getNome(),
            quantidade,
            produto.getPreco(),
            getValorTotal()
        );
    }
}
