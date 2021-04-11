/**
 * 
 */
package com.tradestore.TradeStroreAssignment.util;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.tradestore.TradeStroreAssignment.entity.Trade;

/**
 * @author Vanitha
 * 
 * Validator Class
 *
 */
@Component
public class TradeValidator {
	
	/**
	 * @param trade
	 * @param oldTrade
	 * @return boolean
	 * 
	 * validation 1:
	 * During transmission if the lower version is being received by the store it will reject the trade and throw an exception.
	 * If the version is same it will override the existing record.
	 * 
	 */
	public boolean validateVersion(Trade trade, Trade oldTrade) {
		if (trade.getVersion() >= oldTrade.getVersion()) {
			return true;
		}
		return false;
	}
	
	/**
	 * @param trade
	 * @return boolean
	 * 
	 * Validaton2 :Store should not allow the trade which has less maturity date then today date
	 * 
	 */
	public boolean validateMaturityDate(Trade trade) {
		return trade.getMaturityDate().isBefore(LocalDate.now()) ? false : true;
	}
}
