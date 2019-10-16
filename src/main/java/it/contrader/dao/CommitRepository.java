package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Commit;

@Repository
@Transactional
public interface CommitRepository extends CrudRepository<Commit, Long> {

	Commit findCommitById(Long Id);
}