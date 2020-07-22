package com.ab.cryptoportfolio.service;

import java.util.List;

import com.ab.cryptoportfolio.model.CryptoCurrencyDto;

public interface CurrencyQueryService {

	List<CryptoCurrencyDto> getSupportedCryptoCurrencies();
	CryptoCurrencyDto getCryptoCurrency(String symbol);
}
