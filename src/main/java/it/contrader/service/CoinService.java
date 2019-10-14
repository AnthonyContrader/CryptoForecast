package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.CoinConverter;
import it.contrader.dao.CoinRepository;
import it.contrader.dto.CoinDTO;
import it.contrader.model.Coin;

@Service
public class CoinService extends AbstractService<Coin, CoinDTO> {

	@Autowired
	private CoinConverter converter;
	@Autowired
	private CoinRepository repository;

	public CoinDTO findById(Long id) {
		return converter.toDTO(repository.findCoinById(id));
	}

}