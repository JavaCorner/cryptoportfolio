package com.ab.cryptoportfolio.service;

import java.util.List;

import com.ab.cryptoportfolio.model.SupportQueryDto;

public interface SupportQueryService {

	List<SupportQueryDto> getSupportQueriesForUser();
	SupportQueryDto getSupportQueryById(String queryId);
	List<SupportQueryDto> getSupportQueriesForAllUsers();
	
}
