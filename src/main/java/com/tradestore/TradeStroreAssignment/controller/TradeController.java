/**
 * 
 */
package com.tradestore.TradeStroreAssignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tradestore.TradeStroreAssignment.entity.Trade;
import com.tradestore.TradeStroreAssignment.exceptions.InvalidTradeException;
import com.tradestore.TradeStroreAssignment.service.TradeService;

/**
 * @author Vanitha
 *
 */

@RestController
public class TradeController {

	@Autowired
	TradeService tradeService;

	@PostMapping("/trade")
	public ResponseEntity<String> tradeValidateStore(@RequestBody Trade trade) {
		if (tradeService.isValid(trade)) {
			tradeService.persist(trade);
		} else {
			throw new InvalidTradeException(trade.getTradeId() + "  Trade Id is not found");
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/trade")
	public List<Trade> findAllTrades() {
		return tradeService.findAll();
	}

}
