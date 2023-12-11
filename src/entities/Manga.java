package entities;

public class Manga extends Produto{
    public Manga() {
    }
    public Manga(String nome, Integer id, double preco){
        this.setNome(nome);
        this.setId(id);
        this.setPreco(preco);
    }

    @Override
    public String toString() {
        return "Manga{}";
    }
}
