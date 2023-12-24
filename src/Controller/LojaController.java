package Controller;

import entities.Loja;
import entities.Manga;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LojaController {
    Scanner scanner = new Scanner(System.in);
    private Loja loja = new Loja();

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public void exibirMenu(){
        System.out.println("--- Bem vindo à loja de vendas de mangá ---");
        System.out.println("O que você deseja fazer?)");
        System.out.println("1-(Exibir o estoque atual)");
        System.out.println("2-(Pesquisar mangá pelo ID)");
        System.out.println("3-(Adicionar um mangá à loja)");
        System.out.println("4-(Remover um mangá)");
        System.out.println("5-(Atualizar dados do mangá)");
        System.out.println("6-(Atualizar o estoque do mangá)");
        System.out.println("7-(Encerrar o programa)");
        System.out.println();
        System.out.println("Escolha uma opção");
    }

    public void escolhaOpcao(int escolha){
        int id =0;
        try {
            switch(escolha){
                case 1:
                    loja.exibirEstoque();
                    break;
                case 2:
                    try{
                        String resposta="";
                        do{
                            System.out.println("Digite o ID do mangá que deseja pesquisar");
                            if(scanner.hasNextInt()){
                                id=scanner.nextInt();
                                loja.pesquisarMangaID(id);
                                scanner.nextLine();
                            }else{
                                scanner.nextLine();
                            }
                            System.out.println("Deseja realizar outra pesquisa?");
                            resposta = scanner.nextLine();
                        }while(!resposta.equalsIgnoreCase("não"));
                        scanner.nextLine();
                    }catch (InputMismatchException e){
                        System.out.println("Entrada inválida, por favor digite apenas números");
                    }
                    break;
                case 3:
                    try{
                        System.out.println("Digite o nome do mangá");
                        String nome = scanner.nextLine();

                        System.out.println("Digite o preço do mangá");
                        double preco = scanner.nextDouble();
                        loja.adicionarManga(nome,preco);
                        scanner.nextLine();
                    }catch (InputMismatchException e){
                        System.out.println("Entrada inválida por favor digite apenas números");
                    }
                    break;
                case 4:
                    try{
                        loja.exibirEstoque();
                        System.out.println("Digite o id do mangá que deseja remover");
                        id= scanner.nextInt();
                        loja.removerMangaId(id);
                        scanner.nextLine();
                    }catch (InputMismatchException e){
                        System.out.println("Entrada inválida, por favor digite apenas números");
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Digite o Id do mangá a ser atualizado");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite um nome para o mangá");
                        String nome = scanner.nextLine();
                        System.out.println("Digite um preço para o mangá");
                        double preco = scanner.nextDouble();
                        loja.atualizarManga(nome,preco);
                    }catch (InputMismatchException e){
                        System.out.println("Entrada inválida, por favor digite apenas números.");
                    }
                    break;
                case 6:
                    try {
                        System.out.println("Digite o Id do mangá a ser atualizado");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite um número de estoque que o mangá terá agora");
                        int estoque = scanner.nextInt();
                        scanner.nextLine();
                        loja.atualizarEstoqueManga(id,estoque);
                    }catch (InputMismatchException e){
                        System.out.println("Entrada inválida, por favor digite apenas números.");
                    }
                    break;
                case 7:
                    System.out.println("Programa encerrado");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }catch (InputMismatchException e){
            System.out.println("Você digitou uma entrada incompatível, por favor insira somente números");
            scanner.nextLine();
        }
    }

}
