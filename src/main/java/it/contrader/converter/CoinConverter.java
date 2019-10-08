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
			coin = new Coin(coinDTO.getId(), coinDTO.getNamecoin(), coinDTO.getPrice(), coinDTO.getCirculating());
		}
		return coin;
	}

	@Override
	public CoinDTO toDTO(Coin coin) {
		CoinDTO coinDTO = null;
		if (coin != null) {
			coinDTO = new CoinDTO(coin.getId(), coin.getNamecoin(), coin.getPrice(), coin.getCirculating());

		}
		return coinDTO;
	}
}