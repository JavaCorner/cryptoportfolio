package com.ab.cryptoportfolio.service;

import com.ab.cryptoportfolio.model.AddTransactionToPortfolioDto;

public interface PortfolioCommandService {

	void addTransactionToPortfolio(AddTransactionToPortfolioDto request);
	void removeTransactionFromPortfolio(String transactionId);
	void createNewPortfolio(String username);
	boolean userHasAportfolio(String username);
}
