package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Trend;

@Repository
@Transactional
public interface TrendRepository extends CrudRepository<Trend, Long> {

	Trend findTrendById(Long id);

}
