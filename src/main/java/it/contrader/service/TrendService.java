package it.contrader.service;

import it.contrader.converter.TrendConverter;
import it.contrader.dao.TrendDAO;
import it.contrader.dto.TrendDTO;
import it.contrader.model.Trend;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class TrendService extends AbstractService<Trend, TrendDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public TrendService(){
		this.dao = new TrendDAO();
		this.converter = new TrendConverter();
	}
	

}
