package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.TrendDTO;
import it.contrader.main.MainDispatcher;

<<<<<<< HEAD

=======
>>>>>>> 061a4818da1b50224fcf056ac0ccb302c91aca35
public class TrendView extends AbstractView {

	private Request request;
	private String choice;

	public TrendView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione trend ----------------\n");
<<<<<<< HEAD
			System.out.println("IDTrend\t  Time\t       Variation\t       NameCoin");
=======
			System.out.println("IDTrend\tTime\tVariation\tNameCoin");
>>>>>>> 061a4818da1b50224fcf056ac0ccb302c91aca35
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<TrendDTO> trends = (List<TrendDTO>) request.get("trends");
			for (TrendDTO u: trends)
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
	

}
