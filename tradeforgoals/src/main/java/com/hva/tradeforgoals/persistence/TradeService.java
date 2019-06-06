package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TradeService {

    private TradeRepository tradeRepository;

    public void setTradeRepository(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public Iterable<Trade> findAll(){
        return tradeRepository.findAll();
    }

    public Trade findById(Long id){
        Optional<Trade> trade = tradeRepository.findById(id);
        return trade.orElse(null);
    }

    public Trade save(Trade trade){
        return tradeRepository.save(trade);
    }

}
