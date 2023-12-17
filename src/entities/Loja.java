package entities;

import java.util.ArrayList;

public class Loja {
    private int estoqueDaLoja;

    public Loja(){}

    public int getEstoque() {
        return estoqueDaLoja;
    }

    public void setEstoque(int estoque) {
        this.estoqueDaLoja = estoque;
    }

    ArrayList<Manga> mangas = new ArrayList<Manga>();


    public void adicionarManga(String nome, Integer id, double preco){
        Manga auxManga = new Manga(nome, id, preco);
        /*Se os parâmetros forem iguais, apenas "estoque" será
        * Acrescentado*/
        boolean confirmarManga= false;
        if(mangas.contains(auxManga)){
            Manga mangaExistente = mangas.get(mangas.indexOf(auxManga));
            mangaExistente.setEstoque(mangaExistente.getEstoque() + auxManga.getEstoque());
        } else{
            mangas.add(auxManga);
        }

        this.estoqueDaLoja++;

        /*Varra o array para adicionar ao estoque do mangá
        * caso a inserção do usuário corresponada ha um que já existe*/
    }

    public Manga pesquisarManga(Integer id){
        return mangas.get(id);
    }

    public void removerMangaId(Integer id){
        mangas.remove(id);
    }

    @Override
    public String toString() {
        return "Loja{" +
                "estoque=" + estoqueDaLoja +
                ", mangas=" + mangas +
                '}';
    }
}
