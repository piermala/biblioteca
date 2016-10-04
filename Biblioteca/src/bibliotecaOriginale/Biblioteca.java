package bibliotecaOriginale;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

	private static final String nome = "Biblioteca Comunale";
	private List<Utente> utenti = new ArrayList<Utente>();
	private List<Libro> libri = new ArrayList<Libro>();

	public static String getNome() {
		return nome;
	}

	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	public List<Libro> getLibri() {
		return libri;
	}

	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}
	
	
}
