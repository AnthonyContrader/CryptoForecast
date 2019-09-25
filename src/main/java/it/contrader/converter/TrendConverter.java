package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TrendDTO;
import it.contrader.model.Trend;

/**
 * 
 * @author Vittorio
 * 
 *         Implementando questa l'interfaccia converter la classe TrendConverter
 *         è OBBLIGATA ad implementarne i metodi
 *
 */
public class TrendConverter implements Converter<Trend, TrendDTO> {

	/**
	 * Crea un oggetto di tipo TrendDTO e lo riempie con i campi del parametro trend
	 * di tipo Trend. Notare l'uso del metodo get() per ottenere il valore
	 * dell'attributo-
	 */
	@Override
	public TrendDTO toDTO(Trend trend) {
		TrendDTO trendDTO = new TrendDTO();
		if (trend != null) {
			trendDTO.setId(trend.getId());
			trendDTO.setTime(trend.getTime());
			trendDTO.setVariation(trend.getVariation());
			trendDTO.setNamecoin(trend.getNamecoin());
		}
		return trendDTO;
	}

	/**
	 * Crea un oggetto di tipo Trend e lo riempie con i campi del parametro trend di
	 * tipo TrendDTO. Notare l'uso del metodo get() per ottenere il valore
	 * dell'attributo-
	 */
	@Override
	public Trend toEntity(TrendDTO trendDTO) {
		Trend trend = new Trend();
		if (trendDTO != null) {
			trend.setId(trendDTO.getId());
			trend.setTime(trendDTO.getTime());
			trend.setVariation(trendDTO.getVariation());
			trend.setNamecoin(trendDTO.getNamecoin());
		}
		return trend;
	}

	/**
	 * Metodo per convertire le liste di Trend.
	 */
	@Override
	public List<TrendDTO> toDTOList(List<Trend> trendList) {
		// Crea una lista vuota.
		List<TrendDTO> trendDTOList = new ArrayList<TrendDTO>();

		// Cicla tutti gli elementi della lista e li converte uno a uno
		for (Trend trend : trendList) {
			// Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			// e lo aggiunge adda lista di DTO
			trendDTOList.add(toDTO(trend));
		}
		return trendDTOList;
	}

}
