package bibliotecaOriginale;

import java.util.ArrayList;
import java.util.List;

public class Utente {

	private String nome;
	private String cognome;
	private List<Libro> copiePossedute = new ArrayList<Libro>();
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public List<Libro> getCopiePossedute() {
		return copiePossedute;
	}
	public void setCopiePossedute(List<Libro> copiePossedute) {
		this.copiePossedute = copiePossedute;
	}
	
	
	///COSTRUTTORI
	
	public Utente(){
		
	}
	
	public Utente(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public Utente(String nome, String cognome, List<Libro> copiePossedute) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.copiePossedute = copiePossedute;
	}
	
	
	
	///TO STRING
	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome
				+ ", copiePossedute = " + copiePossedute.size() + "  " + copiePossedute + "]";
	}
	
	
}
