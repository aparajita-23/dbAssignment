package com.sample.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.sample.domain.TradeEntity;
import com.sample.repository.TradeRepoImpl;

/*
 * A Scheduler which will check for trade maturity date and 
 * set them to expired if date is past maturity date.
 */

@EnableScheduling
public class CheckExpiredTrade {
	
	@Scheduled(/* fixedRate = 1000 * 3600 * 24 */cron = "0 0 0 * * *", zone = "Asia/Kolkata")
	public void checkIfExpired() {
		
		for(Entry<String, List<TradeEntity>> trade: TradeRepoImpl.tradeStore.entrySet()) {			
			trade.getValue().forEach(t -> {
				if(t.getMaturityDate().isBefore(LocalDate.now())) {
					t.setIsExpired(true);
				}
			});
		}	
	}
}
