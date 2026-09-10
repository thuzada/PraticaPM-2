public class Produto {
    private String nome;
    private String codigo;
    private double preco;

    public Produto (String nome, String codigo, double preco){
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }

    public String getCodigo(){
        return codigo;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco(){
        return preco;
    }
}
