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

    public void pesquisarMangaID(Integer id){
        for(Manga aux: mangas){
            if(aux.getId()==id){
                System.out.println(aux.toString());
            }else{
                System.out.println("Nenhum mangá com esse Id foi encontrado no estoque.");
            }
        }
    }
    public void exibirEstoque(){
        System.out.println(toString());
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

    public void atualizarManga(String nome, Integer id, double preco){
        Manga auxManga = new Manga(nome,id,preco);
        for(Manga aux: mangas){
            if(aux.getId()==auxManga.getId()){
                aux.setNome(auxManga.getNome());
                aux.setPreco(auxManga.getPreco());
                System.out.println("O mangá de id:"+aux.getId()+" foi atualizado!");
                break;
            }else{
                System.out.println("O ID não coincide com os IDs dos mangás no estoque.");
            }
        }
    }
    public void atualizarEstoqueManga(Integer id, int estoque){
        for(Manga aux: mangas){
            int diferencaEstoque=0;
                diferencaEstoque = estoque - aux.getEstoque() ;
            if(aux.getId()==id){
                aux.setEstoque(estoque);
                this.estoqueDaLoja +=diferencaEstoque;
                break;
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
