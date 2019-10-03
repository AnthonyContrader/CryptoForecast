package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.SocialDTO;
import it.contrader.model.Social;


/**
 * 
 * @author team GDA
 * 
 *         Implementando questa l'interfaccia converter la classe CoinConverter
 *         è OBBLIGATA ad implementarne i metodi
 *
 */
public class SocialConverter  implements Converter<Social, SocialDTO> {

	/**
	 * Crea un oggetto di tipo CoinDTO e lo riempie con i campi del parametro coin
	 * di tipo Coin. Notare l'uso del metodo get() per ottenere il valore
	 * dell'attributo-
	 */
	@Override
	public SocialDTO toDTO(Social social) {
		SocialDTO socialDTO = new SocialDTO(social.getId(), social.getUrl(), social.getPost(), social.getData(), social.getNamecoin());
		return socialDTO;
		}
	

	/**
	 * Crea un oggetto di tipo Coin e lo riempie con i campi del parametro coin di
	 * tipo CoinDTO. Notare l'uso del metodo get() per ottenere il valore
	 * dell'attributo-
	 */
	@Override
	public Social toEntity(SocialDTO socialDTO) {
		Social social = new Social(socialDTO.getId(), socialDTO.getUrl(), socialDTO.getPost(), socialDTO.getData(), socialDTO.getNamecoin());
		return social;
	}

	/**
	 * Metodo per convertire le liste di Coin.
	 */
	@Override
	public List<SocialDTO> toDTOList(List<Social> socialList) {
		// Crea una lista vuota.
		List<SocialDTO> socialDTOList = new ArrayList<SocialDTO>();

		// Cicla tutti gli elementi della lista e li converte uno a uno
		for (Social social : socialList) {
			// Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			// e lo aggiunge adda lista di DTO
			socialDTOList.add(toDTO(social));
		}
		return socialDTOList;
	}

}
