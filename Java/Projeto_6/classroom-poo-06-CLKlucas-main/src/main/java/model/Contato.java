package model;

public class Contato extends ID {
	private String email;
	private boolean favorito;

	public Contato(String id, String email){
		super(id);
		this.email = email;
		this.favorito = false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

}
