package com.sample.domain;

import java.util.Comparator;

public class TradeVersionCompare implements Comparator<TradeEntity>{

	@Override
	public int compare(TradeEntity o1, TradeEntity o2) {
		if(o1.getTradeId() == o2.getTradeId()) {
			return o1.getVersion() - o2.getVersion();
		}
		return 0;
	}
}
