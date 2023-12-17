import entities.Loja;
import entities.Manga;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();

        loja.adicionarManga("Naruto", 1, 10.20);
        loja.adicionarManga("Naruto", 1, 10.20);
        loja.adicionarManga("DB", 2, 10.20);
        loja.adicionarManga("DB", 2, 10.20);

        System.out.println(loja.toString());
    }
}