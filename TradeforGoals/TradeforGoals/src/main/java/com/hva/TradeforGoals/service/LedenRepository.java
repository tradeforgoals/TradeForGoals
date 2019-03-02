package com.hva.TradeforGoals.service;

import com.hva.TradeforGoals.entiteiten.Lid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedenRepository extends CrudRepository<Lid, Long>{

}
