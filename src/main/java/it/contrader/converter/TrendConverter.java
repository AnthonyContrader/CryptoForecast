package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.TrendDTO;

import it.contrader.model.Trend;

@Component
public class TrendConverter extends AbstractConverter<Trend, TrendDTO> {

	@Override
	public Trend toEntity(TrendDTO trendDTO) {
		Trend trend = null;
		if (trendDTO != null) {
			trend = new Trend(trendDTO.getId(), trendDTO.getVariation(), trendDTO.getDate(), trendDTO.getIdcoin());
		}
		return trend;
	}

	@Override
	public TrendDTO toDTO(Trend trend) {
		TrendDTO trendDTO = null;
		if (trend != null) {
			trendDTO = new TrendDTO(trend.getId(), trend.getVariation(), trend.getDate(), trend.getIdcoin());

		}
		return trendDTO;
	}
}