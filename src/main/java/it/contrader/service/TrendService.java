package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.TrendConverter;
import it.contrader.dao.TrendRepository;

import it.contrader.dto.TrendDTO;

import it.contrader.model.Trend;


@Service
public class TrendService extends AbstractService<Trend, TrendDTO> {

	@Autowired
	private TrendConverter converter;
	@Autowired
	private TrendRepository repository;

	public TrendDTO findByUsernameAndPassword(Long id) {
		return converter.toDTO(repository.findTrendById(id));
	}

}
