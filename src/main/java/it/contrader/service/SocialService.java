package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.SocialConverter;
import it.contrader.dao.SocialRepository;
import it.contrader.dto.SocialDTO;
import it.contrader.model.Social;

@Service
public class SocialService extends AbstractService<Social, SocialDTO> {

	@Autowired
	private SocialConverter converter;
	@Autowired
	private SocialRepository repository;

	public SocialDTO findById(Long id) {
		return converter.toDTO(repository.findSocialById(id));
	}

}