import Controller.LojaController;
import entities.Loja;
import entities.Manga;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();
        LojaController lojaController = new LojaController();
        Scanner scan = new Scanner(System.in);
        int opcao=0;
        String resposta="";
       /* loja.adicionarManga("Naruto", 1, 10.20);
        loja.adicionarManga("Naruto", 1, 10.20);
        loja.adicionarManga("DB", 2, 10.20);
        loja.adicionarManga("DB", 2, 10.20);

       System.out.println(loja.pesquisarManga(3));
        System.out.println(loja.toString());

        loja.removerMangaId(1);
        loja.removerMangaId(1);

        System.out.println(loja.toString());*/
        lojaController.setLoja(loja);
        do {
            try {
                lojaController.exibirMenu();

                    opcao =scan.nextInt();
                    scan.nextLine();
                    lojaController.escolhaOpcao(opcao);
                    /*
                    System.out.println("Deseja continuar a operação?");
                    resposta= scan.nextLine();
                    scan.nextLine();*/
                    /*if (!resposta.equalsIgnoreCase("sim")){
                        opcao=8;
                    }*/

            }catch (InputMismatchException e){
                System.out.println("Entrada inválida. Por favor insira uma opção");
                scan.nextLine();
            }

        }while (opcao!=7);

        scan.close();
    }
}