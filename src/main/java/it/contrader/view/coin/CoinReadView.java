package it.contrader.view.coin;


import it.contrader.view.AbstractView;


import it.contrader.controller.Request;
import it.contrader.dto.CoinDTO;
import it.contrader.main.MainDispatcher;


public class CoinReadView extends AbstractView {

	private int idcoin;
	private Request request;
	private final String mode = "READ";
	

	public CoinReadView() {
	}

	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra la moneta. In questo caso torna alla CoinView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			CoinDTO coin = (CoinDTO) request.get("coin");
			System.out.println(coin);
			MainDispatcher.getInstance().callView("Coin", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id della moneta da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID della moneta:");
		idcoin = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id della moneta da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idcoin", idcoin);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Coin", "doControl", request);
	}
	  

}
