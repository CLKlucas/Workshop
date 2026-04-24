package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Circulo extends ID {
	private int limite;
	private List<Contato> listaContato;

	public Circulo(String id, int limite){
        super(id);
		this.limite = limite;
		listaContato = new ArrayList<>();
	}

	public int getNumeroDeContatos() {
		return listaContato.size();
	}


	public int getLimite(){
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

	public boolean adicionarContato(Contato contato){
		if(listaContato.size() >= limite)
			return false;

		if(listaContato.contains(contato))
			return false;

		listaContato.add(contato);
		return true;
	}

	public boolean removerContato(Contato contato){

		for (int i = 0; i < listaContato.size(); i++){
			if (listaContato.get(i).getIdentificador().equals(contato.getIdentificador())){
				listaContato.remove(i);
				return true;
			}
		}
		return false;
	}
	public List<Contato> getListaContato() {
		listaContato.sort(Comparator.comparing(Contato::getIdentificador));
		return listaContato;
	}

	public boolean temContato(Contato contato){
		if(listaContato.contains(contato)){
			return true;
		}
		return false;
	}
}
