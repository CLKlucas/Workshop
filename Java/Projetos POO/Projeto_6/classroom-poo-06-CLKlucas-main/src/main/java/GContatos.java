import model.Circulo;
import model.Contato;
import contrato.*;
import exceptions.CirculoNotFoundException;
import exceptions.ContatoNotFoundException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GContatos implements ContatosManager, CirculosManager, OperadorCirculoContato {
	private List<Contato> listaContato = new ArrayList<>();
	private List<Circulo> listaCirculos = new ArrayList<>();

	// ESSA FOI A ATIVIDADE MAIS DIFICIL QUE EU JÁ FIZ NESSE 1 ANO DE FACULDADE,ESTOU MUITO ORGULHOSO QUE CONSEGUI
	// DEIXAR TUDO VERDE, PROFESSOR FEZ A BOA TIRANDO AS MINHAS DUVIDAS MAIS CEDO, TERMINEI EXATAMENTE
	// 22:08 do dia 19/02/25, PASSEI O DIA INTEIRO FAZENDO ESSE PROJETO

	@Override
	public boolean criarCirculo(String id, int limite) {

		for(int i = 0;i < listaCirculos.size();i++){
			if(listaCirculos.get(i).getIdentificador().equals(id))
				return false;
		}
		listaCirculos.add(new Circulo(id,limite));
		return true;
	}

	@Override
	public boolean atualizarCirculo(Circulo circulo) {
		if(circulo.getLimite() <= 0)
			return false;

		for (int i = 0; i < listaCirculos.size(); i++) {
			if (listaCirculos.get(i).getIdentificador().equals(circulo.getIdentificador())) {
				listaCirculos.get(i).setLimite(circulo.getLimite());
				return true;
			}
		}
		return false;
	}


	@Override
	public Circulo getCirculo(String idCirculo) {
		for(int i = 0;i < listaCirculos.size();i++){
			if(listaCirculos.get(i).getIdentificador().equals(idCirculo)){
				return listaCirculos.get(i);
			}
		}
		return null;
	}

	@Override
	public List<Circulo> getTodosCirculos() {
		listaCirculos.sort(Comparator.comparing(Circulo::getIdentificador));
		return listaCirculos;

	}

	@Override
	public boolean removerCirculo(String idCirculo) {
		for(int i = 0;i < listaCirculos.size();i++){
			if(listaCirculos.get(i).getIdentificador().equals(idCirculo)){
				listaCirculos.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public int getNumeroDeCirculos() {
		return listaCirculos.size();
	}

	@Override
	public boolean criarContato(String id, String email) {
		for(int i = 0;i < listaContato.size();i++){
			if(listaContato.get(i).getIdentificador().equals(id)){
				return false;
			}
		}
		listaContato.add(new Contato(id, email));
		return true;
	}


	@Override
	public List<Contato> getTodosContatos() {
		listaContato.sort(Comparator.comparing(Contato::getIdentificador));
		return listaContato;
	}

	@Override
	public boolean atualizarContato(Contato contato) {
		for (int i = 0; i < listaContato.size(); i++) {
			if (listaContato.get(i).getIdentificador().equals(contato.getIdentificador())) {
				listaContato.get(i).setEmail(contato.getEmail());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removerContato(String id) {

		for (int circulos = 0; circulos < listaCirculos.size();circulos++) {
			for(int contato = 0; contato < listaCirculos.get(circulos).getListaContato().size();contato++){
				if(listaCirculos.get(circulos).getListaContato().get(contato).getIdentificador().equals(id))
                    listaCirculos.get(circulos).getListaContato().remove(contato);
			}

		}
			for(int i = 0;i < listaContato.size();i++){
				if(listaContato.get(i).getIdentificador().equals(id)){
					listaContato.remove(i);
					return true;
				}
			}
			return false;
	}

	@Override
	public Contato getContato(String id) {
		for(int i = 0;i < listaContato.size();i++){
			if(listaContato.get(i).getIdentificador().equals(id)){
			return listaContato.get(i);
			}
		}
		return null;
	}

	@Override
	public int getNumeroDeContatos() {
		return listaContato.size();
	}

	@Override
	public boolean favoritar(String idContato) {
		for (int i = 0; i < listaContato.size(); i++) {
			if (listaContato.get(i).getIdentificador().equals(idContato)) {
				listaContato.get(i).setFavorito(true);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean desfavoritar(String idContato) {
		for (int i = 0; i < listaContato.size(); i++) {
			if (listaContato.get(i).getIdentificador().equals(idContato)){
				listaContato.get(i).setFavorito(false);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean eFavorito(String id) {
		for (int i = 0; i < listaContato.size(); i++) {
			if (listaContato.get(i).getIdentificador().equals(id)) {
				return listaContato.get(i).isFavorito();
			}
		}
		return false;
	}

	@Override
	public List<Contato> getFavoritos() {
		List<Contato> listaFavorito = new ArrayList<>();
		for (int i = 0; i < listaContato.size(); i++) {
			if (listaContato.get(i).isFavorito()){
				listaFavorito.add(listaContato.get(i));
			}
		}
		listaFavorito.sort(Comparator.comparing(Contato::getIdentificador));
		return listaFavorito;
	}

	@Override
	public boolean adicionarContatoAoCirculo(String idContato, String idCirculo) throws CirculoNotFoundException, ContatoNotFoundException {
		Circulo circulo = getCirculo(idCirculo);
		Contato contato = getContato(idContato);

		if(circulo == null)
			throw new CirculoNotFoundException(idCirculo);
		if(contato == null)
			throw new ContatoNotFoundException(idContato);

		return circulo.adicionarContato(contato);
	}

	@Override
	public boolean removerContatoDoCirculo(String idContato, String idCirculo) throws CirculoNotFoundException, ContatoNotFoundException {
		Circulo circulo = getCirculo(idCirculo);
		Contato contato = getContato(idContato);

		if (circulo == null)
			throw new CirculoNotFoundException(idCirculo);
		if (contato == null)
			throw new ContatoNotFoundException(idContato);

		if (!circulo.removerContato(contato)) {
			return false;
		}
		for(int i = 0;i < getTodosCirculos().size();i++){
			if(getTodosCirculos().get(i).temContato(contato)){
				circulo.removerContato(contato);
			}
		}
		return true;
	}

	@Override
	public List<Contato> recuperarContatosDoCirculo(String id) throws CirculoNotFoundException {
		Circulo circulo = getCirculo(id);

		if (circulo == null)
			throw new CirculoNotFoundException(id);

		return circulo.getListaContato();

	}

	@Override
	public List<Circulo> recuperarCirculosDoContato(String id) throws ContatoNotFoundException {
		ArrayList<Circulo> circulosPertencidos = new ArrayList<>();

		Contato contato = getContato(id);

		if(contato == null)
			throw new ContatoNotFoundException(id);

		for(int i = 0;i < getTodosCirculos().size();i++){
			if(getTodosCirculos().get(i).temContato(contato)){
				circulosPertencidos.add(getTodosCirculos().get(i));
			}
		}

		circulosPertencidos.sort(Comparator.comparing(Circulo::getIdentificador));
		return circulosPertencidos;
	}

	@Override
	public List<Circulo> getCirculosEmComum(String idContato1, String idContato2) throws ContatoNotFoundException {
		ArrayList<Circulo> circulosComuns = new ArrayList<>();
		Contato contato1 = getContato(idContato1);
		Contato contato2 = getContato(idContato2);

		if(contato1 == null)
			throw new ContatoNotFoundException(idContato1);

		if(contato2 == null)
			throw new ContatoNotFoundException(idContato2);

		List<Circulo> circulosContato1 = recuperarCirculosDoContato(idContato1);
		List<Circulo> circulosContato2 = recuperarCirculosDoContato(idContato2);

		for (int i = 0; i < circulosContato1.size();i++){
			if(circulosContato2.contains(circulosContato1.get(i))){
				circulosComuns.add(circulosContato1.get(i));
			}
		}
		circulosComuns.sort(Comparator.comparing(Circulo::getIdentificador));
		return circulosComuns;
	}
}
