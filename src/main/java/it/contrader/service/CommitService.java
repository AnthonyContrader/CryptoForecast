package it.contrader.service;


import it.contrader.converter.CommitConverter;
import it.contrader.dao.CommitDAO;
import it.contrader.dto.CommitDTO;
import it.contrader.model.Commit;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class CommitService extends AbstractService<Commit, CommitDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public CommitService(){
		this.dao = new CommitDAO();
		this.converter = new CommitConverter();
	}
	

}