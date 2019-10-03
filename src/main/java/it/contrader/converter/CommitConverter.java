package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CommitDTO;
import it.contrader.model.Commit;


/**
 * 
 * @author team GDA
 * 
 *         Implementando questa l'interfaccia converter la classe CoinConverter
 *         è OBBLIGATA ad implementarne i metodi
 *
 */
public class CommitConverter  implements Converter<Commit, CommitDTO> {

	/**
	 * Crea un oggetto di tipo CoinDTO e lo riempie con i campi del parametro coin
	 * di tipo Coin. Notare l'uso del metodo get() per ottenere il valore
	 * dell'attributo-
	 */
	@Override
	public CommitDTO toDTO(Commit commit) {
		CommitDTO commitDTO = new CommitDTO(commit.getId(), commit.getNamecoin(), commit.getNumber(), commit.getData());
		return commitDTO;
		}
	

	/**
	 * Crea un oggetto di tipo Coin e lo riempie con i campi del parametro coin di
	 * tipo CoinDTO. Notare l'uso del metodo get() per ottenere il valore
	 * dell'attributo-
	 */
	@Override
	public Commit toEntity(CommitDTO commitDTO) {
		Commit commit = new Commit(commitDTO.getId(), commitDTO.getNamecoin(), commitDTO.getNumber(), commitDTO.getData());
		return commit;
	}

	/**
	 * Metodo per convertire le liste di Coin.
	 */
	@Override
	public List<CommitDTO> toDTOList(List<Commit> commitList) {
		// Crea una lista vuota.
		List<CommitDTO> commitDTOList = new ArrayList<CommitDTO>();

		// Cicla tutti gli elementi della lista e li converte uno a uno
		for (Commit commit : commitList) {
			// Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			// e lo aggiunge adda lista di DTO
			commitDTOList.add(toDTO(commit));
		}
		return commitDTOList;
	}

}
