package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Lid;
import org.springframework.data.repository.CrudRepository;

public interface LedenRepository extends CrudRepository<Lid, Long> {
}
