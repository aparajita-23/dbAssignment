package com.sample.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.sample.domain.TradeEntity;

@Repository
public class TradeRepoImpl{
	
	public static Map<String, List<TradeEntity>> tradeStore = new HashMap<String, List<TradeEntity>>();
	
	public TradeEntity saveTrade(TradeEntity te) {
		if(tradeStore.get(te.getTradeId()) == null) {
			List<TradeEntity> tradeList = new ArrayList<TradeEntity>();
			tradeList.add(te);
			tradeStore.put(te.getTradeId(), tradeList);
		}else
			tradeStore.get(te.getTradeId()).add(te);
		return te;		
	}
	
	public List<TradeEntity> getTradeById(String tradeId) {
		return tradeStore.get(tradeId).stream()
				.sorted(Comparator.comparing(TradeEntity::getVersion).reversed())
				.collect(Collectors.toList());
	}
	
	
	
}
