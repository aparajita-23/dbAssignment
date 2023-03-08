package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.domain.TradeEntity;
import com.sample.service.TradeService;

@RestController
public class TradeController {
	
	@Autowired
	TradeService tradeService;
	
	@PostMapping(path = "/saveTrade")
	public String saveTrade(@RequestBody TradeEntity te) throws Exception{
		tradeService.saveTrade(te);			
		return "Trade Saved Successfully";
	}
	
	@GetMapping(path="/findTrades")
	public List<TradeEntity> getTrades(String tradeId){
		return tradeService.getTrades(tradeId);
	}

}
