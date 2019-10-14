package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.CommitConverter;
import it.contrader.dao.CommitRepository;
import it.contrader.dto.CommitDTO;
import it.contrader.model.Commit;

@Service
public class CommitService extends AbstractService<Commit, CommitDTO> {

	@Autowired
	private CommitConverter converter;
	@Autowired
	private CommitRepository repository;

	public CommitDTO findById(Long id) {
		return converter.toDTO(repository.findCoinById(id));
	}

}