package it.contrader.view.trend;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class TrendInsertView {
	private Request request;

	private String variation;
	private String time;
	private String namecoin;
	private final String mode = "INSERT";
	private Scanner scanner;

	public TrendInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Trend", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	
	public void showOptions() {
			System.out.println("Inserisci la variazione:");
			variation = getInput();
			System.out.println("Inserisci la data:");
			time = getInput();
			System.out.println("Inserisci il nome della moneta:");
			namecoin = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	
	public void submit() {
		request = new Request();
		request.put("variazione", variation);
		request.put("time", time);
		request.put("namecoin", namecoin);
		request.put("mode", mode);
		
		MainDispatcher.getInstance().callAction("Trend", "doControl", request);
	}
	  public String getInput() {
	    	
			scanner = new Scanner(System.in);
			return scanner.nextLine();
		}


}
