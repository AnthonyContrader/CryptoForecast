package it.contrader.view.coin;



import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CoinInsertView extends AbstractView {
	private Request request;

	private String name;
	private String quotation;
	private String symbol;
	private final String mode = "INSERT";
	

	public CoinInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Coin", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci il nome della moneta:");
			name = getInput();
			System.out.println("Inserisci la quotazione:");
			quotation = getInput();
			System.out.println("Inserisci il symbol:");
			symbol = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("quotation", quotation);
		request.put("symbol", symbol);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Coin", "doControl", request);
	}
	 


}
 