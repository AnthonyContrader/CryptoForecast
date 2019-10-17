package it.contrader.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import antlr.collections.List;
import it.contrader.dto.TrendDTO;

import it.contrader.model.Trend;

@Component
public class TrendConverter extends AbstractConverter<Trend, TrendDTO> {

	@Override
	public Trend toEntity(TrendDTO trendDTO) {
		Trend trend = null;
		if (trendDTO != null) {
			
			//trend = new Trend(trendDTO.getId(), trendDTO.getVariation(), trendDTO.getDate(), trendDTO.getIdcoin());
			trend = new Trend();
			trend.setId(trendDTO.getId());
			trend.setVariation(trendDTO.getVariation());
			trend.setDate(trendDTO.getDate());
		//	CoinConverter cc = new CoinConverter();
		//	trend.setCoin(cc.toEntityS(trendDTO.getCoinDTO()));
		}
		return trend;
	}

	@Override
	public TrendDTO toDTO(Trend trend) {
		TrendDTO trendDTO = null;
		if (trend != null) {
			
			//trendDTO = new TrendDTO(trend.getId(), trend.getVariation(), trend.getDate(), trend.getIdcoin());
			trendDTO = new TrendDTO();
			trendDTO.setId(trend.getId());
			trendDTO.setVariation(trend.getVariation());
			trendDTO.setDate(trend.getDate());
		//	CoinConverter cc = new CoinConverter();
		//	trendDTO.setCoinDTO(cc.toDTOS(trend.getCoin()));

		}
		return trendDTO;
	}
	/*
	@Override
	public Trend toEntityS(TrendDTO trendDTO) {
		Trend trend = null;
		if (trendDTO != null) {
			
			//trend = new Trend(trendDTO.getId(), trendDTO.getVariation(), trendDTO.getDate(), trendDTO.getIdcoin());
			trend = new Trend();
			trend.setId(trendDTO.getId());
			trend.setVariation(trendDTO.getVariation());
			trend.setDate(trendDTO.getDate());
			CoinConverter cc = new CoinConverter();
			trend.setCoin(cc.toEntityS(trendDTO.getCoinDTO()));
		}
		return trend;
	}

	@Override
	public TrendDTO toDTOS(Trend trend) {
		TrendDTO trendDTO = null;
		if (trend != null) {
			
			//trendDTO = new TrendDTO(trend.getId(), trend.getVariation(), trend.getDate(), trend.getIdcoin());
			trendDTO = new TrendDTO();
			trendDTO.setId(trend.getId());
			trendDTO.setVariation(trend.getVariation());
			trendDTO.setDate(trend.getDate());
			CoinConverter cc = new CoinConverter();
			trendDTO.setCoinDTO(cc.toDTOS(trend.getCoin()));

		}
		return trendDTO;
	}*/
	
}