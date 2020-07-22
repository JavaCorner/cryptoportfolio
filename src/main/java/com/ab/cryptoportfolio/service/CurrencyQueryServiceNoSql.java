package com.ab.cryptoportfolio.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ab.cryptoportfolio.entity.CryptoCurrency;
import com.ab.cryptoportfolio.model.CryptoCurrencyDto;
import com.ab.cryptoportfolio.repository.CryptoCurrencyRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CurrencyQueryServiceNoSql implements CurrencyQueryService {

	private final CryptoCurrencyRepository cryproRepository;
	private Map<String, CryptoCurrencyDto> cryptoCurrencies = null;

	@Override
	public List<CryptoCurrencyDto> getSupportedCryptoCurrencies() {
		if(this.cryptoCurrencies == null) {
			this.cryptoCurrencies = new HashMap<>();
			for(CryptoCurrency currency : cryproRepository.findAll()) {
				this.cryptoCurrencies.put(currency.getSymbol(), new CryptoCurrencyDto(currency.getSymbol(), currency.getName()));
			}
		}
		return new ArrayList<>(cryptoCurrencies.values());
	}

	@Override
	public CryptoCurrencyDto getCryptoCurrency(String symbol) {
		return cryptoCurrencies.get(symbol);
	}
	
}
