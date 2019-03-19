package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Trade;
import org.springframework.data.repository.CrudRepository;

public interface TradeRepository extends CrudRepository<Trade, Long> {
}
