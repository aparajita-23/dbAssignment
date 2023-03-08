package com.sample.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.domain.TradeEntity;
import com.sample.exception.InvalidTradeException;
import com.sample.repository.TradeRepoImpl;

@Service
public class TradeService {
	
	@Autowired
	TradeRepoImpl tradeRepo;
	
	public boolean saveTrade(TradeEntity te) throws Exception{
		if(validateMaturityDateForTrade(te) && validateTradeVersion(te))
			tradeRepo.saveTrade(te);						
		else 
			throw new InvalidTradeException("Trade received in not valid.");
		return true;
	}
	
	public boolean validateMaturityDateForTrade(TradeEntity te) {
		return te.getMaturityDate().isBefore(LocalDate.now())?false:true;				
	}
	
	public boolean validateTradeVersion(TradeEntity te) {
		List<TradeEntity> trd = tradeRepo.getTradeById(te.getTradeId());
		return trd.stream()
				.findFirst().get().getVersion() > te.getVersion();	
	}
	
	public List<TradeEntity> getTrades(String trdId){
		return tradeRepo.getTradeById(trdId);
	}
}
