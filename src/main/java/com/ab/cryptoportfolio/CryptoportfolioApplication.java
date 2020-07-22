package com.ab.cryptoportfolio;

import com.ab.cryptoportfolio.entity.CryptoCurrency;
import com.ab.cryptoportfolio.entity.Portfolio;
import com.ab.cryptoportfolio.repository.CryptoCurrencyRepository;
import com.ab.cryptoportfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;

@SpringBootApplication
@RequiredArgsConstructor
public class CryptoportfolioApplication {
	private final PortfolioRepository portfolioRepository;
	private final CryptoCurrencyRepository cryptoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CryptoportfolioApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void intializeUserData() {
		CryptoCurrency bitcoin = new CryptoCurrency("BTC", "Bitcoin");
		CryptoCurrency litecoin = new CryptoCurrency("LTC", "Litecoin");
		cryptoRepository.save(bitcoin);
		cryptoRepository.save(litecoin);
		portfolioRepository.save(new Portfolio("user", new ArrayList<>()));
	}
}
