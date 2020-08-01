package com.ab.cryptoportfolio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ab.cryptoportfolio.entity.Verification;

public interface VerificationCodeRepository extends MongoRepository<Verification, String>{
	
	Verification findByUsername(String username);
	boolean existsByUsername(String username);
}
