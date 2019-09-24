package it.contrader.service;

import java.util.List;

import it.contrader.dao.CoinDAO;
import it.contrader.model.Coin;

public class CoinService {

	private CoinDAO coinDAO;
	/**
	 * Costruisce un oggetto di tipo CoinDAO per poterne usare i metodi
	 */
	public CoinService() {
		this.coinDAO = new CoinDAO();
	}

	//chiama il metodo del DAO che ottiene una lista di tutti i coin
	public List<Coin> getAll() {
		return this.coinDAO.getAll();
	}
	
	//chiama il metodo del DAO che restituisce un coin in base al suo idcoin
	public Coin read(int idcoin) {
		return this.coinDAO.read(idcoin);
	}

	//chiama il metodo del DAO che cancella un coin in base al suo idcoin
	public boolean delete(int coinId) {
		return coinDAO.delete(coinId);
	}
	
	//chiama il metodo del DAO che inserisce un oggetto Coin
	public boolean insert(Coin coin) {
		return coinDAO.insert(coin);
	}

	//chiama il metodo del DAO che modifica un coin
	public boolean update(Coin coin) {
		return coinDAO.update(coin);
	}


}
