package com.ab.cryptoportfolio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ab.cryptoportfolio.entity.Portfolio;

public interface PortfolioRepository extends MongoRepository<Portfolio, String> {
	
	Portfolio findByUsername(String username);
	boolean existsByUsername(String username);
}
