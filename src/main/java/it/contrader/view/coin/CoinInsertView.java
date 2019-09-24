package it.contrader.view.coin;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class CoinInsertView {
	private Request request;

	private String name;
	private String quotation;
	private String symbol;
	private final String mode = "INSERT";
	private Scanner scanner;

	public CoinInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Coin", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	
	public void showOptions() {
			System.out.println("Inserisci username dell'utente:");
			name = getInput();
			System.out.println("Inserisci password dell'utente:");
			quotation = getInput();
			System.out.println("Inserisci tipo dell'utente:");
			symbol = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("quotation", quotation);
		request.put("symbol", symbol);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Coin", "doControl", request);
	}
	  public String getInput() {
	    	
			scanner = new Scanner(System.in);
			return scanner.nextLine();
		}


}
 