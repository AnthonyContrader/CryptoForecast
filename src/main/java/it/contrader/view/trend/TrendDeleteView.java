package it.contrader.view.trend;



import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class TrendDeleteView extends AbstractView {
	private Request request;

	private int idtrend;
	private final String mode = "DELETE";

	public TrendDeleteView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Trend", null);
		}
	}

	/**
	 * Chiede all'utente di inserire l'idtrend dell'utente da cancellare
	 */
	
	public void showOptions() {
			System.out.println("Inserisci id del Trend:");
			idtrend = Integer.parseInt(getInput());

	}

	/**
	 * impacchetta la request con l'idtrend dell'utente da cancellare
	 */
	
	public void submit() {
		request = new Request();
		request.put("idtrend", idtrend);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Trend", "doControl", request);
	}
	  
	


}
