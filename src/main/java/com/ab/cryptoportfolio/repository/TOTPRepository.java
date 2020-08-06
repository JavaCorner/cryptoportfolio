package com.ab.cryptoportfolio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ab.cryptoportfolio.entity.TOTPDetails;

public interface TOTPRepository extends MongoRepository<TOTPDetails, String>{

	TOTPDetails findByUsername(String username);
	boolean existsByUsername(String username);
	Long deleteByUsername(String username);
	
}
