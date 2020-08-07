package com.ab.cryptoportfolio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ab.cryptoportfolio.entity.PersistentLoginToken;

public interface PersistentLoginsTokenRespository extends MongoRepository<PersistentLoginToken, String> {

	PersistentLoginToken findBySeries(String series);
	PersistentLoginToken findByUsername(String username);
	
}
