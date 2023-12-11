package Controller;

import entities.Manga;

import java.util.ArrayList;

public class MangaController {
    ArrayList<Manga> mangas = new ArrayList<Manga>();


    public void adicionarManga(String nome, Integer id, double preco){
        Manga auxManga = new Manga(nome, id, preco);
        mangas.add(auxManga);
    }

    public Manga pesquisarManga(Integer id){
        return mangas.get(id);
    }


}
