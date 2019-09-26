package it.contrader.view.coin;


import it.contrader.view.AbstractView;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class CoinDeleteView extends AbstractView {
	private Request request;

	private int idcoin;
	private final String mode = "DELETE";
	

	public CoinDeleteView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Coin", null);
		}
	}

	/**
	 * Chiede all'utente di inserire l'id dell'utente da cancellare
	 */
	
	public void showOptions() {
			System.out.println("Inserisci id della coin:");
			idcoin = Integer.parseInt(getInput());

	}

	/**
	 * impacchetta la request con l'id dell'utente da cancellare
	 */
	
	public void submit() {
		request = new Request();
		request.put("idcoin", idcoin);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Coin", "doControl", request);
	}
	 
	


}
