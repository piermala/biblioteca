package mainPackage;

import java.util.ArrayList;
import java.util.List;

import bibliotecaOriginale.*;

public class MainBibliotecaOriginale {

	public static void main(String[] args) {
		
		Biblioteca b = new Biblioteca();
		Gestione g = new Gestione();
		List<Libro> libri = new ArrayList<Libro>();
		
		
		///REGISTRA LIBRI
		g.registraLibro(b, "HPPF", "JKR", "HPPFJKR", 14);
		g.registraLibro(b, "HPCS", "JKR", "HPCSJKR", 17);
		g.registraLibro(b, "HPPAZK", "JKR", "HPPAZKJKR", 13);
		g.registraLibro(b, "HPCDF", "JKR", "HPCDFJKR", 14);
		g.registraLibro(b, "HPODF", "JKR", "HPODFJKR", 15);
		g.registraLibro(b, "HPODF", "JKR", "HPODFJKR", 15);
		g.registraLibro(b, "HPPMS", "JKR", "HPPMSJKR", 1);
		
		
		////STAMPA LIBRI
		g.stampaLibri(b);
		
		
		
		////REGISTRA UTENTI
		g.registraUtente(b, "Pier", "Mala");
		g.registraUtente(b, "Luca", "Mala");
		g.registraUtente(b, "Enzo", "Muta");
		
		///STAMPA UTENTI
		g.stampaUtenti(b);
		
		
		
		///PRESTA LIBRO
		g.prestaLibro(b, "Pier", "Mala", "HPPF", "JKR", libri);
		g.prestaLibro(b, "Pier", "Mala", "HPPF", "JKR", libri);
		g.prestaLibro(b, "Pier", "Mala", "HPPF", "JKR", libri);
		g.prestaLibro(b, "Pier", "Mala", "HPPF", "JKR", libri);  ///L'UTENTE GIA' POSSIEDE TRE COPIE
		g.prestaLibro(b, "Luca", "Mala", "HPPMS", "JKR", libri);
		g.prestaLibro(b, "Luca", "Mala", "HPPMS", "JKR", libri);  /// LE COPIE DEL LIBRO NON SONO PIù DISPONIBILI
		
		////STAMPA LIBRI
		System.out.println();
		g.stampaLibri(b);
			
		///STAMPA UTENTI
		g.stampaUtenti(b);
		
		
		
		
		///RESTITUISCI LIBRO
		g.restituisciLibro(b, "Pier", "Mala", "HPPF", "JKR");
		g.restituisciLibro(b, "Pier", "Mala", "HPPF", "JKR");
		g.restituisciLibro(b, "Luca", "Mala", "HPPMS", "JKR");
		
		////STAMPA LIBRI
		System.out.println();
		g.stampaLibri(b);
				
		///STAMPA UTENTI
		g.stampaUtenti(b);
	}
}
