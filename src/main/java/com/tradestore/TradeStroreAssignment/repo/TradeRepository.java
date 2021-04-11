/**
 * 
 */
package com.tradestore.TradeStroreAssignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tradestore.TradeStroreAssignment.entity.Trade;

/**
 * @author Vanitha
 *
 */
@Repository
public interface TradeRepository extends JpaRepository<Trade,String>{

}
