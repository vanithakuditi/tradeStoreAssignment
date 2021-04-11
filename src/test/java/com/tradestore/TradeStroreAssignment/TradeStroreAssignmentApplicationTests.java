package com.tradestore.TradeStroreAssignment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tradestore.TradeStroreAssignment.controller.TradeController;
import com.tradestore.TradeStroreAssignment.entity.Trade;
import com.tradestore.TradeStroreAssignment.util.TradeValidator;

@SpringBootTest
class TradeStroreAssignmentApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private TradeController tradeController;
	
	
	@Test
	void testTradeValidateAndStore_successful() {
		ResponseEntity responseEntity = tradeController.tradeValidateStore(createTrade("T1",1,LocalDate.now()));
		Assertions.assertEquals(ResponseEntity.status(HttpStatus.OK).build(),responseEntity);
		List<Trade> tradeList =tradeController.findAllTrades();
		Assertions.assertEquals(1, tradeList.size());
		Assertions.assertEquals("T1",tradeList.get(0).getTradeId());
	}
	
	@Autowired
	TradeValidator validator;
	
	@Test
	void validateVersionTest() {
		assertTrue(validator.validateMaturityDate(createTrade("T1",1,LocalDate.now())));
		assertFalse(validator.validateMaturityDate(createTrade("T1",1,LocalDate.MIN)));
	}
	
	@Test
	void validateMaturityDateTest() {
		assertTrue(validator.validateVersion(createTrade("T1",2,LocalDate.now()), createTrade("T1",1,LocalDate.now())));
		assertFalse(validator.validateVersion(createTrade("T1",1,LocalDate.now()), createTrade("T1",2,LocalDate.now())));
		
		
	}

	
	private Trade createTrade(String tradeId,int version,LocalDate  maturityDate){
		Trade trade = new Trade();
		trade.setTradeId(tradeId);
		trade.setBookId(tradeId+"B1");
		trade.setVersion(version);
		trade.setCounterPartyId(tradeId+"CP1");
		trade.setMaturityDate(maturityDate);
		trade.setExpired("Y");
		return trade;
	}

	public static LocalDate getLocalDate(int year,int month, int day){
		LocalDate localDate = LocalDate.of(year,month,day);
		return localDate;
	}


}
