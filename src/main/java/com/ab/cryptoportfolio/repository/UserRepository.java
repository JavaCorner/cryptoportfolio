package com.ab.cryptoportfolio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ab.cryptoportfolio.entity.CryptoUser;

public interface UserRepository extends MongoRepository<CryptoUser, String> {

	CryptoUser findByUsername(String username);
	CryptoUser findByEmail(String email);
	
}
