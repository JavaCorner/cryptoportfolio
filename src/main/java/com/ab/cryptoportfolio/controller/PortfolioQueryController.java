package com.ab.cryptoportfolio.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ab.cryptoportfolio.model.AddTransactionToPortfolioDto;
import com.ab.cryptoportfolio.model.DeleteTransactionsDto;
import com.ab.cryptoportfolio.model.ListTransactionsDto;
import com.ab.cryptoportfolio.model.TransactionDetailsDto;
import com.ab.cryptoportfolio.service.PortfolioQueryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PortfolioQueryController {

	private final PortfolioQueryService portfolioService;

	@GetMapping("/")
	public String index() {
		return "redirect:/portfolio";
	}
	
	@GetMapping("/portfolio")
	public ModelAndView positions() {
		ModelAndView model = new ModelAndView();
		model.addObject("positionsResponse", portfolioService.getPortfolioPositions());
		model.addObject("transaction", new AddTransactionToPortfolioDto());
		return model;
	}
	
	@GetMapping(value = {"/portfolio/transactions","/portfolio/transactions/{symbol}"})
	public ModelAndView listTransactionsForPortfolio(@PathVariable Optional<String> symbol) {
		ListTransactionsDto transactions = portfolioService.getPortfolioTransactions();
		ModelAndView model = new ModelAndView();
		if(symbol.isPresent()) {
			List<TransactionDetailsDto> symbolTrans = transactions.getTransactions().stream().filter(trans -> symbol.get().equals(trans.getSymbol())).collect(Collectors.toList());
			model.addObject("transactions",symbolTrans);
		} else {
			model.addObject("transactions",transactions.getTransactions());
		}
		model.addObject("selected",new DeleteTransactionsDto());
		model.setViewName("transactions");
		return model;
	}
	
}