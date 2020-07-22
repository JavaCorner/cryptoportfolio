package com.ab.cryptoportfolio.service;

import com.ab.cryptoportfolio.model.ListTransactionsDto;
import com.ab.cryptoportfolio.model.PortfolioPositionsDto;

public interface PortfolioQueryService {

	PortfolioPositionsDto getPortfolioPositions();
	ListTransactionsDto getPortfolioTransactions();
	
}
