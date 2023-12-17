package entities;

public class Manga extends Produto{

    public Manga() {
        super();
    }
    public Manga(String nome, Integer id, double preco){
        this.setNome(nome);
        this.setId(id);
        this.setPreco(preco);
        this.setEstoque(+1);
    }

    @Override
    public String toString() {

        return "nome: "+ getNome() +" Id:"+getId()+" Preço R$:"+getPreco()+ " estoque: "+getEstoque()+"\n";

    }

}
