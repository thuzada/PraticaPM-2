public class Main {


    public void comprar(String codigo, Item item){
        if(item.produto.getCodigo().equals(codigo)){
            System.out.print("Codigo: " + item.produto.getCodigo() + "\n"+"Quantidade:" + item.getQuantidadeItem());
        }
        else{
            System.out.println("Produto não encontrado");
        }
    }

    public void verFatura(Fatura fatura){
        for (Item item : fatura.itens) {
        item.mostrarInformaçoes();
        }
    }

    
    public static void main(String[] args) {
    
        Produto produto = new Produto("arroz", "1", 12.99);
        Produto produto2 = new Produto("feijão", "2", 23.98);
        Produto produto3 = new Produto("frango", "3", 15.99);

        
    }
}
