package com.ab.cryptoportfolio.service;

import com.ab.cryptoportfolio.model.CreateSupportQueryDto;
import com.ab.cryptoportfolio.model.PostDto;

public interface SupportCommandService {

	void createQuery(CreateSupportQueryDto query);
	void postToQuery(PostDto supportQueryPostModel);
	void resolveQuery(String id);
	
}
