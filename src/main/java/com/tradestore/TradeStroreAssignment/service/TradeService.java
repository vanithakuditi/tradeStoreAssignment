package com.tradestore.TradeStroreAssignment.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradestore.TradeStroreAssignment.entity.Trade;
import com.tradestore.TradeStroreAssignment.repo.TradeRepository;
import com.tradestore.TradeStroreAssignment.util.TradeValidator;

/**
 * @author Vanitha
 * 
 *         TradeService Service class
 *
 */
@Service
public class TradeService {

	@Autowired
	TradeRepository tradeRepository;

	@Autowired
	TradeValidator validator;

	/**
	 * @param trade
	 * @return boolean
	 * 
	 *         Validates a Trade 1. Valid Maturity Date 2. Validate trade version
	 */
	public boolean isValid(Trade trade) {
		if (validator.validateMaturityDate(trade)) {
			Optional<Trade> exsitingTrade = tradeRepository.findById(trade.getTradeId());
			if (exsitingTrade.isPresent()) {
				return validator.validateVersion(trade, exsitingTrade.get());
			} else {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param trade
	 * 
	 * Method to persist trade data
	 * 
	 */
	public void persist(Trade trade) {
		trade.setCreatedDate(LocalDate.now());
		tradeRepository.save(trade);
	}

	/**
	 * @return trade list
	 * 
	 * Method to retrive all trades
	 */
	public List<Trade> findAll() {
		return tradeRepository.findAll();
	}

	/**
	 * Method to automatically update expire flag if in a store the trade crosses
	 * the maturity date.
	 */
	public void updateExpiryFlagOfTrade() {
		tradeRepository.findAll().stream().forEach(t -> {
			if (!validator.validateMaturityDate(t)) {
				t.setExpired("Y");
				tradeRepository.save(t);
			}
		});
	}

}
