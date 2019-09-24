package it.contrader.controller;

import java.util.List;


import it.contrader.main.MainDispatcher;
import it.contrader.model.Coin;
import it.contrader.service.CoinService;

public class CoinController implements Controller {

	/**
	 * definisce il pacchetto di vista coin.
	 */
	private static String sub_package = "coin.";
	
	private CoinService coinService;
	/**
	 * Costruisce un oggetto di tipo CoinService per poterne usare i metodi
	 */
	public CoinController() {
		this.coinService = new CoinService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int idcoin;
		String name;
		String quotation;
		String symbol;

		switch (mode) {
		
		// Arriva qui dalla UserReadView. Invoca il Service con il parametro id e invia alla UserReadView uno user da mostrare 
		case "READ":
			idcoin = Integer.parseInt(request.get("idcoin").toString());
			Coin coin = coinService.read(idcoin);
			request.put("coin", coin);
			MainDispatcher.getInstance().callView(sub_package + "CoinRead", request);
			break;
		
		// Arriva qui dalla UserInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			name = request.get("name").toString();
			quotation = request.get("quotation").toString();
			symbol = request.get("symbol").toString();
			
			//costruisce l'oggetto coin da inserire
			Coin cointoinsert = new Coin(name, quotation, symbol);
			//invoca il service
			coinService.insert(cointoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "CoinInsert", request);
			break;
		
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
		case "DELETE":
			idcoin = Integer.parseInt(request.get("idcoin").toString());
			//Qui chiama il service
			coinService.delete(idcoin);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "CoinDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			idcoin = Integer.parseInt(request.get("idcoin").toString());
			name = request.get("name").toString();
			quotation = request.get("quotation").toString();
			symbol = request.get("symbol").toString();
			Coin cointoupdate = new Coin (name, quotation, symbol);
			cointoupdate.setId(idcoin);
			coinService.update(cointoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "CoinUpdate", request);
			break;
			
		//Arriva qui dalla UserView Invoca il Service e invia alla UserView il risultato da mostrare 
		case "USERLIST":
			List<Coin> coins = coinService.getAll();
			//Impacchetta la request con la lista degi user
			request.put("coins", coins);
			MainDispatcher.getInstance().callView("Coin", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "CoinRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "CoinInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "CoinUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "CoinDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
