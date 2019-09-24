package it.contrader.view.trend;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class TrendInsertView {
	private Request request;

<<<<<<< HEAD
	private String time;
	private String variation;
=======
	private String variation;
	private String time;
>>>>>>> 1c3a440ba27d842617a5309b3eb3e9b22b8666d8
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
<<<<<<< HEAD
			System.out.println("Inserisci time dell'utente:");
			time = getInput();
			System.out.println("Inserisci variation dell'utente:");
			variation = getInput();
			System.out.println("Inserisci tipo dell'utente:");
=======
			System.out.println("Inserisci la variazione:");
			variation = getInput();
			System.out.println("Inserisci la data:");
			time = getInput();
			System.out.println("Inserisci il nome della moneta:");
>>>>>>> 1c3a440ba27d842617a5309b3eb3e9b22b8666d8
			namecoin = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	
	public void submit() {
		request = new Request();
<<<<<<< HEAD
		request.put("time", time);
		request.put("variation", variation);
		request.put("namecoin", namecoin);
		request.put("mode", mode);
=======
		request.put("variazione", variation);
		request.put("time", time);
		request.put("namecoin", namecoin);
		request.put("mode", mode);
		
>>>>>>> 1c3a440ba27d842617a5309b3eb3e9b22b8666d8
		MainDispatcher.getInstance().callAction("Trend", "doControl", request);
	}
	  public String getInput() {
	    	
			scanner = new Scanner(System.in);
			return scanner.nextLine();
		}


}
