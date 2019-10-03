package it.contrader.service;

import it.contrader.converter.SocialConverter;
import it.contrader.dao.SocialDAO;
import it.contrader.dto.SocialDTO;
import it.contrader.model.Social;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class SocialService extends AbstractService<Social, SocialDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public SocialService(){
		this.dao = new SocialDAO();
		this.converter = new SocialConverter();
	}
	

}