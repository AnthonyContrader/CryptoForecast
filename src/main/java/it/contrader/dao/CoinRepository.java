package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Coin;

@Repository
@Transactional
public interface CoinRepository extends CrudRepository<Coin, Long> {

	Coin findCoinById(Long Id);
}