package com.sample.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.domain.TradeEntity;
import com.sample.repository.TradeRepoImpl;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class TradeServiceTest {
	
	@Mock
	TradeRepoImpl tradeRepo;
	
	@InjectMocks 
	TradeService tradeService;
	
	private TradeEntity trdObj;
	private TradeEntity trdObj1;
	private TradeEntity trdObj2;
	private TradeEntity trdObj3;
	private TradeEntity trdObj4;
	private TradeEntity trdObj5;

	@BeforeAll
	public void setUpBeforeClass() throws Exception {
		trdObj = new  TradeEntity("T1",2,"CPY1","BK1", LocalDate.of(2023,3,15),LocalDate.of(2023,2, 28), false);
		trdObj1 = new  TradeEntity("T2",1,"CPY2","BK2", LocalDate.of(2023,3,11),LocalDate.of(2023,2, 28), false);
		trdObj2 = new  TradeEntity("T2",2,"CPY1","BK1", LocalDate.of(2023,3,4),LocalDate.of(2023,2, 28), false);
		trdObj3 = new  TradeEntity("T1",1,"CPY1","BK1", LocalDate.of(2023,3,2),LocalDate.of(2023,2, 28), false);
		List<TradeEntity> td1 = new ArrayList<>();
		td1.add(trdObj);td1.add(trdObj3);
		List<TradeEntity> td2 = new ArrayList<>();
		td2.add(trdObj1);td2.add(trdObj2);
		
		TradeRepoImpl.tradeStore.put(trdObj.getTradeId(), td1);
		TradeRepoImpl.tradeStore.put(trdObj1.getTradeId(), td2);

		trdObj4 = TradeEntity.builder().tradeId("T1").version(3).bookId("BK12").counterpartyId("CPY12")
				.maturityDate(LocalDate.of(2023,03,7)).createdDate(LocalDate.of(2023,03,5)).isExpired(false).build();
		trdObj5 = TradeEntity.builder().tradeId("T1").version(1).bookId("BK14").counterpartyId("CPY14")
				.maturityDate(LocalDate.of(2023,03,9)).createdDate(LocalDate.of(2023,03,5)).isExpired(false).build();
	}

	@Test
	final void testSaveTrade() throws Exception {
		when(tradeRepo.saveTrade(any())).thenReturn(trdObj);
	    tradeService.saveTrade(trdObj);
	    verify(tradeRepo,times(1)).saveTrade(any());
	}

	@Test
	final void testValidateMaturityDateForTrade() {		
		assertTrue(tradeService.validateMaturityDateForTrade(trdObj));
		assertTrue(tradeService.validateMaturityDateForTrade(trdObj1));
		assertFalse(tradeService.validateMaturityDateForTrade(trdObj2));
		assertFalse(tradeService.validateMaturityDateForTrade(trdObj3));
	}

	@Test
	final void testValidateTradeVersion() {
		assertTrue(tradeService.validateTradeVersion(trdObj4));
		assertFalse(tradeService.validateTradeVersion(trdObj5));
	}

}
