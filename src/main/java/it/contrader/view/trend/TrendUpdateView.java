package it.contrader.view.trend;



import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class TrendUpdateView extends AbstractView  {
	private Request request;

	private int idtrend;
	private String time;
	private String variation;
	private String namecoin;
	private final String mode = "UPDATE";

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
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del trend:");
			idtrend = Integer.parseInt(getInput());
			System.out.println("Inserisci la data:");
			time = getInput();
			System.out.println("Inserisci la variazione:");
			variation = getInput();
			System.out.println("Inserisci nome della moneta:");
			namecoin = getInput();
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idtrend", idtrend);
		request.put("time", time);
		request.put("variation", variation);
		request.put("namecoin", namecoin);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Trend", "doControl", request);
	}
	  

}
