package com.sample.repository;

import org.springframework.data.repository.CrudRepository;

import com.sample.domain.TradeEntity;

public interface TradeRepo extends CrudRepository<TradeEntity, String>{
	
}
