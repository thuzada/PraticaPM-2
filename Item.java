public class Item {
    Produto produto;
    int quantidade;
    int valorItem;


    public Item(Produto produto, int quantidade, int valor){
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorItem = valor;
    }

    public Produto getProduto(){
        return produto;
    }

    public int getQuantidadeItem(){
        return quantidade;
    }

    public int getValorItem(){
        return valorItem;
    }

    public void mostrarInformaçoes(){
        System.out.println("Nome: \t" + this.produto.getNome() + "Preço: \t" + this.produto.getPreco() + "Quantidade: \t" + this.getQuantidadeItem() );
    }

}
