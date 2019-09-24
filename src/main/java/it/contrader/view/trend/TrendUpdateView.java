package it.contrader.view.trend;


import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;


public class TrendUpdateView  {
	private Request request;

	private int idtrend;
	private String time;
	private String variation;
	private String namecoin;
	private final String mode = "UPDATE";
	private Scanner scanner;

	public TrendUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Trend", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	
	public void showOptions() {
		try {
			System.out.println("Inserisci idtrend dell'utente:");
			idtrend = Integer.parseInt(getInput());
			System.out.println("Inserisci time dell'utente:");
			time = getInput();
			System.out.println("Inserisci variation dell'utente:");
			variation = getInput();
			System.out.println("Inserisci tipo dell'utente:");
			namecoin = getInput();
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	
	public void submit() {
		request = new Request();
		request.put("idtrend", idtrend);
		request.put("time", time);
		request.put("variation", variation);
		request.put("namecoin", namecoin);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Trend", "doControl", request);
	}
	  public String getInput() {
	    	
			scanner = new Scanner(System.in);
			return scanner.nextLine();
		}

}
