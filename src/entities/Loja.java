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

    }

    public Manga pesquisarManga(Integer id){
        for(Manga aux: mangas){
            if(aux.getId()==id){
                return aux;
            }
        }
        return null;
    }

    public void removerMangaId(Integer id){
        for(Manga aux: mangas){
            if(aux.getId()==id){
                int num =1;
                aux.setEstoque(aux.getEstoque()-1);
                this.estoqueDaLoja--;
            }
        }
    }

    @Override
    public String toString() {
        return "Loja{" +
                "estoque=" + estoqueDaLoja +
                ", mangas=" + mangas +
                '}';
    }
}
