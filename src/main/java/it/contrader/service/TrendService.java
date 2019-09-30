package it.contrader.service;

import java.util.List;

import it.contrader.converter.TrendConverter;
import it.contrader.dao.TrendDAO;
import it.contrader.dto.TrendDTO;

public class TrendService {

	private TrendDAO trendDAO;
	private TrendConverter trendConverter;
	
	/**
	 * Costruisce un oggetto di tipo trendDAO per poterne usare i metodi
	 */
	
	
	public TrendService() {
		this.trendDAO = new TrendDAO();
		this.trendConverter = new TrendConverter();
	}

	//chiama il metodo del DAO che ottiene una lista di tutti gli Trend
	public List<TrendDTO> getAll() {
		return trendConverter.toDTOList(trendDAO.getAll());
	}
	
	//chiama il metodo del DAO che restituisce uno trend in base al suo id
	public TrendDTO read(int idtrend) {
		return trendConverter.toDTO(trendDAO.read(idtrend));
	}

	//chiama il metodo del DAO che cancella uno trend in base al suo id
	public boolean delete(int idtrend) {
		return trendDAO.delete(idtrend);
	}
	
	//chiama il metodo del DAO che inserisce un oggetto Trend
	public boolean insert(TrendDTO dto) {
		return trendDAO.insert(trendConverter.toEntity(dto));
	}

	//chiama il metodo del DAO che modifica un utente
	public boolean update(TrendDTO dto) {
		return trendDAO.update(trendConverter.toEntity(dto));
	}


}
