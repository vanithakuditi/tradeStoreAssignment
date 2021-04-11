package com.tradestore.TradeStroreAssignment.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.tradestore.TradeStroreAssignment.service.TradeService;

public class TradeExpiryFlagJob {
	private static final Logger log = LoggerFactory.getLogger(TradeExpiryFlagJob.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	TradeService tradeService;

	@Scheduled(cron = "${trade.expiry.schedule}")
	public void reportCurrentTime() {
		log.info("Begin : Updating trade expiry flags");
		tradeService.updateExpiryFlagOfTrade();
		log.info("End : Updating trade expiry flags");
	}
}
