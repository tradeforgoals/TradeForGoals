package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Advertisement;
import org.springframework.data.repository.CrudRepository;

public interface AdvertisementRepository extends CrudRepository <Advertisement, Long> {

}
