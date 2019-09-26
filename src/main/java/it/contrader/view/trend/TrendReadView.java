package it.contrader.view.trend;


import it.contrader.controller.Request;
import it.contrader.dto.TrendDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TrendReadView extends AbstractView  {

	private int idtrend;
	private Request request;
	private final String mode = "READ";
	public TrendReadView() {
	}

	/**
	 * Se la request � null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo � vuoto.
	 * 
	 * Altrimenti se arriva con uno trend nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo trend. In questo caso torna alla TrendView senza eseguire
	 * gli altri due metodi
	 */
	
	public void showResults(Request request) {
		if (request != null) {
			TrendDTO trend = (TrendDTO) request.get("trend");
			System.out.println(trend);
			MainDispatcher.getInstance().callView("Trend", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'idtrend dell'utente da leggere
	 */
	
	public void showOptions() {
		System.out.println("Inserisci l'ID del trend:");
		idtrend = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'idtrend dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	
	public void submit() {
		request = new Request();
		request.put("idtrend", idtrend);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Trend", "doControl", request);
	}
	  

}
