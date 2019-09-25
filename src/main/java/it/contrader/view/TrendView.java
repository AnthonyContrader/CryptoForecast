package it.contrader.view;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Trend;

public class TrendView  {

	private Request request;
	private String choice;
	private Scanner scanner;

	public TrendView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione trend ----------------\n");
			System.out.println("ID\tTime\tVariation\tNameCoin");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<Trend> trends = (List<Trend>) request.get("trends");
			for (Trend u: trends)
				System.out.println(u);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi TrendController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */

	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo TrendController.
	 */
	
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Trend", "doControl", this.request);
	}
	public String getInput() {
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}
