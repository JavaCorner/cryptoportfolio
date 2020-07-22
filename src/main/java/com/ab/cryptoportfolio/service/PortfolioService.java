package com.ab.cryptoportfolio.service;

import java.util.List;

import com.ab.cryptoportfolio.entity.CryptoCurrency;
import com.ab.cryptoportfolio.entity.Portfolio;
import com.ab.cryptoportfolio.model.AddTransactionToPortfolioDto;
import com.ab.cryptoportfolio.model.ListTransactionsDto;
import com.ab.cryptoportfolio.model.PortfolioPositionsDto;

public interface PortfolioService {

	List<CryptoCurrency> getSupportedCryptoCurrencies();
	Portfolio getPortfolioForUsername(String username);
	PortfolioPositionsDto getPortfolioPositions(String username);
	void addTransactionToPortfolio(AddTransactionToPortfolioDto request);
	ListTransactionsDto getPortfolioTransactions(String username);
	void removeTransactionFromPortfolio(String username, String transactionId);
	
}
