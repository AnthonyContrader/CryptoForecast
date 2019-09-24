package it.contrader.view;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Coin;

public class CoinView  {

	private Request request;
	private String choice;
	private Scanner scanner;

	public CoinView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione utenti ----------------\n");
			System.out.println("ID\tname\tquotation\tsymbol");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<Coin> coins = (List<Coin>) request.get("coins");
			for (Coin c : coins)
				System.out.println(c);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi UserController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */

	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo UserController.
	 */
	
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Coin", "doControl", this.request);
	}
	public String getInput() {
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}
