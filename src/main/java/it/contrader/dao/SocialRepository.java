package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import it.contrader.model.Social;

@Repository
@Transactional
public interface SocialRepository extends CrudRepository<Social, Long> {

	Social findSocialById(Long Id);
}