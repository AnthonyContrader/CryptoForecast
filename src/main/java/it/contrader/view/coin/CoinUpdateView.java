package it.contrader.view.coin;

import it.contrader.view.AbstractView;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;


public class CoinUpdateView extends AbstractView {
	private Request request;

	private int idcoin;
	private String name;
	private String symbol;
	private String quotation;
	private final String mode = "UPDATE";
	

	public CoinUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("User", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	
	public void showOptions() {
		try {
			System.out.println("Inserisci id della moneta:");
			idcoin = Integer.parseInt(getInput());
			System.out.println("Inserisci nome della moneta:");
			name = getInput();
			System.out.println("Inserisci la quotazione della moneta:");
			quotation = getInput();
			System.out.println("Inserisci il simbolo della moneta:");
			symbol = getInput();
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	
	public void submit() {
		request = new Request();
		request.put("idcoin", idcoin);
		request.put("name", name);
		request.put("quotation", quotation);
		request.put("symbol", symbol);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Coin", "doControl", request);
	}
	  

}
