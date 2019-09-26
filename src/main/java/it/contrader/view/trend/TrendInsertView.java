package it.contrader.view.trend;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TrendInsertView extends AbstractView{
	private Request request;
	private String time;
	private String variation;
	private String namecoin;
	private final String mode = "INSERT";

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
		
			System.out.println("Inserisci la data:");
			time = getInput();
			System.out.println("Inserisci la variazione:");
			variation = getInput();
			System.out.println("Inserisci il nome della moneta:");
			namecoin = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	
	public void submit() {
		request = new Request();
		request.put("time", time);
		request.put("variation", variation);
		request.put("namecoin", namecoin);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Trend", "doControl", request);
	}
	  


}
