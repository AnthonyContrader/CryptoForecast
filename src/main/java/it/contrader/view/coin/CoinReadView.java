package it.contrader.view.coin;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Coin;

public class CoinReadView  {

	private int id;
	private Request request;
	private final String mode = "READ";
	private Scanner scanner;

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
	
	public void showResults(Request request) {
		if (request != null) {
			Coin coin = (Coin) request.get("coin");
			System.out.println(coin);
			MainDispatcher.getInstance().callView("Coin", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id della moneta da leggere
	 */
	
	public void showOptions() {
		System.out.println("Inserisci l'ID della moneta:");
		id = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id della moneta da leggere e la manda al controller tramite il Dispatcher
	 */
	
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Coin", "doControl", request);
	}
	  public String getInput() {
	    	
			scanner = new Scanner(System.in);
			return scanner.nextLine();
		}

}
