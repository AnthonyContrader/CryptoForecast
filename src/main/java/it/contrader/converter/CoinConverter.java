package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.CoinDTO;

import it.contrader.model.Coin;

@Component
public class CoinConverter extends AbstractConverter<Coin, CoinDTO> {

	@Override
	public Coin toEntity(CoinDTO coinDTO) {
		Coin coin = null;
		if (coinDTO != null) {
			coin = new Coin();
			coin.setId(coinDTO.getId());
			coin.setNamecoin(coinDTO.getNamecoin());
			coin.setPrice(coinDTO.getPrice());
			coin.setCirculating(coinDTO.getCirculating());
			TrendConverter tc = new TrendConverter();
			coin.setTrends(tc.toEntityList(coinDTO.getTrendsDTO()));
			CommitConverter cc = new CommitConverter();
			coin.setCommits(cc.toEntityList(coinDTO.getCommitsDTO()));
			SocialConverter sc = new SocialConverter();
			coin.setSocials(sc.toEntityList(coinDTO.getSocialsDTO()));
		}
		return coin;
	}

	@Override
	public CoinDTO toDTO(Coin coin) {
		CoinDTO coinDTO = null;
		if (coin != null) {
			
			//coinDTO = new CoinDTO(coin.getId(), coin.getNamecoin(), coin.getPrice(), coin.getCirculating());
			coinDTO = new CoinDTO();
			coinDTO.setId(coin.getId());
			coinDTO.setNamecoin(coin.getNamecoin());
			coinDTO.setPrice(coin.getPrice());
			coinDTO.setCirculating(coin.getCirculating());
			TrendConverter tc = new TrendConverter();
			coinDTO.setTrendsDTO(tc.toDTOList(coin.getTrends()));
			
			CommitConverter cc = new CommitConverter();
			coinDTO.setCommitsDTO(cc.toDTOList(coin.getCommits()));
			
			SocialConverter sc = new SocialConverter();
			coinDTO.setSocialsDTO(sc.toDTOList(coin.getSocials()));
						
		}
		return coinDTO;
	}
	
	
	@Override
	public Coin toEntityS(CoinDTO coinDTO) {
		
		Coin coin = null;
		if (coinDTO != null) {
			coin = new Coin();
			coin.setId(coinDTO.getId());
			coin.setNamecoin(coinDTO.getNamecoin());
			coin.setPrice(coinDTO.getPrice());
			coin.setCirculating(coinDTO.getCirculating());
						
		}
		return coin;
	}

	@Override
	public CoinDTO toDTOS(Coin coin) {
		CoinDTO coinDTO = null;
		if (coin != null) {
			
			//coinDTO = new CoinDTO(coin.getId(), coin.getNamecoin(), coin.getPrice(), coin.getCirculating());
			coinDTO = new CoinDTO();
			coinDTO.setId(coin.getId());
			coinDTO.setNamecoin(coin.getNamecoin());
			coinDTO.setPrice(coin.getPrice());
			coinDTO.setCirculating(coin.getCirculating());
	
		}
		return coinDTO;
	}
}