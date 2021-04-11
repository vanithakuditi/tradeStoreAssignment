/**
 * 
 */
package com.tradestore.TradeStroreAssignment.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Vanitha
 *
 */

@Entity
@Table(name = "Trades")
public class Trade {
	
	@Id
	private String tradeId;
	private int version;
	private String counterPartyId;
	private String bookId;
	private LocalDate maturityDate;
	private LocalDate createdDate;
	private String expired;
	/**
	 * @return the tradeId
	 */
	public String getTradeId() {
		return tradeId;
	}
	/**
	 * @param tradeId2 the tradeId to set
	 */
	public void setTradeId(String tradeId2) {
		this.tradeId = tradeId2;
	}
	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}
	/**
	 * @return the counterPartyId
	 */
	public String getCounterPartyId() {
		return counterPartyId;
	}
	/**
	 * @param counterPartyId the counterPartyId to set
	 */
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}
	/**
	 * @return the bookId
	 */
	public String getBookId() {
		return bookId;
	}
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return the maturityDate
	 */
	public LocalDate getMaturityDate() {
		return maturityDate;
	}
	/**
	 * @param maturityDate the maturityDate to set
	 */
	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}
	/**
	 * @return the createdDate
	 */
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the expired
	 */
	public String getExpired() {
		return expired;
	}
	/**
	 * @param expired the expired to set
	 */
	public void setExpired(String expired) {
		this.expired = expired;
	}
	
	
}
