package it.contrader.service;

import java.util.List;

import it.contrader.dao.CoinDAO;
import it.contrader.dto.CoinDTO;
import it.contrader.converter.CoinConverter;


public class CoinService {

	private CoinDAO coinDAO;
	private CoinConverter coinConverter;
	/**
	 * Costruisce un oggetto di tipo CoinDAO per poterne usare i metodi
	 */
	public CoinService() {
		this.coinDAO = new CoinDAO();
		this.coinConverter = new CoinConverter();
	}

	//chiama il metodo del DAO che ottiene una lista di tutti i coin
	public List<CoinDTO> getAll() {
		
		return coinConverter.toDTOList(coinDAO.getAll());
	}
	
	//chiama il metodo del DAO che restituisce un coin in base al suo idcoin
	public CoinDTO read(int idcoin) {
		return coinConverter.toDTO(coinDAO.read(idcoin));
	}

	//chiama il metodo del DAO che cancella un coin in base al suo idcoin
	public boolean delete(int idcoin) {
		return coinDAO.delete(idcoin);
	}
	
	//chiama il metodo del DAO che inserisce un oggetto Coin
	public boolean insert(CoinDTO dto) {
		return coinDAO.insert(coinConverter.toEntity(dto));
	}

	//chiama il metodo del DAO che modifica un coin
	public boolean update(CoinDTO dto) {
		return coinDAO.update(coinConverter.toEntity(dto));
	}


}
