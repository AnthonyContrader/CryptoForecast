package it.contrader.service;

import it.contrader.converter.UserConverter;
import it.contrader.dao.CoinDAO;
import it.contrader.dto.CoinDTO;
import it.contrader.model.Coin;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class CoinService extends AbstractService<Coin, CoinDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public CoinService(){
		this.dao = new CoinDAO();
		this.converter = new CoinConverter();
	}
	

}