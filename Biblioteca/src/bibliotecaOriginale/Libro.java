package bibliotecaOriginale;

public class Libro {

	private String titolo;
	private String autore;
	private String numSeriale;
	private int copieTotali;
	private int copieDisponibili;
	
	
	public Libro(String titolo, String autore, String numSeriale, int copieTotali, int copieDisponibili) {
		this.titolo = titolo;
		this.autore = autore;
		this.setNumSeriale(numSeriale);
		this.copieTotali = copieTotali;
		this.copieDisponibili = copieDisponibili;
	}
	
	public Libro(String titolo, String autore, String numSeriale, int copieTotali) {
		this.titolo = titolo;
		this.autore = autore;
		this.setNumSeriale(numSeriale);
		this.copieTotali += copieTotali ;
		this.copieDisponibili += copieTotali;
	}
	
	
	
	///GETTERS AND SETTERS
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public int getCopieTotali() {
		return copieTotali;
	}
	public void setCopieTotali(int copieTotali) {
		this.copieTotali = copieTotali;
	}
	public int getCopieDisponibili() {
		return copieDisponibili;
	}
	public void setCopieDisponibili(int copieDisponibili) {
		this.copieDisponibili = copieDisponibili;
	}

	public String getNumSeriale() {
		return numSeriale;
	}

	public void setNumSeriale(String numSeriale) {
		this.numSeriale = numSeriale;
	}
	
	
	//TO STRING
	@Override
	public String toString() {
		return "Libro [titolo=" + titolo + ", autore=" + autore
				+ ", numSeriale=" + numSeriale + ", copieTotali=" + copieTotali
				+ ", copieDisponibili=" + copieDisponibili + "]";
	}
	
	
	
}
