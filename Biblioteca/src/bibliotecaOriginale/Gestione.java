package bibliotecaOriginale;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gestione {

	
	
	///REGISTRA LIBRO
	public void registraLibro(Biblioteca b, String titolo, String autore, String numSeriale, int copieRegistrate){   //----> WORKING!
		Libro l = null;
		List<Libro> libri= b.getLibri();
		for (Libro libro : libri){
			if (libro.getNumSeriale().equals(numSeriale)){
				l = libro;
			}
		}
		
		///se uguale o diverso da null
		if (l == null){
			Libro nuovoLibro = new Libro(titolo, autore, numSeriale, copieRegistrate); 
			libri.add(nuovoLibro);
		} else {
			int copieT = l.getCopieTotali();
			int copieD = l.getCopieDisponibili();
			l.setCopieTotali(copieT += copieRegistrate);
			l.setCopieDisponibili(copieD += copieRegistrate);			
		}
	}
	
	
	
	///REGISTRA UTENTE
	public void registraUtente(Biblioteca b, String nome, String cognome){
		Utente u = null;
		List<Utente> utenti = b.getUtenti();
		for (Utente ut : utenti){
			if (ut.getNome().equals(nome) && ut.getCognome().equals(cognome)){
				u = ut;
			}
		}
		
		///verifichiamo se ut è diverso da null
		if (u == null){
			u = new Utente(nome, cognome);
			utenti.add(u);
		} else {
			System.out.println("L'UTENTE ESISTE GIA'!");
		}
	}
	
	
	////PRESTA LIBRO  ----> WORKING!
	public void prestaLibro(Biblioteca b, String nome, String cognome, String titolo, String autore, List<Libro> copiePossedute){
		///verifica che l'utente a cui dobbiamo prestare il libro esiste
		Utente u = null;
		List<Utente> utenti = b.getUtenti();
		boolean utenteEsistente = false;
		for (Utente utente : utenti){
			if (utente.getNome().equals(nome) && utente.getCognome().equals(cognome)){
				u = utente;
			}
		}
		if (u == null){
			System.out.println("L'UTENTE NON ESISTE!");
		} else {
			utenteEsistente = true;	
		}
		
		///verifichiamo che il libro che dobbiamo prestare esiste
		if (utenteEsistente){
			Libro l = null;
			List<Libro> libri = b.getLibri();
			for (Libro libro : libri){
				if (libro.getTitolo().equals(titolo) && libro.getAutore().equals(autore)){
					l = libro;
				} 
			}
			
			
			if (l == null){
				System.out.println("IL LIBRO NON ESISTE!");
				///una volta verificato, prestiamo il libro all'utente
			} else {
				if (u.getCopiePossedute().size() < 3 && l.getCopieDisponibili() > 0){
					u.getCopiePossedute().add(l);
					SimpleDateFormat sdfGiorno = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat sdfOrario = new SimpleDateFormat("HH:mm:ss");				
					Date date = new Date();
					// diminuiamo il numero di copie totali disponibili
					for (int i=0; i<libri.size(); i++){
						if (libri.get(i).getTitolo().equals(titolo) && libri.get(i).getAutore().equals(autore)){
							libri.get(i).setCopieDisponibili(libri.get(i).getCopieDisponibili() - 1);
						} else {
							System.out.println("NON E' POSSIBILE EFFETTUARE L'OPERAZIONE!");
						}
					}
					System.out.println("IL LIBRO E' STATO PRESTATO A " + u.getNome() + " " + u.getCognome() + " in data " + sdfGiorno.format(date) + " alle ore " + sdfOrario.format(date));
				} else {
					System.out.println("L'UTENTE GIA' POSSIEDE TRE COPIE OPPURE IL LIBRO NON E' DISPONIBILE!");
				}
			}
		}				
	}
	
	
	
	///RESTITUISCI LIBRO   ----> WORKING!
	public boolean restituisciLibro(Biblioteca b, String nome, String cognome, String titolo, String autore){
		//verifica che l'utente esista 
		Utente u = null;
		Libro l = null;
		List<Utente> utenti = b.getUtenti();		
		List<Libro> libriUtente = null;
		
		for (Utente uTemp : utenti){
			if (uTemp.getNome().equals(nome) && uTemp.getCognome().equals(cognome)){
				u = uTemp;				
			}
		}
		
		if(u == null){
			System.out.println("L'UTENTE NON ESISTE!");
			return false;
		} else {
			///una volta verificata l'esistenza dell'utente, verifichiamo che questo possegga la copia che si vuole restituire		
			libriUtente = u.getCopiePossedute();
			for (Libro lTemp : libriUtente){
				if (lTemp.getAutore().equals(autore) && lTemp.getTitolo().equals(titolo)){
					l = lTemp;
				}
			}			
		}
		
		///una volta verificata l'esistenza del libro tra quelli posseduti dall'utente, andiamo a prelevare il libro che si vuole restituire
		if (l==null){
			System.out.println("IL LIBRO NON E' PRESENTE NELLA LISTA DI LIBRI POSSEDUTI DALL'UTENTE!");
			return false;
		} else {
			SimpleDateFormat sdfGiorno = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdfOrario = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date();
			libriUtente.remove(l);
			l.setCopieDisponibili(l.getCopieDisponibili() + 1);
			System.out.println("LIBRO RESTITUITO DA " + u.getNome() + " " + u.getCognome() + " il giorno " + sdfGiorno.format(date) + " alle ore " + sdfOrario.format(date));
			return true;
		}
	}
	
	
	
	
	
	
	
	
	///***** ALTRI METODI
	
	////VISUALIZZA LIBRI PRESTATI
	public void stampaLibriPrestati(Biblioteca b){
		List<Utente> utenti = b.getUtenti();
		for (Utente u : utenti){
			System.out.println(u.getNome() + " " + u.getCognome() + " Copie possedute:  ----  " + u.getCopiePossedute().size() + "{" + u.getCopiePossedute() + "}");
		}
	}
	
	
	///STAMPA LIBRI
	public void stampaLibri(Biblioteca b){
		for (Libro libro : b.getLibri()){
			System.out.println(libro);
		}
		System.out.println(b.getLibri().size() + "\n\n");
	}
	
	
	///STAMPA UTENTI
	public void stampaUtenti(Biblioteca b){
		for (Utente utente : b.getUtenti()){
			System.out.println(utente);
		}
		System.out.println(b.getUtenti().size() + "\n\n");
	}
	
	
	
}
