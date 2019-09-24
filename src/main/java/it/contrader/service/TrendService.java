package it.contrader.service;

import java.util.List;

import it.contrader.dao.TrendDAO;
import it.contrader.model.Trend;

public class TrendService {

	private TrendDAO trendDAO;
	
	/**
	 * Costruisce un oggetto di tipo trendDAO per poterne usare i metodi
	 */
	
	
	public TrendService() {
		this.trendDAO = new TrendDAO();
	}

	//chiama il metodo del DAO che ottiene una lista di tutti gli Trend
	public List<Trend> getAll() {
		return this.trendDAO.getAll();
	}
	
	//chiama il metodo del DAO che restituisce uno trend in base al suo id
	public Trend read(int idtrend) {
		return this.trendDAO.read(idtrend);
	}

	//chiama il metodo del DAO che cancella uno trend in base al suo id
	public boolean delete(int trendId) {
		return trendDAO.delete(trendId);
	}
	
	//chiama il metodo del DAO che inserisce un oggetto Trend
	public boolean insert(Trend trend) {
		return trendDAO.insert(trend);
	}

	//chiama il metodo del DAO che modifica un utente
	public boolean update(Trend trend) {
		return trendDAO.update(trend);
	}


}
