import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contato {
    private List<Fone> listaFones;
    private String nome;


    public Contato(String name){
        this.nome = name;
        listaFones = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeFones(){
        return listaFones.size();
    }

    public List<Fone> getFones() {
        return listaFones;
    }

    public boolean adicionarFone(Fone fone){
        if(!Fone.eValido(fone.getNumero()))
            return false;

        for (int i = 0;i < listaFones.size();i++){
            if(listaFones.get(i).getNumero().equals(fone.getNumero()))
                return false;
        }

        listaFones.add(fone);
        return true;
    }

    public boolean removerFone(int index) {
        for (int i = 0; i < listaFones.size(); i++) {
            if (i == index) {
                listaFones.remove(i);
                return true;
            }
        }
    return false;
    }
}
