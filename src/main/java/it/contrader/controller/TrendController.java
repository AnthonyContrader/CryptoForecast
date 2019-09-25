package it.contrader.controller;

import java.util.List;


import it.contrader.main.MainDispatcher;
import it.contrader.model.Trend;
import it.contrader.service.TrendService;

public class TrendController implements Controller {

	/**
	 * definisce il pacchetto di vista trend.
	 */
	private static String sub_package = "trend.";
	
	private TrendService trendService;
	/**
	 * Costruisce un oggetto di tipo TrendService per poterne usare i metodi
	 */
	public TrendController() {
		this.trendService = new TrendService();
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
		int idtrend;
		String time;
		String variation;
		String namecoin;

		switch (mode) {
		
		// Arriva qui dalla TrendReadView. Invoca il Service con il parametro idtrend e invia alla TrendReadView uno trend da mostrare 
		case "READ":
			idtrend = Integer.parseInt(request.get("idtrend").toString());
			Trend trend = trendService.read(idtrend);
			request.put("trend", trend);
			MainDispatcher.getInstance().callView(sub_package + "TrendRead", request);
			break;
		
		// Arriva qui dalla TrendInsertView. Estrae i parametri da inserire e chiama il service per inserire uno trend con questi parametri
		case "INSERT":
			time = request.get("time").toString();
			variation = request.get("variation").toString();
			namecoin = request.get("namecoin").toString();
			
			//costruisce l'oggetto trend da inserire
			Trend trendtoinsert = new Trend(time, variation, namecoin);
			//invoca il service
			trendService.insert(trendtoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "TrendInsert", request);
			break;
		
		// Arriva qui dalla TrendDeleteView. Estrae l'idtrend dell'utente da cancellare e lo passa al Service
		case "DELETE":
			idtrend = Integer.parseInt(request.get("idtrend").toString());
			//Qui chiama il service
			trendService.delete(idtrend);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "TrendDelete", request);
			break;
		
		// Arriva qui dalla TrendUpdateView
		case "UPDATE":
			idtrend = Integer.parseInt(request.get("idtrend").toString());
			time = request.get("time").toString();
			variation = request.get("variation").toString();
			namecoin = request.get("namecoin").toString();
			Trend trendtoupdate = new Trend(time, variation, namecoin);
			trendtoupdate.setId(idtrend);
			trendService.update(trendtoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "TrendUpdate", request);
			break;
			
		//Arriva qui dalla TrendView Invoca il Service e invia alla TrendView il risultato da mostrare 
		case "USERLIST":
			List<Trend> trends = trendService.getAll();
			//Impacchetta la request con la lista degi trend
			request.put("trends", trends);
			MainDispatcher.getInstance().callView("Trend", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "TrendRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "TrendInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "TrendUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "TrendDelete", null);
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
