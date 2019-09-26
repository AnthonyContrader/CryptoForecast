package it.contrader.view;

import java.util.List;
import it.contrader.dto.CoinDTO;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;


public class CoinView  extends AbstractView {

	private Request request;
	private String choice;
	

	public CoinView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione coin ----------------\n");
			System.out.println("IDcoin\tname\tquotation\tsymbol");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<CoinDTO> coins = (List<CoinDTO>) request.get("coins");
			for (CoinDTO c : coins)
				System.out.println(c);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi CoinController). 
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
	
}
