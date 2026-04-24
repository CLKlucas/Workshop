import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Agenda {
   private List<Contato> listaContato = new ArrayList<>();

    public List<Contato> getContatos() {
        listaContato.sort(Comparator.comparing(Contato::getNome));
        return listaContato;
    }

    public int getQuantidadeDeContatos() { return listaContato.size(); }

    public Contato getContato(String name){
        for(int i = 0;i < listaContato.size(); i++){

            if(listaContato.get(i).getNome().equals(name))
                return listaContato.get(i);

        }
        return null;
    }

    public boolean adicionarContato(Contato contato) {
        if(contato.getFones().isEmpty())
            return false;

        //Bruno, se o senhor tiver já visto esse código na versão anterior, vai concordar que agora
        // está bem melhor, o for padrão nesse metodo ficou medonho, demorei um pouquinho para alterar para
        //o for-each pq não tenho o costume de usar ele, mas ficou bem mais legivel, os outros vão ficar
        //com o for padrão mesmo pq não estavam tão grande e ilegivel como esse estava.

        for (Contato contatosDaLista : listaContato){

            if (contatosDaLista.getNome().equals(contato.getNome())){

                for(Fone contatoFone : contato.getFones()){
                    boolean repetido = false;

                    for(Fone listaFone : contatosDaLista.getFones()){

                        if(contatoFone.getNumero().equals(listaFone.getNumero())){
                            repetido = true;
                        }

                    }
                    if(!repetido){
                        contatosDaLista.adicionarFone(contatoFone);
                    }
                }
                return false;
            }
        }
        listaContato.add(contato);
        return true;
    }

    public boolean removerContato(String name){
        for (int i = 0;i < listaContato.size();i++){
            if(listaContato.get(i).getNome().equals(name)){
                listaContato.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removerFone(String name, int index){

        for (int i = 0;i < listaContato.size();i++) {

            if (listaContato.get(i).getNome().equals(name)) {
                for (int fones = 0; fones < listaContato.get(i).getFones().size(); fones++) {
                    if (fones == index) {

                        listaContato.get(i).getFones().remove(index);
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public int getQuantidadeDeFones(Tipo tipo){
        int contador = 0;
        for (int i = 0;i < listaContato.size();i++){
            for(int fones = 0; fones < listaContato.get(i).getFones().size();fones++){
                if(listaContato.get(i).getFones().get(fones).getTipo().equals(tipo)){
                    contador++;
                }
            }
        }
        return contador;
    }

    public int getQuantidadeDeFones(){
        int contador = 0;
        for (int i = 0;i < listaContato.size();i++) {
            for (int fones = 0; fones < listaContato.get(i).getFones().size(); fones++) {
                contador++;
            }
        }
            return contador;
    }

    public List<Contato> pesquisar(String expressao) {
        List<Contato> listaPesquisa = new ArrayList<>();
        for (int i = 0;i < listaContato.size();i++) {
            if (listaContato.get(i).getNome().toUpperCase().contains(expressao.toUpperCase())) {
                listaPesquisa.add(listaContato.get(i));
            }
            else {
                for (int fones = 0; fones < listaContato.get(i).getFones().size(); fones++) {
                    if (listaContato.get(i).getFones().get(fones).getNumero().contains(expressao)) {
                        listaPesquisa.add(listaContato.get(i));

                    }
                }
            }
        }
        listaPesquisa.sort(Comparator.comparing(Contato::getNome));
        return listaPesquisa;
    }


}