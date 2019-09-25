package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CoinDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Coin;

/**
 * 
 * @author Diego
 * 
 *         Implementando questa l'interfaccia converter la classe CoinConverter
 *         è OBBLIGATA ad implementarne i metodi
 *
 */
public class CoinConverter  {

	/**
	 * Crea un oggetto di tipo CoinDTO e lo riempie con i campi del parametro coin
	 * di tipo Coin. Notare l'uso del metodo get() per ottenere il valore
	 * dell'attributo-
	 */
	
	public CoinDTO toDTO(Coin coin) {
		CoinDTO coinDTO = new CoinDTO(coin.getId(), coin.getName(), coin.getQuotation(), coin.getSymbol());
		return coinDTO;
		}
	

	/**
	 * Crea un oggetto di tipo Coin e lo riempie con i campi del parametro coin di
	 * tipo CoinDTO. Notare l'uso del metodo get() per ottenere il valore
	 * dell'attributo-
	 */
	
	public Coin toEntity(CoinDTO coinDTO) {
		Coin coin = new Coin();
		if (coinDTO != null) {
			coin.setId(coinDTO.getId());
			coin.setName(coinDTO.getName());
			coin.setQuotation(coinDTO.getQuotation());
			coin.setSymbol(coinDTO.getSymbol());
		}
		return coin;
	}

	/**
	 * Metodo per convertire le liste di Coin.
	 */
	
	public List<CoinDTO> toDTOList(List<Coin> coinList) {
		// Crea una lista vuota.
		List<CoinDTO> coinDTOList = new ArrayList<CoinDTO>();

		// Cicla tutti gli elementi della lista e li converte uno a uno
		for (Coin coin : coinList) {
			// Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			// e lo aggiunge adda lista di DTO
			coinDTOList.add(toDTO(coin));
		}
		return coinDTOList;
	}

}
