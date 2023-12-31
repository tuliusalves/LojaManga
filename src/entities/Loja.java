package entities;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Loja {
    private int estoqueDaLoja;
    static int proximoId=0;
    public Loja(){
        proximoId =1;
    }

    public int getEstoque() {
        return estoqueDaLoja;
    }

    public void setEstoque(int estoque) {
        this.estoqueDaLoja = estoque;
    }

    static ArrayList<Manga> mangas = new ArrayList<Manga>();


    public static int gerarIdAutomatico(){
        for(Manga aux: mangas){
            if(aux.getId()==proximoId){
                proximoId++;
                return gerarIdAutomatico();
            }
        }
        return proximoId;
    }
    public void adicionarManga(String nome,  double preco){

        Manga auxManga = new Manga(nome, preco);
        /*Se os parâmetros forem iguais, apenas "estoque" será
        * Acrescentado*/
            auxManga.setId(gerarIdAutomatico());
            if(proximoId == auxManga.getId()){
                Manga mangaExistente = auxManga;
                mangaExistente.setEstoque(mangaExistente.getEstoque() + auxManga.getEstoque()-1);
                mangas.add(mangaExistente);
            }

        System.out.println("O mangá ( ID:"+ auxManga.getId()+" nome:"+nome+ " R$"+preco+ " ) foi adicionado!");
        this.estoqueDaLoja++;

    }

    public void pesquisarMangaID(Integer id){
        for(Manga aux: mangas){
            if(aux.getId()==id){
                System.out.println(aux.toString());
            }else if( aux.getId()!=id ){
                System.out.println("Nenhum mangá com esse Id foi encontrado no estoque.");
            }
        }
    }
    public void exibirEstoque(){
        System.out.println(toString());
    }

    public void removerMangaId(Integer id){
        try {
            for (Manga aux : mangas) {
                if (aux.getId() == id) {
                    int num = 1;
                    aux.setEstoque(aux.getEstoque() - 1);
                    this.estoqueDaLoja--;
                    System.out.println("Mangá de ID:"+id+" foi removido com sucesso!");
                    break;
                }
            }
        }catch (NoSuchElementException e){
            System.out.println("Id não encontrado");
        }
    }

    public void atualizarManga(String nome, double preco){
        Manga auxManga = new Manga(nome,preco);
        boolean mangaAchado=true;
        for(Manga aux: mangas){
            if(aux.getId()==auxManga.getId()){
                aux.setNome(auxManga.getNome());
                aux.setPreco(auxManga.getPreco());
                System.out.println("O mangá de id:"+aux.getId()+" foi atualizado!");
                mangaAchado=true;
            }else{
                mangaAchado=false;
            }
        }
        if(!mangaAchado){
            System.out.println("O ID não coincide com os IDs dos mangás no estoque.");
        }
    }
    public void atualizarEstoqueManga(Integer id, int estoque){
        for(Manga aux: mangas){
            int diferencaEstoque = estoque - aux.getEstoque() ;
            boolean mangaAchado= true;
            if(aux.getId()==id){
                aux.setEstoque(estoque);
                this.estoqueDaLoja +=diferencaEstoque;
                mangaAchado=true;
                System.out.println("O mangá de ID:"+id+"Foi atualizado");
                break;
            }else{
                mangaAchado=false;
            }
            if(!mangaAchado==true){
                System.out.println("O ID não coincide com os IDs dos mangás no estoque.");
            }
        }
    }

    @Override
    public String toString() {
        return " [estoque da loja=" + estoqueDaLoja +
                "] {\n mangas=" + mangas +
                '}';
    }
}
